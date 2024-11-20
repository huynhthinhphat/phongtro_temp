package com.example.PHONGTROSPRING.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PHONGTROSPRING.entities.Images;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Integer>{
	
	List<Images> findByListingItemId(int itemId);
}
