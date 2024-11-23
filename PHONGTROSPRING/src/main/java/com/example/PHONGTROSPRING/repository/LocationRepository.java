package com.example.PHONGTROSPRING.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PHONGTROSPRING.entities.Locations;

@Repository
public interface LocationRepository extends JpaRepository<Locations, Integer>{
	List<Locations> findByCity(String city);
}
