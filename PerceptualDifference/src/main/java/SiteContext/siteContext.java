package SiteContext;

import java.util.Map;

import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class siteContext {
    private Map locatorsMap;

    public Map getLocatorsMap() {
        return locatorsMap;
    }

    public void setLocatorsMap(
            Map locatorsMap) {
        this.locatorsMap = locatorsMap;
    }
}
