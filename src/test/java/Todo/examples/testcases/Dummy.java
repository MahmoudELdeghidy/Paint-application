package Todo.examples.testcases;
import Todo.examples.api.RegisterApi;
import Todo.examples.objects.Users;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class Dummy {
    public static void main(String[] args) {

        RegisterApi register=new RegisterApi();
        register.register();
        System.out.println(register.getAccessToken());
        System.out.println(register.getFirstName());
        System.out.println(register.getUserID());





//        Users users=new Users("mahmoud","mohamed","test6@gmail.com","123456789");
////        String RequestBody="{\n" +
////                "    \"email\":\"test5@gmail.com\",\n" + //convert hard code into pojo class to control the variables easily by setters and getters
////                "    \"firstName\":\"mahmoud\",\n" +
////                "    \"lastName\":\"mohamed\",\n" +
////                "    \"password\":\"123456789\"\n" +
////                "}";
//        Response response=
//        given()
//                .baseUri("https://qacart-todo.herokuapp.com/")
//                .header("Content-Type","application/json")
//                //.body(RequestBody)
//                .body(users)
//        .when()
//                .post("/api/v1/users/register")
//        .then()
//                .extract().response();
//      //  System.out.println(response.body().prettyPrint());   //to print the full response body
//        String accessToken = response.path("access_token"); //you can return any part from response body by (path method)
//        System.out.println(accessToken);
    }
}
