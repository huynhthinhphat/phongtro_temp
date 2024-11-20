package com.example.PHONGTROSPRING.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PHONGTROSPRING.entities.RoomTypes;

@Repository
public interface RoomTypesRepository extends JpaRepository<RoomTypes, Integer> {
   
}
