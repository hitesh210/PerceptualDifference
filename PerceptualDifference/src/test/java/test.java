import juice.driverClass;

import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;

public class test {
    private WebDriver wD1, wD2;

    @Inject
    public test(driverClass d) {
        this.wD1 = d.getDriver1();
        this.wD2 = d.getDriver2();
    }

    public void isExists() {
        System.out.println("D1 ====" + wD1.getCurrentUrl());
        System.out.println("D2 ====" + wD2.getCurrentUrl());
    }

}
