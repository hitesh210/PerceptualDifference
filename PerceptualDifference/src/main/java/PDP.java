import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import juice.driverClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ImageProcessing.ImageProcessing;
import SiteContext.siteContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;

import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class PDP {

    private WebDriver wD1, wD2;
    private ImageProcessing imageProcessing;
    private siteContext context;

    private static final String HEADER_SEARCH_BOX_KEY = "header.global-searchbox";
    private static final String HEADER_GO_BUTTON_KEY = "header.go-button";

    @Inject
    public PDP(driverClass d, ImageProcessing imageProcessing, siteContext context) {
        this.wD1 = d.getDriver1();
        this.wD2 = d.getDriver2();
        this.imageProcessing = imageProcessing;
        this.context = context;
    }

    public void openPage(
            String productType)
            throws Throwable {
        searchProduct(productType);
        imageProcessing.saveScreenshot(productType);
    }

    public void searchProduct(
            String productType)
            throws Throwable {
        wD1.findElement(By.id((String) context.getLocatorsMap().get(HEADER_SEARCH_BOX_KEY))).click();
        wD1.findElement(By.id((String) context.getLocatorsMap().get(HEADER_SEARCH_BOX_KEY))).sendKeys(
                findProduct(productType));
        wD1.findElement(By.id((String) context.getLocatorsMap().get(HEADER_GO_BUTTON_KEY))).click();
        wD2.findElement(By.id((String) context.getLocatorsMap().get(HEADER_SEARCH_BOX_KEY))).click();
        wD2.findElement(By.id((String) context.getLocatorsMap().get(HEADER_SEARCH_BOX_KEY))).sendKeys(
                findProduct(productType));
        wD2.findElement(By.id((String) context.getLocatorsMap().get(HEADER_GO_BUTTON_KEY))).click();
        Thread.sleep(2000);
    }

    public Products[] getProductData()
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\test\\resources\\config\\products.json"));
        Gson gson = new GsonBuilder().create();
        Products[] productValues = gson.fromJson(br, Products[].class);
        return productValues;
    }

    public String findProduct(
            String productType)
            throws IOException {
        Products[] productValues = getProductData();
        for (Products products : productValues) {
            if (products.getMnsProductSubType().equals(productType))
                return products.getId();
        }
        return null;
    }

}
