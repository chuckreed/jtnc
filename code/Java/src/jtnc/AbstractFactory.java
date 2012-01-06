package jtnc;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFactory
	implements IFactory {
	
	protected Map<String, String> classOverrides = new HashMap<String, String>();
	protected Map<String, Object> instanceOverrides = new HashMap<String, Object>();
	protected static IFactory instance;
	
	protected AbstractFactory() {
		this.classOverrides = new HashMap<String, String>();
		this.instanceOverrides = new HashMap<String, Object>();
	}
	
	public Map<String, String> getClassOverrides() {
		return classOverrides;
	}

	public IFactory setClassOverrides(Map<String, String> classOverrides) {
		this.classOverrides = classOverrides;
		return this;
	}

	public Map<String, Object> getInstanceOverrides() {
		return this.instanceOverrides;
	}

	public IFactory setInstanceOverrides(Map<String, Object> instanceOverrides) {
		this.instanceOverrides = instanceOverrides;
		return this;
	}
	
	abstract public Object getObject(String className, Object[] args) 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException;
}