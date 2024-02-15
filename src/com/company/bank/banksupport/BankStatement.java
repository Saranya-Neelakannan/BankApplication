package com.company.bank.banksupport;

import java.util.ArrayList;
import java.util.Date;

public class BankStatement {
	public String username;
    public String type;
    public double amount;
    public double userBalance;
    public Date transactionDate;
    
    BankStatement(){
    	
    }
    public BankStatement(String username,String type,double amount,double userBalance,Date transactionDate){
    this.username=username;
    this.type=type;
    this.amount=amount;
    this.userBalance=userBalance;
    this.transactionDate=transactionDate;

    }
 }
