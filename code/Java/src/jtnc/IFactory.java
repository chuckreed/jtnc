package jtnc;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface IFactory {
	public Map<String, String> getClassOverrides();
	public IFactory setClassOverrides(Map<String, String> classOverrides);
	public Map<String, Object> getInstanceOverrides();
	public IFactory setInstanceOverrides(Map<String, Object> instanceOverrides);
	public Object getObject(String className, Object[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException;
}
