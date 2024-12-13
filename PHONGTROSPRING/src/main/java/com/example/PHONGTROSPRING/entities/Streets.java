package com.example.PHONGTROSPRING.entities;

import jakarta.persistence.*;

@Entity
public class Streets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int street_id;

	@ManyToOne
	@JoinColumn(name = "ward_id", nullable = false, referencedColumnName = "ward_id")
	private LocationsWard ward_id;

	@Column(nullable = false)
	private String street;

	public int getStreet_id() {
		return street_id;
	}

	public void setStreet_id(int street_id) {
		this.street_id = street_id;
	}

	public LocationsWard getWard_id() {
		return ward_id;
	}

	public void setWard_id(LocationsWard ward_id) {
		this.ward_id = ward_id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}
