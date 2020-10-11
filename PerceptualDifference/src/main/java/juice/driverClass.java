package juice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.inject.Singleton;

@Singleton
public class driverClass {

    private WebDriver wd1;
    private WebDriver wd2;

    public driverClass() {
        wd1 = new FirefoxDriver();
        wd2 = new FirefoxDriver();
    }

    public WebDriver getDriver1() {
        return wd1;
    }

    public WebDriver getDriver2() {
        return wd2;
    }

}
