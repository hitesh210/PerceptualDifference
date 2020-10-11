package Locator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class Locators {

    public String getLocator(
            String locator)
            throws FileNotFoundException {
        Yaml yaml = new Yaml();
        Object data = yaml.load(load());
        // System.out.println(data);
        Map map = (Map) data;
        // System.out.println(map.get("header.global-searchbox"));
        return (String) map.get(locator);
    }

    public Map getAllLocators()
            throws FileNotFoundException {
        Yaml yaml = new Yaml();
        Object data = yaml.load(load());
        // System.out.println(data);
        Map map = (Map) data;
        // System.out.println(map.get("header.global-searchbox"));
        return map;
    }

    public InputStream load()
            throws FileNotFoundException {
        InputStream input = new FileInputStream(new File("src\\test\\resources\\config\\locator.yml"));
        return input;
    }
}
