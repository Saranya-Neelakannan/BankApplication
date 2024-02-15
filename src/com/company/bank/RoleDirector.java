package com.company.bank;
import java.util.Scanner;

import com.company.bank.banksupport.Complaint;
import com.company.bank.data.user.User;
import com.company.bank.services.BankServices;
import com.company.bank.services.UserServices;

public class RoleDirector {
    
    	
    
	int userRole;
	String userName;
	UserServices uServices=new UserServices();
	BankServices bServices=new BankServices();

	
	
	
	
	Scanner sc=new Scanner(System.in);

	public boolean isAdmin(String userName) {
		for (User u : UserServices.getUserList()) {
	        if ("admin".equals(u.getRole())) { 
	            return true;
	        }
	    
		}

		return false;
	}

	public User isUser(String userName) {
		for(User u:UserServices.getUserList()) {
			if(u.getUsername().equals(userName) && ((u.getRole()).equals("user")) ) {
				return u;
			}
					}
		return null;
	}
	public void helpAndSupport() {
		System.out.println("Enter your complaints");
		
		String complaint=sc.nextLine();
		String userName=sc.nextLine();
		Complaint c=new Complaint(complaint,userName,null,"open","Saara",null);
		BankServices.getComplaints().add(c);
		System.out.println("Complaint Registered");

	}


	public void director()
	{
		System.out.println("Enter your role 1-Admin 2-User 3-Help&Support");
		userRole=sc.nextInt();
		
		switch(userRole) {
		case 1:
			System.out.println("Enter userName");
			userName=sc.next();
			if(isAdmin(userName)){
				uServices.adminServices();
			}
			else {
			System.out.println("ISADMIN-false");
			}
			break;
		case 2:
			System.out.println("Enter userName");
			userName=sc.next();
			User user=isUser(userName);
			System.out.println("------"+user);
			if(user!=null ) {
				bServices.bankServices(user);
			}
			else {
				System.out.println("No such username Exists");
			}	break;

		case 3:
			helpAndSupport();
			break;
		default:
			System.out.println("Enter valid choice");
		
		}
		sc.close();
		

	}

		}
