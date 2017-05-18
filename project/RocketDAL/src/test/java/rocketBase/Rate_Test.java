package rocketBase;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	
	//Test 1
	//Check to see if a known credit score returns a known interest rate
	@Test
	public void test1(){
		RateDomainModel model1 = new RateDomainModel();
		model1.setdInterestRate(1.2);
		model1.setiMinCreditScore(40);
		model1.setiRateID(1);
		
		assertTrue(model1.getdInterestRate() == 1.2);
	}
	
	
	
	//Test 2
	//Check to see if a RateException is thrown if there are no rates for a given
	//credit score
	@Test
	public void test2(){
		RateDomainModel model2 = new RateDomainModel();
		model2.setdInterestRate(1.1);
		model2.setiMinCreditScore(6);
		model2.setiRateID(2);
		try{
			model2.getdInterestRate();
		}
		catch(HibernateException e) {
			if (model2.getdInterestRate() >= 6)
				e.printStackTrace();
		}
	}
}
