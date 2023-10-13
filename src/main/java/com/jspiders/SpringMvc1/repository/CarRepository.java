package com.jspiders.SpringMvc1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.jspiders.SpringMvc1.pojo.CarPOJO;

@Repository
public class CarRepository {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static Query query;
	
	public static void openConnnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("mvc1");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction =entityManager.getTransaction();
	}
	public static void closeConnection() {
		if (entityManagerFactory!=null) {
			entityManagerFactory.close();	
		}
		if (entityManager!=null) {
			entityManager.close();			
		}
		if (entityTransaction!=null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			
		}
	}

	public List<CarPOJO> findAllCars() {
		openConnnection();
		entityTransaction.begin();
		 
		//for each loop
		String jpql="from CarPOJO";
		query=entityManager.createQuery(jpql);
		List<CarPOJO> cars=query.getResultList();
		
		
		entityTransaction.commit();
		closeConnection();
		return cars;
	}

	public CarPOJO addCar(String name, String model, String brand, String fuel, double price) {
		openConnnection();
		entityTransaction.begin();
		 
		CarPOJO pojo =new CarPOJO();
		pojo.setName(name);
		pojo.setModel(model);
		pojo.setBrand(brand);
		pojo.setFuel(fuel);
		pojo.setPrice(price);
		
		entityManager.persist(pojo);
		entityTransaction.commit();
		closeConnection();
			return pojo;
	}

	public CarPOJO searchCar(int id) {
		
		openConnnection();
		entityTransaction.begin();
		CarPOJO pojo=entityManager.find(CarPOJO.class,id);
		 
		entityTransaction.commit();
		closeConnection();
		return pojo;
	}

	public CarPOJO removeCar(int id) {
		openConnnection();
		entityTransaction.begin();
		
		 CarPOJO pojo=entityManager.find(CarPOJO.class, id);
		 if (pojo !=null) {
			 entityManager.remove(pojo);
		}
		entityTransaction.commit();
		closeConnection();
		return pojo;
	}

	public CarPOJO updateCar(int id, String name, String model, String brand, String fuel, double price) {
		
		openConnnection();
		entityTransaction.begin();
		CarPOJO pojo=entityManager.find(CarPOJO.class, id);
		pojo.setName(name);
		pojo.setModel(model);
		pojo.setBrand(brand);
        pojo.setFuel(fuel);
        pojo.setPrice(price);
        entityManager.persist(pojo);
		
		
		entityTransaction.commit();
		closeConnection();
		return pojo;
	}
	public List<CarPOJO> findByName(String name) {
		      openConnnection();
	        entityTransaction.begin();

	        String jpql = "SELECT CarPOJO FROM CarPOJO CarPOJO WHERE CarPOJO.name = :name";
	        query = entityManager.createQuery(jpql);
	        query.setParameter("name", name);
	        List<CarPOJO> cars = query.getResultList();

	        entityTransaction.commit();
	        closeConnection();
		return cars;
	}
	public List<CarPOJO> findByFuelType(String fuel) {
		 openConnnection();
	        entityTransaction.begin();

	        String jpql = "SELECT CarPOJO FROM CarPOJO CarPOJO WHERE CarPOJO.fuel = :fuel";
	        query = entityManager.createQuery(jpql);
	        query.setParameter("fuel", fuel);
	        List<CarPOJO> cars = query.getResultList();

	        entityTransaction.commit();
	        closeConnection();
	        return cars;
	}

}
