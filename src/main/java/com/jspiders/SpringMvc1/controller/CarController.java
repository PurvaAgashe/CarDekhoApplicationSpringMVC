package com.jspiders.SpringMvc1.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.SpringMvc1.pojo.AdminPOJO;
import com.jspiders.SpringMvc1.pojo.CarPOJO;
import com.jspiders.SpringMvc1.service.CarService;
 
@Controller
public class CarController {
	@Autowired 
	private CarService service;
	
	@GetMapping("/home")
	public String home(@SessionAttribute(name= "login",required=false)AdminPOJO admin,ModelMap map) {
		if (admin!=null) {
			return "Home";
			
		}
		map.addAttribute("msg", "session inactive. login to proceed..!");
		return "Login";
		
	}
	@GetMapping("/add")
	public String addPage(@SessionAttribute(name= "login",required=false)AdminPOJO admin,ModelMap map) {
		if (admin!=null) {
			List<CarPOJO> cars=service.findAllCars();
			if(!cars.isEmpty()) {
				map.addAttribute("cars", cars);
				return "Add";
			}
			return "Add";	
			
		}
		map.addAttribute("msg", "session inactive. login to proceed..!");
		return "Login";
	}
	//Add car controller
    @PostMapping("/add")
    public String addCar(@SessionAttribute(name= "login",required=false)AdminPOJO admin,@RequestParam String name,
   		 @RequestParam String model, 
   		 @RequestParam String brand , 
   		 @RequestParam String fuel,
   		 @RequestParam double price,
   		 ModelMap map) 
    {
   	  if (admin!=null) {
   		  CarPOJO pojo=service.addCar(name,model,brand,fuel,price);
       	  
       	  //success
       	  if(pojo!=null) {
       		  map.addAttribute("msg","Data inserted successfully...");
       		  List<CarPOJO> cars=service.findAllCars();
       		  map.addAttribute("cars", cars);
     			return "Add";
       	  }
   		  map.addAttribute("msg","Data not inserted...!");
       	 return "Add";			
		}
   	  map.addAttribute("msg", "session inactive. login to proceed..!");
 		return "Login"; 
    
    }
    //search car 
    @GetMapping("/search")
	public String searchPage(@SessionAttribute(name= "login",required=false)AdminPOJO admin,ModelMap map) {
		if (admin!=null) {
			return "Search";
			
		}
		 map.addAttribute("msg", "session inactive. login to proceed..!");
	  		return "Login"; 
	}
//    @PostMapping("/search")
//	public String searchCar(@SessionAttribute(name= "login",required=false)AdminPOJO admin,@RequestParam int id, ModelMap map) {
//		if (admin!=null) {
//			CarPOJO pojo=service.searchCar(id);
//			
//			//success
//			if(pojo != null) {
//				map.addAttribute("car",pojo);
//				map.addAttribute("msg","car data Found...!");
//				return "Search";
//			}
//			map.addAttribute("msg","car data not found");
//			return "Search";
//			
//		}
//		 map.addAttribute("msg", "session inactive. login to proceed..!");
//	  		return "Login"; 
//	}
    @PostMapping("/search")
   	public String searchCar(@SessionAttribute(name= "login",required=false)AdminPOJO admin,@RequestParam(name = "id", required = false, defaultValue = "0") int id,@RequestParam(required = false) String name,
   	        @RequestParam(required = false) String fuel, ModelMap map) {
   		if (admin!=null) {
   		 List<CarPOJO> cars = null;
   			
   		if (id!= 0) {
            // Search by ID
            CarPOJO pojo = service.searchCar(id);
            if (pojo != null) {
                cars = Collections.singletonList(pojo);
            }else {
                cars = null;
            }
        } else if (name != null && !name.isEmpty()) {
            // Search by Name
            cars = service.searchCarsByName(name);
        } else if (fuel != null && !fuel.isEmpty()) {
            // Search by Fuel Type
            cars = service.searchCarsByFuelType(fuel);
        }
   			//success
   			if(cars != null && !cars.isEmpty()) {
   				map.addAttribute("car",cars);
   				map.addAttribute("msg","car data Found...!");
   				return "Search";
   			}
   			map.addAttribute("msg","car data not found");
   			return "Search";
   			
   		}
   		 map.addAttribute("msg", "session inactive. login to proceed..!");
   	  		return "Login"; 
   	}
    
    @GetMapping("/remove")
	public String removePage(@SessionAttribute(name= "login",required=false)AdminPOJO admin,ModelMap map) {
		if (admin!=null) {
			List<CarPOJO> cars=service.findAllCars();
			if (!cars.isEmpty()) {
				map.addAttribute("cars",cars);
				return "Remove";
				
			}
			map.addAttribute("msg", "Data not exist");
			return "Remove";
			
		}
		 map.addAttribute("msg", "session inactive. login to proceed..!");
	  		return "Login"; 
		
	}
    
    @PostMapping("/remove")
	public String removeCar(@SessionAttribute(name= "login",required=false)AdminPOJO admin,@RequestParam int id , ModelMap map) {
		if (admin!=null) {
			CarPOJO pojo=service.removeCar(id);
			List<CarPOJO> cars=service.findAllCars();
			
			
			if(pojo !=null) {
				map.addAttribute("msg", "Data removed successfully...!");
				map.addAttribute("cars", cars);
		     return "Remove";
				
			}
			map.addAttribute("msg", "Data does not exist");
			map.addAttribute("cars", cars);
			return "Remove";
			
		}
		 map.addAttribute("msg", "session inactive. login to proceed..!");
	  		return "Login"; 
	}
    @GetMapping("/update")
	public String updatePage(@SessionAttribute(name= "login",required=false)AdminPOJO admin, ModelMap map) {
		if (admin!=null) {
			List<CarPOJO> cars=service.findAllCars();
			map.addAttribute("cars",cars);
			return "Update";
			
		}
		map.addAttribute("msg", "session inactive. login to proceed..!");
  		return "Login";
	}
    @PostMapping("/update")
	public String updateForm(@SessionAttribute(name= "login",required=false)AdminPOJO admin,@RequestParam int id ,ModelMap map) {
		if (admin!=null) {
			CarPOJO pojo= service.searchCar(id);
			//success
			if (pojo != null) {
				map.addAttribute("car", pojo);
				return "Update";
				
			}
			//failure
			List<CarPOJO> cars=service.findAllCars();
			map.addAttribute("cars",cars);
			map.addAttribute("msg", "car data not found");
			return "Update";
			
		}
		map.addAttribute("msg", "session inactive. login to proceed..!");
  		return "Login";
		
		
	}
    @PostMapping("/updateCar")
	public String updateCar(@SessionAttribute(name= "login",required=false)AdminPOJO admin,@RequestParam int id,
			@RequestParam String name,
			@RequestParam String model,
			@RequestParam String brand,
			@RequestParam String fuel, 
			@RequestParam double price, ModelMap map) {
		
		if (admin!=null) {
			CarPOJO pojo =service.updateCar(id,name,model,brand,fuel,price);
			//success
			if (pojo !=null) {
				List<CarPOJO> cars=service.findAllCars();
				map.addAttribute("msg", "Data Udated successfully");
				map.addAttribute("cars", cars);
				return "Update";
				
			}
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("msg", "Data Not Updated!...");
			map.addAttribute("cars", cars);
			return  "Update";
			
		}
		map.addAttribute("msg", "session inactive. login to proceed..!");
  		return "Login";
	
    }

}
