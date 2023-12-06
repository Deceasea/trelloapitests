import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class TrelloApiTests {

    public static final String API_KEY = "a5dfbe490bc5eeb09a195b61f49d1b30";
    public static final String TOKEN = "ATTAba1a5329380e7efb0c27f0b948766aaebec6221833320e2b88a00b06843e7bf0781C2A86";
    public static final String BOARD_NAME = "Test Board";
    public static final String TAG_NAME = "Test Tag";
    public static final String LIST_NAME = "Test List";
    public static final String CARD_NAME = "Test Card";

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://api.trello.com/1/";
    }
}
