package configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Configuration {

	String resourcesPath = System.getProperty("user.dir")+"\\resource\\";
	InputStream input = null;

	Properties prop = new Properties();

	public Configuration() {
		
		try {
			input = new FileInputStream(resourcesPath+"Config.properties");
			prop.load(input);
		}catch(Exception e) {
			e.printStackTrace();
		} 


	}
	public String getURL() {
		return prop.getProperty("Url");
	}
	

}
