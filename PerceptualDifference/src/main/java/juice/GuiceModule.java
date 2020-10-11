package juice;

import com.google.inject.Binder;
import com.google.inject.Module;

import cucumber.api.guice.CucumberScopes;

public class GuiceModule implements Module {
    public void configure(
            Binder binder) {

        // install(new WebDriverModule());
        // bind(getDriver.class).to(MyWebDriver.class).in(CucumberScopes.SCENARIO);
        // binder.bind(WebDriver.class).to(FirefoxDriver.class);
        // binder.bind(WebDriver.class).toProvider(GuiceProvider.class).in(CucumberScopes.SCENARIO);
        // binder.bind(driverInterface.class).to(driverClass.class).in(CucumberScopes.SCENARIO);
        binder.bind(driverClass.class).in(CucumberScopes.SCENARIO);

    }
}