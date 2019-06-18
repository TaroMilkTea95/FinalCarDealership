package com.CarDealership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeActions {
	
	public static Connection conn = ConnectionFactory.getConnection();

	private static Scanner sc = new Scanner(System.in);

	public static void employeeMenuOption() {

		int menuOption;
		displayEmployeeMenu();
		do {
			LoggingUtil.info("\n\nWhat would you like to do?");
			menuOption = sc.nextInt();
			while(menuOption <0 || menuOption >6)
			{
				LoggingUtil.info("Please enter a correct menu option.");
				menuOption = sc.nextInt();
			}
			actionMenu(menuOption,null);
		} while(menuOption != 6);
	}

	public static void displayEmployeeMenu() {

		LoggingUtil.info("Menu: ");
		System.out.println();
		LoggingUtil.info("1. Show all existing car in lot.");
		LoggingUtil.info("2. Add a new car to lot.");
		LoggingUtil.info("3. Delete a car from lot.");
		LoggingUtil.info("4. View all payments.");
		LoggingUtil.info("5. Return to login.\n\n");
	}

	public static void displayCars() {

		LoggingUtil.info("| #  |   VIN   |   year    |  color    |    make   |   model   |  mileage  |   price    |");
		System.out.println();
		int i = 0;
		for (Car car : CarLot.getCars()) {
			System.out.println(++i + "     " + car.getVIN() + "      " + car.getYear() + "        " + car.getColor() + "        " + car.getMake()
			+ "        " + car.getModel() + "      " + car.getMileage() + "     " + car.getPrice());
		}
		System.out.println();
	}

	public static void displayCars(Car car) {

		LoggingUtil.info("| #  |   VIN   |   year    |  color    |    make   |   model   |  mileage  |   price    |");
		System.out.println();
		System.out.println("1" + "     " + car.getVIN() + "      " + car.getYear() + "        " + car.getColor() + "        " + car.getMake()
		+ "        " + car.getModel() + "      " + car.getMileage() + "     " + car.getPrice());
	}

	public static void addNewCar(CarLot cars) {

		CarDaoImpl addCar = new CarDaoImpl();
		
		boolean validInput;
		String color, make, model = null;
		int year = 0, mileage = 0, VIN = 0;
		double price = 0.0;

		System.out.println("Enter a new car in the following format:");
		System.out.println("VIN YEAR COLOR MAKE MODEL MILEAGE PRICE");
		do {
			validInput = true;
			VIN = sc.nextInt();
			year = sc.nextInt();
			color = sc.next();
			make = sc.next();
			model = sc.next();
			mileage = sc.nextInt();
			price = sc.nextDouble();
			if (!validInput) {
				System.out.println("\nIncorrect Format.");
				System.out.println("Enter a new car in the following format:");
				System.out.println("VIN YEAR COLOR MAKE MODEL MILEAGE PRICE");
			}
		} while (validInput == false);
		addCar.createCar(new Car(VIN,year,color,make,model,mileage,price));
		CarLot.getCars().add(new Car(VIN,year,color,make,model,mileage,price));
	}

	public static void removeCar(CarLot car) {
		
		CarDaoImpl removeCar = new CarDaoImpl();

		int carNumber;

		if(CarLot.getCars().size()>0) {
			LoggingUtil.info("Please select # of the car you want to delete");
			displayCars();
			do {
				LoggingUtil.info("Delete car #: ");
				while(!sc.hasNextInt())
				{
					LoggingUtil.info("Thats not a valid input");
					sc.next();
				}
				carNumber = sc.nextInt();

			} while (carNumber < 1 || carNumber > CarLot.getCars().size());
			removeCar.deleteCar(null);
			CarLot.getCars().remove(carNumber-1);
		} else LoggingUtil.info("There are no cars to remove.");
	}

	public static void actionMenu(int action, CarLot cars) {

		switch (action) {
		case 0:
			LoggingUtil.info("Main Menu");
			displayEmployeeMenu();
			break;
		case 1:
			LoggingUtil.info("List of Cars");
			displayCars();
			break;
		case 2:
			LoggingUtil.info("Add car to lot");
			addNewCar(cars);
			break;
		case 3:
			LoggingUtil.info("Remove car from lot");
			removeCar(cars);
			break;

		case 5:
			LoggingUtil.info("Return to login");
			Login.main(null);
		}
	}

}
