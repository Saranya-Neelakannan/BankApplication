package com.company.bank.services;

import java.util.LinkedList;
import java.util.Scanner;

import com.company.bank.RoleDirector;
import com.company.bank.data.user.User;

public class UserServices {
	
	
	Scanner sc=new Scanner(System.in);
	
	private static LinkedList<User> userList = new LinkedList<User>();
	RoleDirector obj=new RoleDirector();

	
	static {
		User user1=new User("Saara",1000,"S","admin");
		User user2=new User("Gokul",1000,"G","user");
		User user3=new User("Kags",1000,"K","user");
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);


		for(User u:userList) {
			System.out.println(u);

		}
			}
	
	public void adminServices()
	{
		System.out.println("Enter your userName,password,type");
		String username,password,type;
		username=sc.next();
		password=sc.next();
		type=sc.next();
		char execute='y';

		while(execute=='y' || execute=='Y') {
		System.out.println("Enter your Choice");
		System.out.println("1.Add user");
		System.out.println("2.Remove User");
		System.out.println("3.View all user");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			
			System.out.println("Enter new username,password,type to add");
			username=sc.next();
			password=sc.next();
			type=sc.next();
			User user=new User(username,1000,password,type);
			addUser(user);
			break;
		case 2:
			System.out.println("Enter new username");

			removeUser(username);
			break;

		case 3:
			for(User u:userList) {
				System.out.println(u.getUsername());
			}
			break;
			
		default:
			System.out.println("Enter valid choice");
		}
		System.out.println("Do you want to continue Y/y or N/n");
		execute=sc.next().charAt(0);
		if(execute=='n'||execute=='N') {
			obj.director();
		}
		}
		

	}
	public Boolean authentication(String userName, String password, String role) {

		if(userNameExists(userName)) {
			for(User u:userList) {
				if(u.getUsername()==userName && u.getPassword()==password && u.getRole()==role) {
					
					return true;
				}
			}
		}
		return false;
	}

	public User addUser(User user) {
		if(userNameExists(user.getUsername())) {
			System.out.println("Username aldready Exists");
			return null;
		}
		else {
		userList.add(user);
		System.out.println("UserName added succesfully");
		System.out.println(user.getUsername());

		return user;
		}
	}

	public Boolean removeUser(String userName) {
		if(userNameExists(userName)) {
			for(User u:userList) {
				userList.remove(userName);
			}
			System.out.println("Username removed succesfully");
		}

		return false;
	}

	
	public Boolean userNameExists(String userName) {
		for(User u:userList) {
			if(u.getUsername().equals(userName)) {
				return true;
			}
		}
		return false;
	}

	public static LinkedList<User> getUserList() {
		return userList;
	}

	public static void setUserList(LinkedList<User> userList) {
		UserServices.userList = userList;
	}

}


//validate pass & remove user again

//add while to continue