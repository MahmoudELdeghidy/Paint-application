package Todo.examples.testcases;

import Todo.examples.api.RegisterApi;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Dummy1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://qacart-todo.herokuapp.com");

        RegisterApi register=new RegisterApi();
        register.register();


        driver.get("https://qacart-todo.herokuapp.com");


    }

}
