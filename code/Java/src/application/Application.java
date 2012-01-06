package application;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import jtnc.IFactory;
import jtnc.Factory;

public class Application {

	protected static IFactory objectFactory;
	
	/**
	 * JTNC entry point
	 * @param args
	 */
	public static void main(String[] args) {
		
		// get cmd line configuration
		// get config file configuration
		
		Display display = null;
		Shell shell =  null;		
		IFactory factory = jtnc.Factory.getInstance();
		
		try {
			display = (Display) factory.getObject("org.eclipse.swt.widgets.Display", null);
			shell = (Shell) factory.getObject("org.eclipse.swt.widgets.Shell", new Object[]{display});
		} catch (Exception e) {
			System.out.println("Failed to create main app window: " + e.getMessage());
			System.exit(1);
		}

		shell.open();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		shell.dispose();
	}

	
}
