package com.wipro.bank.main;
import java.util.*;
import com.wipro.bank.service.BankService;

public class MainClass {

	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		int tenure = in.nextInt();
		float principal = in.nextFloat();
		int age = in.nextInt();
		String gender = in.next();
		BankService b=new BankService();
        b.calculate(principal, tenure, age, gender);
        in.close();
	}
}
