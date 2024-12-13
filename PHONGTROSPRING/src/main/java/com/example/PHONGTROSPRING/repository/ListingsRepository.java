package com.example.PHONGTROSPRING.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.PHONGTROSPRING.entities.Listings;

@Repository
public interface ListingsRepository extends JpaRepository<Listings, Integer>{

//	@Query("SELECT l FROM Listings l WHERE l.location.locationId = :locationId ORDER BY l.postType DESC, l.createdAt DESC")
//	List<Listings> findAllListingsOrderByPostTypeAndCreatedAt(@Param("locationId") int locationId);
//	
//	@Query("SELECT l FROM Listings l WHERE l.location.locationId = :locationId ORDER BY l.createdAt DESC")
//	List<Listings> findAllListingsFollowLocationAndCreatedAt(@Param("locationId") int locationId);

}
