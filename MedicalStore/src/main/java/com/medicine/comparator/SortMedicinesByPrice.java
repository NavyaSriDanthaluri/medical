package com.medicine.comparator;

import java.util.Comparator;

import com.medicine.entity.Medicine;

public class SortMedicinesByPrice implements Comparator<Medicine>{

	@Override
	public int compare(Medicine o1, Medicine o2) {

		return o2.getMedicinePrice() - o1.getMedicinePrice();
	}

}
