package com.example.PHONGTROSPRING.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.PHONGTROSPRING.entities.LocationsCity;
import com.example.PHONGTROSPRING.service.addLocationService;

@Controller
public class AddLocationController {

	@GetMapping("/addlocation")
	public String getLocation(){
		return "views/addLocation";
	}
}
