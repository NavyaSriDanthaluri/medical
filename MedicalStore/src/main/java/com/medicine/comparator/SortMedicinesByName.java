package com.medicine.comparator;

import java.util.Comparator;

import com.medicine.entity.Medicine;

public class SortMedicinesByName implements Comparator<Medicine> {

	@Override
	public int compare(Medicine o1, Medicine o2) {
		
		return o1.getMedicineName().compareTo(o2.getMedicineName());
	}

}
