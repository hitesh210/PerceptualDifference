import java.io.FileNotFoundException;

import juice.driverClass;

import org.openqa.selenium.WebDriver;

import FileProcessing.FileProcessing;
import Locator.Locators;
import SiteContext.siteContext;

import com.google.inject.Inject;

import cucumber.api.java.Before;

public class setup {
    private WebDriver wD1, wD2;
    private FileProcessing fileProcessing;
    private Locators locators;
    private siteContext context;
    private static boolean cleanFlag = false;
    private static boolean dunit = false;

    @Inject
    public setup(driverClass d, FileProcessing fileProcessing, Locators locators, siteContext context) {
        this.wD1 = d.getDriver1();
        this.wD2 = d.getDriver2();
        this.fileProcessing = fileProcessing;
        this.locators = locators;
        this.context = context;
    }

    @Before
    public void launchDrivers()
            throws InterruptedException {
        if (!cleanFlag) {
            fileProcessing.cleanReports();
            cleanFlag = true;
        }
        if (!dunit) {
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    wD1.close();
                    wD2.close();
                    fileProcessing.generateReport("Endeca Upgrade scenarios");
                    return;
                }
            });
            dunit = true;
        }
        try {
            context.setLocatorsMap(locators.getAllLocators());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        wD1.manage().deleteAllCookies();
        wD2.manage().deleteAllCookies();
        wD1.manage().window().maximize();
        // String url1 = "https://www.sit2.marksandspencer.com/"; //commented for endeca upgrade
        // wD1.get(url1); //commented for endeca upgrade
        wD2.manage().window().maximize();
        // String url2 = "https://www.st1.marksandspencer.com/"; //commented for endeca upgrade
        // wD2.get(url2); //commented for endeca upgrade
        // Thread.sleep(5000); //commented for endeca upgrade
    }

    /*
     * commented for endeca upgrade execution
     * @After public void quitDrivers( Scenario scenario) { String scenarioName = scenario.getName();
     * fileProcessing.generateReport(scenarioName); }
     */
}