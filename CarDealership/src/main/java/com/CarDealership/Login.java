package com.CarDealership;

import java.sql.Connection;
import java.util.Scanner;

public class Login {

	public static Connection conn = ConnectionFactory.getConnection();	
	
	public static void main(String[] args) {

		boolean exitInput = false;

		do {	
			Scanner scan = new Scanner(System.in);
			String loginPage = new String();

			LoggingUtil.info("Welcome to Tan's Car Dealership!");
			LoggingUtil.info("Please Select User:");
			LoggingUtil.info("(1) Employee");
			LoggingUtil.info("(2) Customer");
			LoggingUtil.info("(3) New Customer");

			loginPage = scan.nextLine();
			if(loginPage.equals("1")) {
				EmployeeLogin.employeeL();
				exitInput = true;
			}else if(loginPage.equals("2"));
			CustomerLogin.customerL();
			exitInput = true;
		}while(exitInput != true);

	}
}
