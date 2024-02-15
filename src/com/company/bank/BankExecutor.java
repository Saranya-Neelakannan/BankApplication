package com.company.bank;

public abstract class BankExecutor implements RBI{
	public static void main(String[] args)
	{
		RoleDirector roleDirector=new RoleDirector();
		roleDirector.director();
	}
}
