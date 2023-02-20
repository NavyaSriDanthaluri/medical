package com.medicine.service;

import java.util.List;

import com.medicine.entity.Medicine;

public interface MedicineService {
	
	public Medicine addMedicine(Medicine medicine) throws Exception ;
	
	public Medicine getById(Long medicineId) throws Exception;
	
	public String deleteMedicine(Long medicineId) throws Exception;
	
	public Medicine updateMedicine(Medicine medicine) throws Exception;
	
	public List<Medicine> sortMedicinesByPrice() throws Exception;

	public List<Medicine> sortMedicinesByName() throws Exception;
	
}