package com.CarDealership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;

public class CarDaoImpl implements CarDao {

	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public void createCar(Car c) {

		try {
			conn.setAutoCommit(false);
			PreparedStatement statement = conn.prepareStatement(
					"insert into Car(vin, make, price, year, color, model, mileage) "
							+ "values (?, ?, ?, ?, ?, ?, ?)");
			statement.setInt(1, c.getVIN());
			statement.setString(2, c.getMake());
			statement.setDouble(3, c.getPrice());
			statement.setInt(4, c.getYear());
			statement.setString(5, c.getColor());
			statement.setString(6, c.getModel());
			statement.setInt(7, c.getMileage());

			Savepoint sp = conn.setSavepoint("Before adding a car");
			boolean check = statement.execute();
			if(check) {
				conn.rollback(sp);
				LoggingUtil.error("Error.  Rolling back");
			}
			conn.commit();
			conn.setAutoCommit(true);
			LoggingUtil.info("Adding car");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCar(Car c) {

		try {
			conn.setAutoCommit(false);
			PreparedStatement statement = conn.prepareStatement("update Car set active = 'yes' where VIN = ?");
			
			Savepoint sp2 = conn.setSavepoint("Before deleting a car");
			boolean check = statement.execute();
			if(check) {
				conn.rollback(sp2);
				LoggingUtil.error("Error.  Rolling back");
			}
			conn.commit();
			conn.setAutoCommit(true);
			LoggingUtil.info("Deleting car");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Car> getAllCars() {
		// TODO Auto-generated method stub
		return null;
	}


}
