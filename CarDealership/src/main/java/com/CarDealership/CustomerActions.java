package com.CarDealership;

import java.sql.Connection;
import java.util.Scanner;

public class CustomerActions {

	public static Connection conn = ConnectionFactory.getConnection();
	
	private static Scanner sc = new Scanner(System.in);

	public static void customerMenuOption() {

		int menuOption2;
		displayCustomerMenu();
		do {
			LoggingUtil.info("\n\nWhat would you like to do?");
			menuOption2 = sc.nextInt();
			while(menuOption2 <0 || menuOption2 >6)
			{
				LoggingUtil.info("Please enter a correct menu option.");
				menuOption2 = sc.nextInt();
			}
			actionMenu(menuOption2,null);
		} while(menuOption2 != 6);
	}
 
	public static void displayCustomerMenu() {

		LoggingUtil.info("Menu: ");
		System.out.println();
		LoggingUtil.info("1. Show all existing car in lot.");
		LoggingUtil.info("2. Make offer for car.");
		LoggingUtil.info("3. View owned car.");
		LoggingUtil.info("4. View remaining payments.");
		LoggingUtil.info("5. Return to login.\n\n");
	}
	
	public static void displayCars() {

		LoggingUtil.info("| #  |   year    |  color    |    make   |   model   |  mileage  |   price    |");
		System.out.println();
		int i = 0;
		for (Car car : CarLot.getCars()) {
			LoggingUtil.info(++i + "    " + car.getYear() + "      " + car.getColor() + "      " + car.getMake()
			+ "      " + car.getModel() + "     " + car.getMileage() + "     " + car.getPrice());
			System.out.println();
		}
	}
	
	public static void makeOffer() {
		
		displayCars();
		int makeOffering;
		LoggingUtil.info("Select car #");
		makeOffering = sc.nextInt();
		LoggingUtil.info("How much are you offering?");
		makeOffering = sc.nextInt();
		
	}
	public static void actionMenu(int action, CarLot cars) {

		switch (action) {
		case 0:
			LoggingUtil.info("Main Menu");
			displayCustomerMenu();
			break;
		case 1:
			LoggingUtil.info("List of Cars");
			displayCars();
			break;
		case 2:
			LoggingUtil.info("Make Offer");
			makeOffer();
			break;
		case 5:
			LoggingUtil.info("Main Menu");
			Login.main(null);
		}
	}
}

