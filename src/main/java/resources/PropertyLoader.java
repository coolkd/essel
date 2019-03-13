package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

	private static Properties prop;

	static {
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("/home/kuldeep/workspace/TravelB2C/data.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String propertyName) {
		return prop.getProperty(propertyName);
	}

}
