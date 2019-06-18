package com.CarDealership;

import java.util.Scanner;

public class CustomerLogin {

	public static boolean customerL() {

		Scanner input = new Scanner(System.in);

		String Username;
		String Password;

		Username = "Customer";
		Password = "c";

		System.out.println("Customer Login");
		System.out.println("Username: ");
		String username = input.next();
		System.out.println("Password: ");
		String password = input.next();


		if(username.equals(Username) && password.equals(Password)) {
			System.out.println("Welcome!");
			CustomerActions.customerMenuOption();
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
