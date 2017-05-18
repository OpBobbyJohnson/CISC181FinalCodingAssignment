package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {
	public RateDomainModel mod1;

	public RateException(RateDomainModel mod1) {
		super();
		this.mod1 = mod1;
	}

	public RateDomainModel getMod1() {
		return mod1;
	} 

	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
}
