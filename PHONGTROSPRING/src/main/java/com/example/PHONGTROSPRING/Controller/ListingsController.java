package com.example.PHONGTROSPRING.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.PHONGTROSPRING.service.ImagesService;
import com.example.PHONGTROSPRING.service.ListingsService;

@Controller
public class ListingsController {

	@Autowired
	private ListingsService listingsService;

	@Autowired
	private ImagesService imageService;

	/*
	 * @GetMapping("/add-listing") public String add() {
	 * listingsService.addSampleListings(); return "ok"; }
	 */

	@GetMapping("/detailRoom/id={roomId}")
	public String detailRoom(@PathVariable int roomId, Model model) {
		
		// Tin chính
		model.addAttribute("listDescription", listingsService.cutStringDescription(listingsService.getRoomById(roomId).getDescription()));
		model.addAttribute("room", listingsService.getRoomById(roomId));
		model.addAttribute("image", imageService.getImageById(roomId));
		model.addAttribute("time", listingsService.date(listingsService.getRoomById(roomId).getCreatedAt()));
		
		// Tin nổi bật
		model.addAttribute("FeaturedNew", listingsService.getRoomFeatured(listingsService.getRoomById(roomId).getLocation().getLocationId()));
		model.addAttribute("imgFeaturedNew", listingsService.getImageFollowRoomFeatured(imageService.getImage()));
		model.addAttribute("timeFeaturedNew", listingsService.dateArray(listingsService.getRoomFeatured(listingsService.getRoomById(roomId).getLocation().getLocationId())));
		
		// Tin mới đăng
		model.addAttribute("newRooms", listingsService.getNewRoom(listingsService.getRoomById(roomId).getLocation().getLocationId()));
		model.addAttribute("timeNewRooms", listingsService.dateArray(listingsService.getNewRoom(listingsService.getRoomById(roomId).getLocation().getLocationId())));
		
		return "views/detailRooms";
	}
}
