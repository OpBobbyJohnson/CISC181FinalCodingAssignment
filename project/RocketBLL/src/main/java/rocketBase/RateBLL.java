package rocketBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = -26;
		RateDomainModel mod2 = null;
		try{
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		for (int i = 0 ; i < rates.size(); i++){
		
			if(GivenCreditScore == rates.get(i).getiMinCreditScore()){
				dInterestRate = rates.get(i).getdInterestRate();
				
		}
			else if(dInterestRate < 0 || mod2 == null){
				throw new RateException(mod2);
		}
			
	}
	
		
			
		}catch(RateException e1){
			System.out.println("Rate Exception e1 is thrown, No Rate Found! ");
			
	}
		
		
		return dInterestRate;
		
		
	}
	
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
