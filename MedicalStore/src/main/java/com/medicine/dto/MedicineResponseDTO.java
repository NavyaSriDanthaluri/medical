package com.medicine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineResponseDTO implements MyDTO {
	

	private Long medicineId;
	private String medicineName;
	private Integer medicinePrice;
}
