package Todo.examples.Pages;
import Todo.examples.Base.BasePage;
import Todo.examples.utilies.propertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver)
    {super(driver);}

    @FindBy(id = "email")
    private WebElement emailinput;

    @FindBy(id = "password")
    private WebElement passwordinput;

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    private WebElement submit;

    @FindBy(xpath = "//a[contains(text(),'Signup')]")
    private WebElement signup;

    @FindBy(xpath = "//input[@data-testid=\"first-name\"]")
    private WebElement EnterFirstName;


    @FindBy(xpath = "//input[@data-testid=\"last-name\"]")
    private WebElement EnterLastName;

    @FindBy(xpath = "//input[@data-testid=\"email\"]")
    private WebElement EnterEmail;

    @FindBy(xpath = "//input[@data-testid=\"password\"]")
    private WebElement EnterPassword;

    @FindBy(xpath = "//input[@data-testid=\"confirm-password\"]")
    private WebElement EnterConfirmPassword;

    @FindBy(xpath = "//button[@data-testid=\"submit\"]")
    private WebElement ClickSignUpButton;

      @Step
      public LoginPage loadpage()
    {
//        Properties props= propertiesUtils.loadProperties("src/test/java/Todo/examples/config/production.properties");
//        driver.get(props.getProperty("baseUrl"));
        driver.get("https://qacart-todo.herokuapp.com");
        return this;
    }
    @Step
    public TodoPage Signup(String Fname,String Lname,String Email,String password,String confirmPassword)
    {
        signup.click();
        EnterFirstName.sendKeys(Fname);
        EnterLastName.sendKeys(Lname);
        EnterEmail.sendKeys(Email);
        EnterPassword.sendKeys(password);
        EnterConfirmPassword.sendKeys(confirmPassword);
        ClickSignUpButton.click();
        return new TodoPage(driver);
    }
    @Step
      public TodoPage login(String email,String password)
    {
        emailinput.sendKeys(email);
        passwordinput.sendKeys(password);
        submit.click();
        return new TodoPage(driver);
    }
}
