package com.example.PHONGTROSPRING.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PHONGTROSPRING.entities.LocationsDistrict;

public interface LocationsDistrictRepository extends JpaRepository<LocationsDistrict, Integer>{

	@Query("SELECT d FROM LocationsDistrict d WHERE d.district = :district")
	Optional<LocationsDistrict> findByDistrict(@Param("district") String district);
}
