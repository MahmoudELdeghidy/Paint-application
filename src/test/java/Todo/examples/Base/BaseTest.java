package Todo.examples.Base;

import Todo.examples.factory.DriverFactory;
import Todo.examples.utilies.CookiesUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BaseTest {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver)
    {
        this.driver.set(driver);
    }
    public WebDriver getDriver()
    {
       return this.driver.get();
    }

    @BeforeMethod
    @Step
    public void setup()
    {
       WebDriver driver=new DriverFactory().InitializeDriver();
       setDriver(driver);
    }

    @AfterMethod
    public void quit(ITestResult result)
    {
       String testcasename= result.getMethod().getMethodName();
       File destfile=new File("target"+File.separator+"screenshots"+File.separator+testcasename+".png");
       takeScreenshot(destfile);
       getDriver().quit();
    }

    public void injectCookiesToBrowser(List<Cookie> RestAssuredCookies)
    {
        List<org.openqa.selenium.Cookie>seleniumCookies=CookiesUtils.ConvertRestAssuredToSeleniumCookies(RestAssuredCookies);
        for (org.openqa.selenium.Cookie cookie:seleniumCookies)
        {
            getDriver().manage().addCookie(cookie);
        }

    }
    public void takeScreenshot( File destfile){
        File file= ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,destfile);
            InputStream is=new FileInputStream(destfile);
            Allure.addAttachment("screenshot",is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
