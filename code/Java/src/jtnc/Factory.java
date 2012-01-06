package jtnc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.HashMap;
import jtnc.IFactory;

public class Factory
	extends AbstractFactory {
	
	protected Map<String, String> classOverrides = new HashMap<String, String>();
	protected Map<String, Object> instanceOverrides = new HashMap<String, Object>();
	protected static IFactory instance;
	
	public static IFactory getInstance() {
		if (Factory.instance == null) {
			Factory.instance = new Factory();
		}
		return Factory.instance;
	}
	
	public Object getObject(String className, Object[] args)
		throws 	ClassNotFoundException, InstantiationException, IllegalAccessException, 
				NoSuchMethodException, SecurityException, IllegalArgumentException, 
				InvocationTargetException {
		/**
		 * Return any instance specific overrides first.
		 */
		if (this.getInstanceOverrides().containsKey(className)) {
			return this.getInstanceOverrides().get(className);
		}
		
		/**
		 * Use overridden object name if we have one
		 */
		if (this.getClassOverrides().containsKey(className)) {
			className = this.getClassOverrides().get(className);
		}

		/**
		 * Create new type and, if no constructions args, return new blank instance
		 */
		Class<?> newClassType = Class.forName(className);
		if (args == null || args.length == 0) {
			return newClassType.newInstance();
		}

		/**
		 * Since we have constructor args, find a constructor matching our
		 * argument list type signature and return a fully constructed object.
		 */
		Class<?> partTypes[] = new Class[args.length];
		int i = 0;
		for (Object obj : args) {
			partTypes[i++] = obj.getClass();
		}
		
		Constructor<?> constructor = newClassType.getConstructor(partTypes);
		return constructor.newInstance(args);
	}
}