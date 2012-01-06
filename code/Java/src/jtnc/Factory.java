package jtnc;

import java.util.List;

public class Factory {
	protected List<String> instanceNames;
	protected List<Object> instanceOverrides;
	protected List<String> classOverrides;
	protected IFactory factoryDelegate;

	/**
	 * @return the instanceNames
	 */
	public List<String> getInstanceNames() {
		return instanceNames;
	}
	/**
	 * @param instanceNames the instanceNames to set
	 * @return 
	 */
	public Factory setInstanceNames(List<String> instanceNames) {
		this.instanceNames = instanceNames;
		return this;
	}
	/**
	 * @return the instanceOverrides
	 */
	public List<Object> getInstanceOverrides() {
		return instanceOverrides;
	}
	/**
	 * @param instanceOverrides the instanceOverrides to set
	 * @return 
	 */
	public Factory setInstanceOverrides(List<Object> instanceOverrides) {
		this.instanceOverrides = instanceOverrides;
		return this;
	}
	/**
	 * @return the classOverrides
	 */
	public List<String> getClassOverrides() {
		return classOverrides;
	}
	/**
	 * @param classOverrides the classOverrides to set
	 * @return 
	 */
	public Factory setClassOverrides(List<String> classOverrides) {
		this.classOverrides = classOverrides;
		return this;
	}
	/**
	 * @return the factoryDelegate
	 */
	public IFactory getFactoryDelegate() {
		return factoryDelegate;
	}
	/**
	 * @param factoryDelegate the factoryDelegate to set
	 * @return 
	 */
	public Factory setFactoryDelegate(IFactory factoryDelegate) {
		this.factoryDelegate = factoryDelegate;
		return this;
	}
	
	
	
}
