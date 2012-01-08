package gui;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.swt.browser.OpenWindowListener;
import org.eclipse.swt.browser.WindowEvent;

import jtnc.Factory;
import gui.BrowserWrapper;

public class MainWindow {
	protected Shell shell;
	protected Display display;
	protected BrowserWrapper browserWrapper;

	public Shell getShell() {
		return this.shell;
	}

	public MainWindow setShell(Shell shell) {
		this.shell = shell;
		return this;
	}

	public Display getDisplay() {
		return display;
	}

	public MainWindow setDisplay(Display display) {
		this.display = display;
		return this;
	}
	
	protected BrowserWrapper getBrowserWrapper() {
		return this.browserWrapper;
	}
	
	protected MainWindow setBrowserWrapper(BrowserWrapper wrapper) {
		this.browserWrapper = wrapper;
		return this;
	}

	public MainWindow() throws Exception {
		this.setDisplay((Display) Factory.getInstance().getObject("org.eclipse.swt.widgets.Display", null));
		this.setShell((Shell) Factory.getInstance().getObject("org.eclipse.swt.widgets.Shell", new Object[]{display}));
		this.setBrowserWrapper((BrowserWrapper) Factory.getInstance().getObject("gui.BrowserWrapper", null));
		this.getBrowserWrapper().init(this.getShell());
		
		/**
		 * Ensure browser sizes with main shell for now
		 */
		this.getShell().addListener(SWT.Resize, new Listener() {
			@Override
			public void handleEvent(Event e) {
				Shell shell = (Shell) e.widget;
				for (Control control : shell.getChildren()) {
					if (control instanceof Browser) {
						control.setSize(shell.getSize());
						break;
					}
				}
			}
		});
		
		/**
		 * Disable new window creation and warn user that
		 * the feature is not currently supported but will
		 * be in the future.
		 */
		this.getBrowserWrapper().getSwtBrowser().addOpenWindowListener(new OpenWindowListener() {
			public void open(WindowEvent event) {
				Browser browser = (Browser) event.widget;
				browser.execute("alert('The JTNC does not currently support child browser windows.  This feature is planned for future released.');");
			}
		});
		
		/**
		 * Add custom JTNC_sendMessage() function to our embedded browser
		 * so the loaded web application can have a link to call extensions.
		 */
		new BrowserFunction(this.getBrowserWrapper().getSwtBrowser(), "JTNCSend"){
			public Object function(Object[] arguments) {
				return "It worked.";
			}
		};
	}
	
	public void open() {
		this.getShell().open();
		
		while (!this.getShell().isDisposed()) {
			if (!this.getDisplay().readAndDispatch()) {
				this.getDisplay().sleep();
			}
		}
		
		this.getShell().dispose();
	}
	
}