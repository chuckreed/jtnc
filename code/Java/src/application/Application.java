package application;

import jtnc.*;
import gui.*;
import configuration.*;
import java.io.File;

public class Application {	
	protected static Options appOptions;
	
	/**
	 * JTNC entry point
	 * @param args
	 */
	public static void main(String[] args) {
		IFactory factory = jtnc.Factory.getInstance();
		
		// get cmd line configuration and set up application options
		try {
			ICommandLine cmdLineData = (ICommandLine) factory.getObject("configuration.CommandLine", null);
			Application.appOptions = (Options) factory.getObject("application.Options", null);
			Application.appOptions.setCommandLineData(cmdLineData).init();
		} catch (Exception e) {
			Application.debug(e);
		}
		
		try {
			MainWindow mainWindow = (MainWindow) factory.getObject("gui.MainWindow", null);
			Application.configureMainWindow(mainWindow);
			mainWindow.open();
		} catch (Exception e) {
			System.out.println("Failed to create main app window:");
			Application.debug(e);
			System.exit(1);
		}
	}
	
	public static void debug(Exception e) {
		System.out.println(e.getMessage() + "::" + e.getLocalizedMessage());
		for (StackTraceElement ste : e.getStackTrace()) {
			System.out.println(ste.toString());
		}		
	}
	
	public static void configureMainWindow(MainWindow mainWindow) {
		// mainWindow.doSomeStuff(...);
	}
}