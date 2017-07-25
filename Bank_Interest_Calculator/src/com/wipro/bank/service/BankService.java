package com.wipro.bank.service;

import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.BankValidationException;

public class BankService {
	public boolean validateData(float principal, int tenure,int age, String gender)
	{
		try
		{
		if(principal>=500 && (tenure==5||tenure==10) )
		{
				
			if(gender.equalsIgnoreCase("Male")||gender.equalsIgnoreCase("Female"))
			{
				if(age>=1 && age<=100)
				{
					return true;
				}
			}
		}
		else
			throw new BankValidationException();
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void calculate(float principal,int tenure, int age, String gender)
	{
		if(validateData(principal,tenure,age,gender))
		{
			RDAccount rd=new RDAccount(tenure,principal);
			rd.setInterest(age,gender);
			float maturityInterest=rd.calculateInterest();
			float totalPrincipleDeposited=rd.calculateAmountDeposited();
			System.out.println(maturityInterest);
			System.out.println(totalPrincipleDeposited); 
			System.out.println(rd.calculateMaturityAmount(totalPrincipleDeposited,maturityInterest));
		}
	}
}
