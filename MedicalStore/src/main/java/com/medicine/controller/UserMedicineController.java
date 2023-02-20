package com.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.medicine.entity.Medicine;
import com.medicine.service.MedicineService;


public class UserMedicineController {
	
	@Autowired
	MedicineService medicineService;

	public UserMedicineController() {
		System.out.println("\n\n\n=======>> Inside Constructor " + this);
	}

	// localhost:8002/user/bookstore/sort/rating
	@GetMapping("/sort/price")
	public List<Medicine> sortingByPrice() throws Exception {

		return medicineService.sortMedicinesByPrice();

	}
	
	// localhost:8002/user/bookstore/sort/name
	@GetMapping("/sort/name")
	public List<Medicine> sortingByName() throws Exception {

		return medicineService.sortMedicinesByName();

	}


}
