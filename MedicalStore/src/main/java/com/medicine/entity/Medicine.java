package com.medicine.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Medicines")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medicineId;
	@Column(name = "medicineName" , nullable = false)
	private String medicineName;
	@Column(name = "manufacturedDate" , nullable = false)
	private LocalDate manufacturedDate;
	@Column(name = "expiryDate" , nullable = false)
	private LocalDate expiryDate;
	@Column(name = "medicinePrice" , nullable = false)
	private Integer medicinePrice;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "medicineId")
	private List<Review> reviews;

}
