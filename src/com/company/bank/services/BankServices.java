package com.company.bank.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.company.bank.banksupport.BankStatement;
import com.company.bank.banksupport.Complaint;
import com.company.bank.data.config.BankConfigData;
import com.company.bank.data.user.User;

public class BankServices {

    ArrayList<BankStatement> bankStatements=new ArrayList<>();
    private static ArrayList<Complaint> complaints=new ArrayList<>();
    
    
   			User userData=new User();
			BankConfigData bankData=new BankConfigData();
			
			 public void showBalance()
			{
				System.out.println("Current balance: "+userData.getUserAccountBalance() );

			}
			
			 void withdraw(User user,int amount)
			{
				double deduction=amount*(bankData.withdrawDeduction/100);
				if(userData.getUserAccountBalance()>=amount) {
					userData.setUserAccountBalance(userData.getUserAccountBalance() - (amount+deduction));
					showBalance();
					addWithdralToBankStatement(user,amount);
					return;

				}
				System.out.println("No sufficient balance");
							
			}

			  private void addWithdralToBankStatement(User user,int amount) {
				  
				  BankStatement b=new BankStatement(user.getUsername(),"Withdraw",amount,user.getUserAccountBalance(),null);
				  bankStatements.add(b);
				}

			void deposit(User user,int amount)
			{
				double deduction=amount*(bankData.depositDeduction/100);
				userData.setUserAccountBalance(userData.getUserAccountBalance()+amount-deduction);
				showBalance();
				addDepositToBankStatement(user,amount);
			}
			private void addDepositToBankStatement(User user,int amount) {
				  
				  BankStatement b=new BankStatement(user.getUsername(),"Deposit",amount,user.getUserAccountBalance(),null);
				  bankStatements.add(b);
				}
			
			public void helpAndSupport() {
				Scanner sc=new Scanner(System.in);

				System.out.println("Enter your complaints");
				
				String complaint=sc.nextLine();
				String userName=sc.nextLine();
				Complaint c=new Complaint(complaint,userName,null,"open","Saara",null);
				getComplaints().add(c);
				System.out.println("Complaint Registered");
				
			}

			public void bankServices(User user){
				System.out.println("Welcome "+user.getUsername());
				
				Scanner sc=new Scanner(System.in);
				char ch = 'y';
				int count=0;
				boolean validAmount=true;
			
					String name,pass;
					System.out.println("Enter your Name and Password");
					name=sc.nextLine();
					pass=sc.nextLine();
					
					if(name.equals(user.getUsername()) && pass.equals(user.getPassword()))
					{
						
							while(ch=='y' || ch=='Y') {
														


							System.out.println("Enter your Choice");
							System.out.println("1.Withdraw");
							System.out.println("2.Deposit");
							System.out.println("3.Show Balance");
							System.out.println("4.Bank Statement");
							System.out.println("5.Help and Support");


			
							int choice=sc.nextInt();
						
						switch(choice)
						{
							case 1:if(count<3) {
								int withdrawAmount;
								do {
								System.out.println("Enter the amount");
									withdrawAmount=sc.nextInt();
									if(checkValidityOfAmount(withdrawAmount)!=false);
								}while(validAmount);
									User u=new User(name,User.getUserAccountBalance(),pass,"user");
									withdraw(u,withdrawAmount);
									count++;
							}
							else
							{
								System.out.println("Only 3 transactions minimum!");
							}
									break;
									
									
							case 2:System.out.println("Enter the amount");
								int depositAmount=sc.nextInt();
								User u=new User(name,User.getUserAccountBalance(),pass,"user");

								deposit(u,depositAmount);
								break;
								
							case 3:showBalance();			
								break;
								
							case 4:
								System.out.println("Trans type"+"Amount"+" Balance"+"Trans Date");
								for(BankStatement b:bankStatements) {	
									System.out.println(b.type+"  "+b.amount+"  "+b.userBalance+
											"  "+b.transactionDate);
								}
								break;
								
							case 5:
								helpAndSupport();
								break;
							default:
								System.out.println("Invalid Choice");
			
						}
						System.out.println("Do you want to continue ? Enter Y/y or N/n");
						ch=sc.next().charAt(0);
											}
												
					}
					else
					{
						System.out.println("Invalid Credentials");
					}
				
							System.out.println("Thank you");
				
				sc.close();
			}

			private boolean checkValidityOfAmount(int amount) {
				if(amount%100 ==0) {
					return true;
				}
				System.out.println("Enter valid amount");
				return false;
				
			}

			public static ArrayList<Complaint> getComplaints() {
				return complaints;
			}

			public static void setComplaints(ArrayList<Complaint> complaints) {
				BankServices.complaints = complaints;
			}
			
	}


