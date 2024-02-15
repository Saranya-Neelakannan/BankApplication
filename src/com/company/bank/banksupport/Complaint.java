package com.company.bank.banksupport;

import java.util.Date;

public class Complaint {
	String complaint;
    String userName;
    Date date;
    String status;
    String adminUserName;
    Date dateResolved;
    
    public Complaint(){
    	
    }
    public Complaint(String complaint,String userName,Date date,String status,String adminUserName,Date dateResolved){
    	this.complaint=complaint;
        this.userName=userName;
        this.date=date;
        this.status=status;
        this.adminUserName=adminUserName;
        this.dateResolved=dateResolved;

    }

}
