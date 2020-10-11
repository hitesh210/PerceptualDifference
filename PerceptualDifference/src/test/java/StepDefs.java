import juice.driverClass;
import ImageProcessing.ImageProcessing;

import com.google.inject.Inject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class StepDefs {
    private final PDP pDP;
    private final test test1;
    private driverClass d;
    private ImageProcessing imageProcessing;

    @Inject
    public StepDefs(driverClass d, PDP pDP, test test1, ImageProcessing imageProcessing) {
        super();
        this.pDP = pDP;
        this.test1 = test1;
        // this.wD1 = wD1;
        this.imageProcessing = imageProcessing;
    }

    @Given("^I search for a (.*) item on two environment$")
    public void I_search_for_a_item_on_two_environment(
            String productType)
            throws Throwable {
        pDP.openPage(productType);
        // test1.isExists();
    }

    @Then("^I should see page same for (.*) on both environment$")
    public void I_should_see_page_same_on_both_environment(
            String productType)
            throws Throwable {
        // Assert.assertTrue("Page not same.", pDP.isImagesSame());
        imageProcessing.isImagesSame(productType);
        // pDP.overlapImage();
        // pDP.createDiffImage();
    }
}
