package Todo.examples.testcases;

import Todo.examples.Base.BaseTest;
import Todo.examples.Pages.LoginPage;
import Todo.examples.Pages.NewTodoPage;
import Todo.examples.Pages.TodoPage;
import Todo.examples.api.RegisterApi;
import Todo.examples.api.TasksApi;
import Todo.examples.factory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature("Todo Feature")
public class TodoTest extends BaseTest {
    @Story("Add Todo")
    @Test(description = "should be able to Add a new task")
    public void shouldAbleToAddNewTodo()
    {
        RegisterApi registerApi=new RegisterApi();
        registerApi.register();

        NewTodoPage newtodoPage=new NewTodoPage(getDriver());
        newtodoPage.VisitNewToDoPage();
        injectCookiesToBrowser(registerApi.getCookies());
        //String actualResult =
                         newtodoPage
                        .VisitNewToDoPage()
                        .addNewTask("selenium");
                        //.getTodoText();
       // Assert.assertEquals(actualResult,"selenium");


//        LoginPage log=new LoginPage(driver);
//        log
//                .loadpage()          //builder pattern to make a chain from method to method to make more readable test cases
//                .login("caf.eldeghidy@gmail.com","123456789");
//
//        //TodoPage todo=log.Signup("mahmoud","mohamed","caf.eldeghidy@gmail.com","123456789","123456789");
    }
    @Story("Delete Todo")
    @Test(description = "should be able to delete a new task")
    public void ShouldBeAbleDeleteNewTodo()
    {
        RegisterApi registerApi=new RegisterApi();
        registerApi.register();

        TasksApi tasksApi=new TasksApi();
        tasksApi.addTask(registerApi.getAccessToken());

        TodoPage todoPage=new TodoPage(getDriver());
        todoPage.VisitToDoPage();
        injectCookiesToBrowser(registerApi.getCookies());

       // boolean isNoTodoMessageDisplaied=
                todoPage
                .VisitToDoPage();
                //.clickOnDeleteButton()
                //.isNoTodoMessageDisplaied();

       // Assert.assertTrue(isNoTodoMessageDisplaied);
    }
}
