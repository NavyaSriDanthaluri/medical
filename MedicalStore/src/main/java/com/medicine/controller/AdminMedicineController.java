package com.medicine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.dto.ErrorDTO;
import com.medicine.dto.MedicineResponseDTO;
import com.medicine.dto.MyDTO;
import com.medicine.entity.Medicine;
import com.medicine.service.MedicineService;
import com.medicine.util.MedicineDTOConverter;

@RestController
@RequestMapping("/admin/medicalstore")
@Validated
public class AdminMedicineController {

	@Autowired
	MedicineService medicineService;

	@Autowired
	MedicineDTOConverter dtoConverter;

	private final Logger mylogs = LoggerFactory.getLogger(getClass());

	public AdminMedicineController() {
		System.out.println("\n\n\n=======>> Inside Constructor " + this);
	}

	// localhost:8002/admin/medicalstore/addmedicine
	@PostMapping("/addmedicine")
	public ResponseEntity<MyDTO> addBook(@RequestBody @Validated Medicine medicine) {
		try {
			Medicine savedMedicine = medicineService.addMedicine(medicine);
			MedicineResponseDTO dto = MedicineDTOConverter.convertToDTO(savedMedicine);
			return new ResponseEntity<MyDTO>(dto, HttpStatus.OK);
		} catch (Exception e) {

			ErrorDTO errorDTO = new ErrorDTO(e.getMessage());
			return new ResponseEntity<MyDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// localhost:8002/admin/medicalstore/delete/1
	@DeleteMapping("/delete/{medicineId}")
		public ResponseEntity<String> deleteMedicine(@PathVariable Long medicineId) {
		try {
			String deletedMedicine = medicineService.deleteMedicine(medicineId);
			String responseMsg = "deleted the medicine selected";
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact concerned manager \n" + e;
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//// localhost:8002/admin/medicalstore/update
	@PutMapping("/update")
	public Medicine updateMedicine(@RequestBody Medicine medicineDetails) throws Exception {

		return medicineService.updateMedicine(medicineDetails);
	}
}
