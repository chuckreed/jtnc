package configuration;

import org.apache.commons.configuration.XMLConfiguration;

public class Options implements IOptions {

	protected XMLConfiguration xmlConfig;

	public Options() {
		this.xmlConfig = new XMLConfiguration();
	}
	
	public IOptions loadFromFile(String fileName) throws Exception {
		this.xmlConfig.load(fileName);
		return this;
	}
	
	public String getValue(String key) {
		return this.xmlConfig.getString(key);
	}	
}
