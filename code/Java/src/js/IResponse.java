package js;

public interface IResponse {
	public IRequest getOriginalRequest();
	public IResponse setOriginalRequest();
	public Object getResponseData();
	public IResponse setResponseData();
}
