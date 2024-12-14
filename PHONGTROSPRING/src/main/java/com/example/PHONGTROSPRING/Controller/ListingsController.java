package com.example.PHONGTROSPRING.Controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.PHONGTROSPRING.entities.*;
import com.example.PHONGTROSPRING.response.ListingsResponse;
import com.example.PHONGTROSPRING.service.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class ListingsController {

	@Autowired
	private ImagesService imageService;

	@Autowired
	private ServicePostNew ServicePostNew;

	@Autowired
	private ListingsService listingsService;

	/*
	 * @GetMapping("/add-listing") public String add() {
	 * listingsService.addSampleListings(); return "ok"; }
	 */

	@GetMapping("/detailRoom/id={roomId}")
	public String detailRoom(@PathVariable int roomId, Model model) {

		Listings room = listingsService.findById(roomId);

		model.addAttribute("room", room);
		model.addAttribute("listDescription", listingsService.cutStringDescription(room.getDescription()));

		// Ảnh
		model.addAttribute("listImages", listingsService.getImages(roomId));

		// Tin nổi bật lấy theo vị trí district, ko lấy những phòng có id là id phòng
		// hiện tại, lấy theo loại phòng
		model.addAttribute("featuredNew", setImageForListingsResponse(listingsService.findAllListingsFeatured(room.getItemId(),
				room.getRoomType().getRoomTypeId(), room.getLocation_district().getDistrict_id())));
		
		//Tin vừa đăng
		model.addAttribute("newRooms", setImageForListingsResponse(listingsService.findAllNewsJustPosted(room.getItemId(),
				room.getRoomType().getRoomTypeId(), room.getLocation_district().getDistrict_id())));

		return "views/detailRooms";
	}
	
	//set ảnh cho từng đối tượng listingsResponse
	public List<ListingsResponse> setImageForListingsResponse(List<ListingsResponse> listingResponse){
		List<ListingsResponse> list = new ArrayList<>();
		
		for (ListingsResponse item : listingResponse) {
			item.setImageUrl(listingsService.findImageByItemId(item.getItemId()).get(0));
			list.add(item);
		}
		
		return list;
	}

//		// Tin nổi bật
//		model.addAttribute("FeaturedNew",
//				listingsService.getRoomFeatured(listingsService.getRoomById(roomId).getLocation().getLocationId()));
//		model.addAttribute("imgFeaturedNew", listingsService.getImageFollowRoomFeatured(imageService.getImage()));
//		model.addAttribute("timeFeaturedNew", listingsService.dateArray(
//				listingsService.getRoomFeatured(listingsService.getRoomById(roomId).getLocation().getLocationId())));
//
//		// Tin mới đăng
//		model.addAttribute("newRooms",
//				listingsService.getNewRoom(listingsService.getRoomById(roomId).getLocation().getLocationId()));
//		model.addAttribute("timeNewRooms", listingsService.dateArray(
//				listingsService.getNewRoom(listingsService.getRoomById(roomId).getLocation().getLocationId())));

//	@GetMapping("/phongtro")
////	public String PhongtroInfo(Model model) {

	// Lấy danh sách phòng từ service
//		List<Listings> listings = listingsService.getAllListings();
//		List<phongtroresponse> listphongtrocoanh = new ArrayList<phongtroresponse>();
//		for (int i = 0; i < listings.size(); i++) {
//			List<byte[]> imageBytes = ServicePostNew.getanh(listings.get(i).getItemId());
//
//			List<String> listurlimg = new ArrayList<String>();
//			for (byte[] img : imageBytes) {
//				listurlimg.add("data:image/jpg;base64," + Base64.getEncoder().encodeToString(img));
//			}
//
//			phongtroresponse phongtro = new phongtroresponse();
//			phongtro.setListings(listurlimg);
//			phongtro.setItemId(listings.get(i).getItemId());
//			phongtro.setUser(listings.get(i).getUser());
//			phongtro.setTitle(listings.get(i).getTitle());
//			phongtro.setDescription(listings.get(i).getDescription());
//			phongtro.setPrice(listings.get(i).getPrice());
//			phongtro.setArea(listings.get(i).getArea());
//			phongtro.setLocation(listings.get(i).getLocation());
//			phongtro.setAddress(listings.get(i).getAddress());
//			phongtro.setRoomType(listings.get(i).getRoomType());
//			phongtro.setCreatedAt(listings.get(i).getCreatedAt());
//			phongtro.setExpiryDate(listings.get(i).getExpiryDate());
//			phongtro.setUpdatedAt(listings.get(i).getUpdatedAt());
//			phongtro.setPostType(listings.get(i).getPostType());
//			phongtro.setStatus(listings.get(i).getStatus());
//			phongtro.setObject(listings.get(i).getObject());
//
//			listphongtrocoanh.add(phongtro);
//
//		}

	// String base64Image = "data:image/png;base64," +
	// Base64.getEncoder().encodeToString(imageBytes);
	/*
	 * model.addAttribute("urlimg", listurlimg);
	 * System.out.println("anh ne "+listurlimg);
	 */
	// Đưa danh sách vào model để truyền qua HTML
//		model.addAttribute("listings", listphongtrocoanh);
//		// System.out.println("data co hoac khong " + listphongtrocoanh);
//
//		return "views/phongtro";
//	}


}
