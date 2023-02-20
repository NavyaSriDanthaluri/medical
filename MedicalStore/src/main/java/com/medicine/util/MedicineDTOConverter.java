package com.medicine.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.medicine.dto.DefaultResponseDTO;
import com.medicine.dto.MedicineResponseDTO;
import com.medicine.entity.Medicine;


@Component
@Scope("singleton")
public class MedicineDTOConverter {
	
	public static DefaultResponseDTO  getDefaultDTO(Medicine medicine)
	{
		DefaultResponseDTO dto = new DefaultResponseDTO(
				medicine.getMedicineName(),
				medicine.getMedicinePrice());
		
		return dto;
	}

	public static  MedicineResponseDTO convertToDTO(Medicine medicine)
	{
		return new MedicineResponseDTO(medicine.getMedicineId(), medicine.getMedicineName(), medicine.getMedicinePrice());
	}

}

