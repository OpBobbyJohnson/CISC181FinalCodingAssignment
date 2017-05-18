package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			try{
				lq.setdRate(RateBLL.getRate(lq.getiCreditScore()));
			}catch (RateException e){
				sendToAll(e);
				System.out.println("it is an invalid credit score.");
				
			}
			lq.setdPayment(RateBLL.getPayment(lq.getdRate(), lq.getiTerm()*12, lq.getdAmount()-lq.getiDownPayment(), 0.0, false));
			
			
			sendToAll(lq);
		}
	}
}
