import juice.driverClass;
import ImageProcessing.ImageProcessing;

import com.google.inject.Inject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class EndecaUpgradeStepDefs {
    private driverClass d;
    private ImageProcessing imageProcessing;
    private EndecaUpgrade endecaUpgrade;

    @Inject
    public EndecaUpgradeStepDefs(driverClass d, ImageProcessing imageProcessing, EndecaUpgrade endecaUpgrade) {
        super();
        this.imageProcessing = imageProcessing;
        this.endecaUpgrade = endecaUpgrade;
    }

    @Given("^I open (.*) and (.*) at (.*)$")
    public void i_open_for_and_pages(
            String url1, String url2, String pageNo)
            throws Throwable {
        endecaUpgrade.openEndecaPage(url1, url2, pageNo);
    }

    @Then("^I should see comparison for (.*)$")
    public void i_should_see_comparison_for(
            String pageNo)
            throws Throwable {
        imageProcessing.isImagesSame(pageNo);
    }

}
