package Todo.examples.utilies;

import io.restassured.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookiesUtils {
    public static List<org.openqa.selenium.Cookie> ConvertRestAssuredToSeleniumCookies(List<Cookie>restassuredcookies)
    {
        List<org.openqa.selenium.Cookie> seleniumCookies=new ArrayList<>();
        for (io.restassured.http.Cookie cookie:restassuredcookies)
        {
            org.openqa.selenium.Cookie seleniumCookie=new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue());
            seleniumCookies.add(seleniumCookie);
        }
        return seleniumCookies;
    }
}
