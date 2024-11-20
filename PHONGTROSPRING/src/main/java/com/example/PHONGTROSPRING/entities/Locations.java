package com.example.PHONGTROSPRING.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Locations")
public class Locations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locationId;

	@Column(nullable = false, length = 100, columnDefinition = "varchar(255)")
	private String city;

	@Column(nullable = false, length = 100, columnDefinition = "varchar(255)")
	private String district;

	public Locations() {
		
	}
	
	public Locations(String city, String district) {
		this.city = city;
		this.district = district;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
}
