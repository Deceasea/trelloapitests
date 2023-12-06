import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("CreateBoard")
@Feature("Create Card")
public class TagForBoard extends TrelloApiTests {
    @Test
    @Description("Create the tag for board")
    public void createTagForBoard() {
        String boardId = getBoardIdByName(BOARD_NAME);

        given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .queryParam("name", TAG_NAME)
                .contentType(ContentType.JSON)
                .when()
                .post("/boards/{boardId}/labels", boardId)
                .then()
                .statusCode(200)
                .body("name", equalTo(TAG_NAME));
    }

    String getBoardIdByName(String boardName) {
        return given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .when()
                .get("/members/me/boards")
                .then()
                .statusCode(200)
                .extract()
                .path("find { it.name == '" + boardName + "' }.id");
    }
}
