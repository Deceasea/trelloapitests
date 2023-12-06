import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("Create Board")
@Feature("Create Board")
public class CreateBoard extends TrelloApiTests {
    @Test
    @Description("Create a new board")
    public void createBoard() {
        given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .queryParam("name", BOARD_NAME)
                .contentType("application/json")
                .when()
                .log().all()
                .post("/boards")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo(BOARD_NAME));
    }

}
