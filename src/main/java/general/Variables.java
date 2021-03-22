package general;

import lombok.Getter;

@Getter
public class Variables {

    static String testPropertyFile = "src/test/resources/Test.properties";

    public static String getBrowserType() {
        String browserType = "browserType";
        String bt = System.getProperty(browserType);
        if (bt == null) {
            bt = ReadFromProperties.readProperty(testPropertyFile, browserType);
        }
        return bt;
    }
}
