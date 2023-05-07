package Todo.examples.testcases;

import Todo.examples.Base.BaseTest;
import Todo.examples.Pages.LoginPage;
import Todo.examples.Pages.TodoPage;
import Todo.examples.factory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature("Auth Feature")
public class LoginTest extends BaseTest {
    LoginPage login;
    @Story("Login with valid email and password ")
    @Test(description = "Test the login functionality")
@Description("IT will able to login by valid email user and valid password")
    public void LoginWithEmailAndPassword()
    {
        login=new LoginPage(getDriver());
        boolean welcomeMessage =
                         login
                        .loadpage()
                        .login("caf.eldeghidy@gmail.com","123456789")
                        .Welcome_Message_isdisplied();
       //TodoPage todo=login.loadpage().Signup("mahmoud","mohamed","caf.eldeghidy@gmail.com","123456789","123456789");

       Assert.assertTrue(welcomeMessage);
    }
}
