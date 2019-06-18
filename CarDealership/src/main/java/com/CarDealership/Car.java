package com.CarDealership;

import java.io.Serializable;

public class Car implements Serializable{

	int VIN;
	int year;
	String color;
	String make;
	String model;
	int mileage;
	double price;

	Car (){};

	Car(int VIN, int year, String color, String make, String model, int mileage, double price) {
		this.VIN = VIN;
		this.year = year;
		this.color = color;
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.price = price;
	}

	public boolean addNewCar(int VIN, int year, String color, String make, String model, int mileage, double price) {
		this.VIN = VIN;
		this.year = year;
		this.color = color;
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.price = price;
		return true;
	}
	
	public int getVIN() {
		return VIN;
	}

	public int getYear() {
		return year;
	}

	public String getColor() {
		return color;
	}

	public String getModel() {
		return model;
	}
	
	public String getMake() {
		return make;
	}

	public int getMileage() {
		return mileage;
	}

	public double getPrice() {
		return price;
	}
}
