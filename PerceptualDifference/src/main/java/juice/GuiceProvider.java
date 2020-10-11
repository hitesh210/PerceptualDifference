package juice;

import org.openqa.selenium.WebDriver;

import support.MyWebDriver;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class GuiceProvider implements Provider<WebDriver> {
    private final WebDriver webDriver;

    @Inject
    public GuiceProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver get() {
        return new MyWebDriver().create(webDriver);
    }
}
