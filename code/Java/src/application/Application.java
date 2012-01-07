package application;

import jtnc.*;
import gui.*;

public class Application {	
	/**
	 * JTNC entry point
	 * @param args
	 */
	public static void main(String[] args) {
		
		// get cmd line configuration
		// get config file configuration
		
		IFactory factory = jtnc.Factory.getInstance();
		MainWindow mainWindow = null;
		
		try {
			mainWindow = (MainWindow) factory.getObject("gui.MainWindow", null);
		} catch (Exception e) {
			System.out.println("Failed to create main app window: " + e.getMessage());
			for (StackTraceElement ste : e.getStackTrace()) {
				System.out.println(ste.toString());
			}
			System.exit(1);
		}
		
		mainWindow.open();
	}
}
