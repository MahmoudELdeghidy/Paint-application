package Todo.examples.api;

import Todo.examples.config.EndPoints;
import Todo.examples.objects.Users;
import Todo.examples.utilies.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String UserID;
    private String firstName;


    public String getUserID() {
        return this.UserID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public List<Cookie> getCookies() {
        return this.restAssuredCookies;
    }


    public void register()
    {
        Users users=UserUtils.generateRandomUsers();
//        String RequestBody="{\n" +
//                "    \"email\":\"test5@gmail.com\",\n" + //convert hard code into pojo class to control the variables easily by setters and getters
//                "    \"firstName\":\"mahmoud\",\n" +
//                "    \"lastName\":\"mohamed\",\n" +
//                "    \"password\":\"123456789\"\n" +
//                "}";
        Response response=
                given()
                        .baseUri("https://qacart-todo.herokuapp.com/")
                        .header("Content-Type","application/json")
                        //.body(RequestBody)
                        .body(users)
                        .log().all()
                .when()
                        .post(EndPoints.ApiRegisterEndPoint)
                .then()
                        .log().all()
                        .extract().response();
        if (response.statusCode()!=201)
        {
            throw new RuntimeException("something went error");
        }

         restAssuredCookies = response.detailedCookies().asList();
         accessToken=response.path("access_token");
         firstName=response.path("firstName");
         UserID=response.path("userID");
    }
}
