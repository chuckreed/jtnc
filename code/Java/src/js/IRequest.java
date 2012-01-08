package js;

public interface IRequest {
	public String getExtensionName();
	public IRequest setExtensionName(String extensionName);
	public String getActionName();
	public IRequest setActionName(String actionName);
	public Object[] getArguments();
	public IRequest setArguments(Object[] arguments);
	public String getSuccessCallback();
	public IRequest setSuccessCallback(String successCallback);
	public String getErrorCallback();
	public IRequest setErrorCallback(String errorCallback);
}
