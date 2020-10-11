package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyWebDriver {

    public WebDriver create(
            WebDriver webDriver) {
        return webDriver = new FirefoxDriver();
    }

}
