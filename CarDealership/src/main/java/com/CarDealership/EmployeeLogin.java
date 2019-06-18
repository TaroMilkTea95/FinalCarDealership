package com.CarDealership;

import java.util.Scanner;

public class EmployeeLogin {
	
	public static boolean employeeL() {

		Scanner input = new Scanner(System.in);

		String Username;
		String Password;

		Username = "Employee";
		Password = "e";

		System.out.println("Employee Login");
		System.out.println("Username: ");
		String username = input.next();
		System.out.println("Password: ");
		String password = input.next();
		
		if(username.equals(Username) && password.equals(Password)) {
			System.out.println("Welcome!");
			EmployeeActions.employeeMenuOption();
		} else if (username.equals(Username)) {
			System.out.println("Invalid Password!");
		} else if (password.equals(Password)) {
			System.out.println("Invalid Username!");
		} else {
			System.out.println("Invalid Username & Password!");
		}

		while(!username.equals(Username) && !password.equals(Password) ||
				(!username.equals(Username) && password.equals(Password) ||
						(username.contentEquals(Username) && (!password.contentEquals(Password))))) {
			System.out.println("Try Again! \n" + "Username: ");
			username = input.next();
			System.out.println("Password: ");
			password = input.next();

			if(username.equals(Username) && password.equals(Password)) {
				System.out.println("Welcome!");
			}
		}
		return false;
	}
}
