package Todo.examples.api;

import Todo.examples.config.EndPoints;
import Todo.examples.objects.Tasks;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TasksApi {

    public void addTask(String token)
    {
        Tasks tasks=new Tasks("selenium",false);
      Response response = given().baseUri("https://qacart-todo.herokuapp.com/")
                .header("Content-Type","application/json")
                .body(tasks)
                .auth().oauth2(token)
        .when()
                .post(EndPoints.ApiTaskEndPoint)
        .then()
                .log().all().extract().response();
      if (response.statusCode()!=201)
      {
          throw new RuntimeException("something wrong in adding the todo");
      }
    }
}
