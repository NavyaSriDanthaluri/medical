package com.medicine.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.comparator.SortMedicinesByName;
import com.medicine.comparator.SortMedicinesByPrice;
import com.medicine.entity.Medicine;
import com.medicine.repository.MedicineRepository;

import jakarta.transaction.Transactional;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineRepository medicineRepository;

	@Override
	@Transactional
	public Medicine addMedicine(Medicine medicines) throws Exception {
		Medicine savedMedicine = medicineRepository.save(medicines);
		if (savedMedicine != null) {
			return savedMedicine;
		} else
			return null;
	}

	@Override
	public Medicine getById(Long medicineId) throws Exception {
		return medicineRepository.findById(medicineId).get();
	}

	@Override
	public String deleteMedicine(Long medicineId) throws Exception {
		medicineRepository.deleteById(medicineId);
		return "Medicine deleted";
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) throws Exception {
			Medicine savedMedicine = medicineRepository.save(medicine);
			return savedMedicine;
	}

	@Override
	public List<Medicine> sortMedicinesByPrice() throws Exception {
		List<Medicine> list = medicineRepository.findAll();
		List<Medicine> medicine = new ArrayList<>();
		Collections.sort(list, new SortMedicinesByPrice());
		return list;
	}
	
	@Override
	public List<Medicine> sortMedicinesByName() throws Exception {
		List<Medicine> list = medicineRepository.findAll();
		List<Medicine> medicine = new ArrayList<>();
		Collections.sort(list, new SortMedicinesByName());
		return list;
	}
}