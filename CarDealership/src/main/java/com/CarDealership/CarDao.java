package com.CarDealership;

import java.util.ArrayList;

public interface CarDao {
	
	public void createCar(Car c);
	
	public void deleteCar(Car c);
	
	public ArrayList<Car> getAllCars();

}
