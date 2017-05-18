package rocketBase;

import static org.junit.Assert.*;

import org.hibernate.HibernateException;
import org.junit.Test;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	@Test
	public void test1(){
		RateDomainModel dom1 = new RateDomainModel();
		dom1.setdInterestRate(1.1);
		dom1.setiMinCreditScore(460);
		dom1.setiRateID(2);
		assertTrue(dom1.getdInterestRate() == 1.1);
	}
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void test2() throws RateException{
		RateDomainModel mod1 = new RateDomainModel();
		mod1.setdInterestRate(0);
		mod1.setiMinCreditScore(6);
		mod1.setiRateID(1);
	try{
		mod1.getdInterestRate();
	}catch(HibernateException e) {
		if (mod1.getdInterestRate() >= 6)
			e.printStackTrace();
	}
				
		
	}
}
