import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DynamicJson {

    static String addBookPayloadPath = "/Users/ishansharma/Automation/restAssuredDemo/src/test/resources/addBookPayload.json";

    @Test(dataProvider = "BooksData")
    public void addBook(String isbnNo,String aisleNo) throws Exception {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().header("Content-Type","application/json")
    //                        .body(Payload.AddBook(isbnNo,aisleNo))
                                .body(generateStringFromPayloadFile(addBookPayloadPath))
                //when want to use static json file to read json payload
                        .when()
                            .post("/Library/Addbook.php")
                        .then().log().all().assertThat().statusCode(200)
                            .extract().response().asString();
        JsonPath js = ReUsableMethods.rawToJson(response);
        String id = js.getString("ID");
        System.out.println(id);
    }

    public String generateStringFromPayloadFile(String addBookPayloadPath) throws Exception {
        return new String (Files.readAllBytes(Paths.get(addBookPayloadPath))); //takes Files path --> read all bytes from it and new String converts it to String to be sent to body method
    }

    @DataProvider(name="BooksData")
    public Object[][] getData(){
        return new Object[][] {{"xyz234","098"},{"xyz345","078"},{"xyz456","067"}};
    }
}


