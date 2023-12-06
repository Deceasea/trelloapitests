import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("CreateBoard")
@Feature("Create Card")
@OrderWith(Alphanumeric.class)
public class CreateCard extends TrelloApiTests {
    @Test
    @Description("Create list at the board")
    public void create_1_List() {
        String boardId = getBoardIdByName(BOARD_NAME);

        given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .queryParam("name", LIST_NAME)
                .queryParam("idBoard", boardId)
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .post("/lists")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo(LIST_NAME));
    }

    @Test
    @Description("Create card in the list")
    public void create_2_Card() {
        String boardId = getBoardIdByName(BOARD_NAME);
        String listId = getListIdByName(boardId, LIST_NAME);

        given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .queryParam("name", CARD_NAME)
                .queryParam("idList", listId)
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .post("/cards")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo(CARD_NAME));
    }

    String getBoardIdByName(String boardName) {
        return given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .when()
                .log().all()
                .get("/members/me/boards")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("find { it.name == '" + boardName + "' }.id");
    }

    String getListIdByName(String boardId, String listName) {
        return given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .when()
                .log().all()
                .get("/boards/" + boardId + "/lists")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("find { it.name == '" + listName + "' }.id");
    }
}
