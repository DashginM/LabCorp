import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class Task2 {

@Test
    public void test1() {
    String jsonBody = "{\n" +
            "        \"createdAt\": 1631825833,\n" +
            "        \"employee_firstname\": \"TestData12345\",\n" +
            "        \"employee_lastname\": \"TestData12345\",\n" +
            "        \"employee_phonenumbe\": \"264-783-9453\",\n" +
            "        \"ademployee_emaildress\": \"ademployee_emaildress 1\",\n" +
            "        \"citemployee_addressy\": \"citemployee_addressy 1\",\n" +
            "        \"stateemployee_dev_level\": \"stateemployee_dev_level 1\",\n" +
            "        \"employee_gender\": \"employee_gender 1\",\n" +
            "        \"employee_hire_date\": \"2025-10-31T16:35:45.426Z\",\n" +
            "        \"employee_onleave\": true,\n" +
            "        \"tech_stack\": [],\n" +
            "        \"project\": []\n" +
            "    }\n";

    given()
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
            .and()
            .body(jsonBody)
            .when()
            .post("https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1//Users`");
    }


        @Test
        public void getRequest(){
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1//Users");

                response.then().statusCode(200);
    }

    }






