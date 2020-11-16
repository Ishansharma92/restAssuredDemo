import io.restassured.RestAssured;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JiraTest {

        SessionFilter session = new SessionFilter();
        CookieFilter cookie = new CookieFilter();
        private String issueId;
        private String commentId;

    @BeforeSuite
        public void sessionAPI(){
            RestAssured.baseURI = "http://localhost:8080";
            String response = given().contentType("application/json").accept("application/json").header("User-Agent", "PostmanRuntime/7.26.5")
                    .body("{\n" +
                            "    \"username\": \"ishansharma92\",\n" +
                            "    \"password\": \"!d0ntkn0wJira\"\n" +
                            "}\n").log().all().filter(session).when().post("/rest/auth/1/session")
                    .then().log().all().extract().response().asString();
        }

        @Test
        public void createIssue(){
            String response = given().log().all().header("Content-Type", "application/json")
                    .body("{\n" +
                            "    \"fields\": {\n" +
                            "        \"project\": {\n" +
                            "            \"key\": \"RES\"\n" +
                            "        },\n" +
                            "        \"summary\": \"RestAssured Learning - Issue creation via Rest API\",\n" +
                            "        \"issuetype\": {\n" +
                            "            \"name\": \"Bug\"\n" +
                            "        },\n" +
                            "        \"description\": \"Creating an issue via RestAssured\"\n" +
                            "    }\n" +
                            "}").filter(session).when().post("/rest/api/2/issue").then().log().all().assertThat().statusCode(201).extract().response().asString();

            JsonPath js = new JsonPath(response);
            issueId = js.getString("id");
        }

        @Test(dependsOnMethods = "createIssue")
        public void createComment(){
            String response = given().log().all().contentType("application/json").body("{\n" +
                    "    \"body\": \"I have added a comment to the issue successfully\",\n" +
                    "    \"visibility\": {\n" +
                    "        \"type\": \"role\",\n" +
                    "        \"value\": \"Administrators\"\n" +
                    "    }\n" +
                    "}").filter(session).when().post("/rest/api/2/issue/"+issueId+"/comment").then().log().all().assertThat().statusCode(201).extract().response().asString();

            JsonPath js = new JsonPath(response);
            commentId = js.getString("id");
        }

    @Test(dependsOnMethods = "createComment")
    public void updateComment(){
        String response = given().log().all().contentType("application/json").body("{\n" +
                "    \"body\": \"I have updated a comment to the issue successfully\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}").filter(session).when().put("/rest/api/2/issue/"+issueId+"/comment/"+commentId).then().log().all().assertThat().statusCode(200).extract().response().asString();
    }

}
