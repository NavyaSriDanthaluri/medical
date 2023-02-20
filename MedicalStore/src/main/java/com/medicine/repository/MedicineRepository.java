package com.medicine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicine.entity.Medicine;


public interface MedicineRepository extends JpaRepository<Medicine , Long> , IMedicineCustomRepository{

}
