package configuration;

public interface IOptions {
	public String getValue(String key);
	public IOptions loadFromFile(String fileName) throws Exception;
}
