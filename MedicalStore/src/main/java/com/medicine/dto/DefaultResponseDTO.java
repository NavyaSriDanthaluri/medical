package com.medicine.dto;

import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DefaultResponseDTO {

	private String medicineName;
	private Integer medicinePrice;
}
