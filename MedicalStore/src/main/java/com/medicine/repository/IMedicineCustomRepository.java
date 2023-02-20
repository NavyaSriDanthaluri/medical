package com.medicine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medicine.entity.Medicine;

public interface IMedicineCustomRepository {
	
	
	
	@Query("from Medicine where medicinePrice >= :rate1 and medicinePrice <= :rate2")
	public List<Medicine> getMedicinesBetweenPrice(@Param("rate1") Integer rate1,@Param("rate2") Integer rate2)throws Exception;
	
}
