package Todo.examples.Pages;

import Todo.examples.Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {
    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="[data-testid=\"new-todo\"]")
    private WebElement NewTodoInput;

    @FindBy(css ="[data-testid=\"submit-newTask\"]")
    private WebElement NewTodoSubmit;

    @Step
    public TodoPage addNewTask(String coursename)
    {
        NewTodoInput.sendKeys(coursename);
        NewTodoSubmit.click();
        return new TodoPage(driver);

    }
    @Step
    public NewTodoPage VisitNewToDoPage()
    {
        driver.get("https://qacart-todo.herokuapp.com/todo/new");
        return this;
    }

}
