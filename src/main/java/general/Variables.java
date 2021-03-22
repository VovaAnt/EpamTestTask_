package general;

import lombok.Getter;

@Getter
public class Variables {

    static String testPropertyFile = "src/test/resources/Test.properties";

    public static String getBrowserType(){
        return ReadFromProperties.readProperty(testPropertyFile, "browserType");
    }
}
