package application;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Application {

	/**
	 * JTNC entry point
	 * @param args
	 */
	public static void main(String[] args) {
		
		// get cmd line configuration
		// get config file configuration
		
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.open();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		shell.dispose();
	}

}
