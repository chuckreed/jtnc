package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.widgets.Shell;

public class BrowserWrapper {
	// composite object containing a real browser since we can't sub class
	
	protected Browser swtBrowser;
	
	/**
	 * @return the swtBrowser
	 */
	public Browser getSwtBrowser() {
		return swtBrowser;
	}

	/**
	 * @param swtBrowser the swtBrowser to set
	 * @return 
	 */
	public BrowserWrapper setSwtBrowser(Browser swtBrowser) {
		this.swtBrowser = swtBrowser;
		return this;
	}

	public BrowserWrapper() {

	}
	
	public BrowserWrapper init(Shell shell) throws Exception {
		Browser browser = null;
		
		try {
			browser = new Browser(shell, SWT.NONE);
			browser.setSize(shell.getSize());
			browser.setUrl("http://127.0.0.1/index.html");
		} catch (Exception e)  {
			throw new Exception("Failed to link to any underlying web browsers: " + e.getMessage(), e);
		}

		this.setSwtBrowser(browser);
		return this;
	}
}
