package general;

import lombok.Getter;

@Getter
public class Variables {

    static String testPropertyFile = "test.properties";

    /**
     * Username at the login page
     */
    public static String getSearchingWord(){
        return ReadFromProperties.readProperty(testPropertyFile, "searchingWord");
    }

    /**
     * generalFiles.General.General.Driver type: for FireFox, Chrome,
     */
    public static String getDriverType(){
        return ReadFromProperties.readProperty(testPropertyFile, "driverType");
    }

}

