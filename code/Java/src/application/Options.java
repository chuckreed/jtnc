package application;

import java.util.Map;

import configuration.IOptions;
import extension.IManager;
import configuration.ICommandLine;

public class Options {
	protected ICommandLine cmdLineData;
	protected Map<String, String> appOptions;
	
	
	public ICommandLine getCommandLineData() {
		return this.cmdLineData;
	}
	
	public Options setCommandLineData(ICommandLine commandLineData) {
		this.cmdLineData = commandLineData;
		return this;
	}
	
	public String getAppOption(String key) {
		// sanity check here
		return this.appOptions.get(key);
	}
	
	public Options setAppOption(String key, String value) {
		this.appOptions.put(key,  value);
		return this;
	}
	
	public Options removeAppOption(String key) {
		this.appOptions.remove(key);
		return this;
	}
	
	public Options clearAppOptions() {
		this.appOptions.clear();
		return this;
	}
	
	public Options init() throws Exception {
		IOptions configData = (IOptions) jtnc.Factory.getInstance().getObject("configuration.Options", null);
		configData.loadFromFile("./config.xml"); // get file name from cmd line, then use default...
		// set application configuration options here
		return this;
	}
}
