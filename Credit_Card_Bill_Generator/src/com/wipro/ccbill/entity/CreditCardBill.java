package com.wipro.ccbill.entity;

import java.util.Date;

import com.wipro.ccbill.exception.InputValidationException;

public class CreditCardBill {
	private String creditCardNo;
	private String customerId;
	private Date billDate;
	private Transaction monthTransactions[];
	public CreditCardBill ()
	{
		
	}
	public CreditCardBill (String creditCardNo, String customerId, Date BillDate, Transaction monthTransactions[])
	{
		this.creditCardNo=creditCardNo;
		this.customerId=customerId;
		this.billDate=BillDate;
		this.monthTransactions=monthTransactions;
	}
	public double getTotalAmount(String transactionType)
	{
		double sum=0;
		if(transactionType.equalsIgnoreCase("DB")||transactionType.equalsIgnoreCase("CR"))
		{
			for(int i=0;i<monthTransactions.length;i++)
			{
				if(transactionType.equalsIgnoreCase(monthTransactions[i].getTransactionType()))
				{
					sum+=monthTransactions[i].getTransactionAmount();
				}
			}
			return sum;
		}
			return 0;
	}
	public double calculateBillAmount()
	{
		try
		{
			if(validateData().equalsIgnoreCase("valid"));
			{
				if(monthTransactions!=null && monthTransactions.length>0)
				{
					double g1=getTotalAmount("DB");
					System.out.println(g1);
					double g2=getTotalAmount("CR");
					System.out.println(g2);
					double outstandingAmount;
					if(g1>g2)
						outstandingAmount=g1-g2;
					else
						outstandingAmount=g2-g1;
					double interestCalculated = (outstandingAmount * (19.9/100)/12);
					double billAmount=outstandingAmount+interestCalculated;
					return billAmount;
				}
				else
				{
					return 0.0;
				}
			}
		}
		catch(Exception e)
		{
			return 0.0;
		}
	}
	public String validateData() throws InputValidationException
	{
		if(creditCardNo!=null && creditCardNo.length()==16 && customerId!=null && customerId.length()>=6)
		{
			return "valid";
		}
		else
		{
			throw new InputValidationException();
		}		
	}
}
