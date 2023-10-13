package com.jspiders.SpringMvc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.jspiders.SpringMvc1.pojo.CarPOJO;
import com.jspiders.SpringMvc1.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository repository;

	public List<CarPOJO> findAllCars() {
		List<CarPOJO> cars=repository.findAllCars();
		return cars;
	}

	public CarPOJO addCar(String name, String model, String brand, String fuel, double price) {
		CarPOJO pojo=repository.addCar(name,model,brand,fuel,price);
		return pojo;
	}

	public CarPOJO searchCar(int id) {
		CarPOJO pojo=repository.searchCar(id);
		return pojo;
	}

	public CarPOJO removeCar(int id) {
		CarPOJO pojo=repository.removeCar(id);
		return pojo;
	}

	public CarPOJO updateCar(int id, String name, String model, String brand, String fuel, double price) {
		CarPOJO pojo=repository.updateCar(id,name,model,brand,fuel,price);
		return pojo;
	}

	public List<CarPOJO> searchCarsByName(String name) {
		 List<CarPOJO> cars=repository.findByName(name);
		return cars;
	}

	public List<CarPOJO> searchCarsByFuelType(String fuel) {
		List<CarPOJO>cars=repository.findByFuelType(fuel);
		return cars;
	}

	

}
