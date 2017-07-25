package com.wipro.bank.acc;

public class RDAccount extends Account{
	int tenure;
	float principal;
	public RDAccount(int tenure, float principal)
	{
		this.tenure=tenure;
		this.principal=principal;
	}
	public float calculateAmountDeposited()
	{
		return principal*tenure*12f;
	}
	public float calculateInterest()
	{
		float p=principal;
		float r=rateOfInterest/100;
		float n=4f;
		
		float q=(1+r/n);
		float months=tenure*12;
		float t;
		float sum=0f;
		
		for(int i=0;i<tenure*12;i++)
		{
			t=months/12;
			float m=n*t;
			sum+= (float) (p*((Math.pow(q,m))-1));
			months--;
		}
		return sum; 
	}
}
