package gui;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.browser.*;
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