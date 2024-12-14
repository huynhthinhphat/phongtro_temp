package com.example.PHONGTROSPRING.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.PHONGTROSPRING.entities.Images;
import com.example.PHONGTROSPRING.entities.Listings;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Integer> {

	List<Images> findByListingItemId(int itemId);

	List<Images> findByListing(Listings listing);

	@Query("SELECT i.imageUrl FROM Images i WHERE i.listing.itemId = :item_id")
	List<byte[]> findByItemId(@Param("item_id") int item_id);

	@Query("SELECT i.imageUrl FROM Images i WHERE i.listing.itemId = :item_id")
	List<byte[]> findByItemIdFromFeaturedNew(@Param("item_id") int item_id, Pageable pageable);
}
