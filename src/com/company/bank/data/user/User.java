package com.company.bank.data.user;


public class User {

	private  String username;
	private static   double userAccountBalance;
	private String password;
	private String role;
	
	
	public User(){
		
	}
	
	public User(String username,double userAccountBalance,String password,String role){
		this.setUsername(username);
		this.setUserAccountBalance(userAccountBalance);
		this.setPassword(password);
		this.setRole(role);

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static double getUserAccountBalance() {
		return userAccountBalance;
	}

	public static void setUserAccountBalance(double userAccountBalance) {
		User.userAccountBalance = userAccountBalance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
