package com.example.PHONGTROSPRING.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.PHONGTROSPRING.entities.Images;
import com.example.PHONGTROSPRING.entities.Listings;
import com.example.PHONGTROSPRING.repository.ImagesRepository;

@Service
public class ImagesService {

	@Autowired
	private ImagesRepository imagesReopsitory;
	
	/*
	 * public void add() { Listings listing = new Listings(); listing.setItemId(2);
	 * 
	 * Images image1 = new Images(); image1.setListing(listing);
	 * image1.setImageUrl("/assets/images/imgRooms/anh1.jpg");
	 * 
	 * Images image2 = new Images(); image2.setListing(listing);
	 * image2.setImageUrl("/assets/images/imgRooms/anh2.jpg");
	 * 
	 * Images image3 = new Images(); image3.setListing(listing);
	 * image3.setImageUrl("/assets/images/imgRooms/anh3.jpg");
	 * 
	 * imagesReopsitory.save(image1); imagesReopsitory.save(image2);
	 * imagesReopsitory.save(image3); }
	 */
	
	public List<Images> getImageById(int listingId){
		return imagesReopsitory.findByListingItemId(listingId);
	}
	
	public List<Images> getImage(){
		return imagesReopsitory.findAll(Sort.by(Sort.Order.asc("listing.itemId")));
	}
}
