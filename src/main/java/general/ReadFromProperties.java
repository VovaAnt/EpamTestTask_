package general;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadFromProperties {
	/**
	 * Reads parameters from a property file
	 * @param filePath - path to a property file with parameters
	 * @param param - parameter name
	 * @return returns a value of matched parameter
	 */
	public static String readProperty (String filePath, String param){
		Properties prop = new Properties();
		String value = null;
		
		try {
			
			
			//load a properties file
			prop.load(new FileInputStream(filePath));
			
			//get the property value and print it out
			value = prop.getProperty(param);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		//return matched parameter
		return value;
	}
}