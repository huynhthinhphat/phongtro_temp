package com.example.PHONGTROSPRING.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PHONGTROSPRING.entities.Locations;

@Repository
public interface LocationRepository extends JpaRepository<Locations, Integer>{

}
