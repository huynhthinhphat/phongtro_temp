package com.example.PHONGTROSPRING.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PHONGTROSPRING.entities.*;

@Repository
public interface LocationsCityRepository extends JpaRepository<LocationsCity, Integer>{
	List<LocationsCity> findByCity(String city);
}
