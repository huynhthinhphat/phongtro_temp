package com.example.PHONGTROSPRING.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PHONGTROSPRING.service.LocationService;

@RestController
public class LocationController {

	@Autowired
	private LocationService locationService;

	@GetMapping("/add-locations")
	public String addLocations() {
		locationService.addLocations(); // Gọi service để thêm dữ liệu
		return "Locations added successfully!";
	}
}
