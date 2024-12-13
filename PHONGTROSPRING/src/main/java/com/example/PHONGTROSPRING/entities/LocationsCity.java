package com.example.PHONGTROSPRING.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class LocationsCity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int city_id;

	@Column(nullable = false, length = 100, columnDefinition = "varchar(255)")
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
