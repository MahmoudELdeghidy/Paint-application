package Todo.examples.Pages;

import Todo.examples.Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath ="//*[@id=\"root\"]/div[2]/div/div/h2")
    private WebElement welcomeMessage;

    @FindBy(xpath ="//body/div[@id='root']/div[2]/div[1]/div[1]/div[1]/button[1]")
    private WebElement addButton;

    @FindBy(css ="[data-testid=\"todo-item\"]")
    private WebElement todoitem;

    @FindBy(xpath ="//button[@data-testid=\"delete\"]")
    private WebElement DeleteItem;

    @FindBy(xpath ="//h4[@data-testid=\"no-todos\"]")
    private WebElement notodosmessage;
    @Step
    public boolean Welcome_Message_isdisplied(){
        return welcomeMessage.isDisplayed();
    }
    @Step
    public TodoPage VisitToDoPage()
    {
        driver.get("https://qacart-todo.herokuapp.com/todo");
        return this;
    }
    @Step
    public NewTodoPage clickOnPlusButton()
    {
        addButton.click();
        return new NewTodoPage(driver);
    }
    @Step
    public String getTodoText()
    {
       return todoitem.getText();
    } @Step
    public TodoPage clickOnDeleteButton()
    {
        DeleteItem.click();
        return this;
    } @Step
    public boolean isNoTodoMessageDisplaied()
    {
        return notodosmessage.isDisplayed();
    }

}
