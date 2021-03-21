package general;

import lombok.Getter;

@Getter
public class Variables {

    static String testPropertyFile = "test.properties";

    public static String getSearchingWord(){
        return ReadFromProperties.readProperty(testPropertyFile, "searchingWord");
    }

    public static String getSearchingDomain(){
        return ReadFromProperties.readProperty(testPropertyFile, "searchingWord");
    }

    public static String getBrowserType(){
        return ReadFromProperties.readProperty(testPropertyFile, "browserType");
    }
}
