package configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.collections.*;
import org.apache.commons.lang.exception.NestableException;
import org.apache.commons.configuration.XMLConfiguration;

public class Options implements IOptions {

	protected static IOptions instance;
	protected XMLConfiguration xmlConfig;

	static {
		Options.instance = new Options();
	}
	
	protected Options() {
		this.xmlConfig = new XMLConfiguration();
	}
	
	public static IOptions getInstance() {
		return instance;
	}
	
	public IOptions loadFromFile(String fileName) throws ConfigurationException {
		this.xmlConfig.load(fileName);
		return this;
	}
	
	public String getValue(String key) {
		return this.xmlConfig.getString(key);
	}	
}
