package com.example.PHONGTROSPRING.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.PHONGTROSPRING.entities.LocationsDistrict;
import com.example.PHONGTROSPRING.response.ListingsResponse;
import com.example.PHONGTROSPRING.service.*;

@Controller
public class FooterController {

	@Autowired
	private ListingsService listingsService;

	@Autowired
	private LocationsCityService locationsCityService;

	@Autowired
	private LocationsDistrictService locationsDistrictService;

	@Autowired
	private RoomTypesService roomTypesService;

	@GetMapping("/footer/{page}")
	public String redirectPage(@PathVariable String page) {
		switch (page) {
		case "gioithieu": {
			return "views/footer-infor-about-website/vephongtro/gioithieu";
		}
		case "quychehoatdong": {
			return "views/footer-infor-about-website/vephongtro/quychehoatdong";
		}
		case "quydinhsudung": {
			return "views/footer-infor-about-website/vephongtro/quydinhsudung";
		}
		case "chinhsachbaomat": {
			return "views/footer-infor-about-website/vephongtro/chinhsachbaomat";
		}
		case "cauhoithuonggap": {
			return "views/footer-infor-about-website/danhchokhachhang/cauhoithuonggap";
		}
		case "huongdandangtin": {
			return "views/footer-infor-about-website/danhchokhachhang/huongdandangtin";
		}
		case "quydinhdangtin": {
			return "views/footer-infor-about-website/danhchokhachhang/quydinhdangtin";
		}
		case "banggiadichvu": {
			return "views/footer-infor-about-website/danhchokhachhang/banggiadichvu";
		}
		case "giaiquyetkhieunai": {
			return "views/footer-infor-about-website/danhchokhachhang/giaiquyetkhieunai";
		}
		default:
			return "views/footer-infor-about-website/vephongtro/gioithieu";
		}
	}

	@GetMapping("/{typeroom}/{city}")
	public String danhSachPhongTro(@PathVariable String typeroom, @PathVariable String city,
			@RequestParam(value = "orderby", defaultValue = "mac-dinh") String orderby, Model model) {

		String typeroom_default = typeroom;
		String city_default = city;

		model.addAttribute("city_default", city_default);
		model.addAttribute("typeroom_default", typeroom_default);

		if (typeroom.equals("phongtro")) {
			typeroom = "Phòng trọ ";
		} else if (typeroom.equals("thuenha")) {
			typeroom = "Nhà nguyên căn ";
		} else if (typeroom.equals("thuecanho")) {
			typeroom = "Căn hộ ";
		} else if (typeroom.equals("thuematbang")) {
			typeroom = "Mặt bằng ";
		} else if (typeroom.equals("oghep")) {
			typeroom = "Ở Ghép ";
		}

		if (city.equals("HCM")) {
			city = "Thành phố Hồ Chí Minh";
		} else if (city.equals("HN")) {
			city = "Hà Nội";
		} else if (city.equals("BD")) {
			city = "Tỉnh Bình Định";
		}

		int city_id = locationsCityService.findByCityName(city);

		// Tiêu đề page
		model.addAttribute("title", "Cho thuê " + typeroom + city);

		model.addAttribute("city", city);
		model.addAttribute("typeroom", typeroom);

		// Số lượng bài đăng
		model.addAttribute("quantity_post", listingsService.getQuantityPost());

		// District của city tương ứng
		model.addAttribute("list_district",
				UtitilyService.changeDistrictName(locationsDistrictService.getDistrict(city_id)));

		int roomtype_id = roomTypesService.findRoomTypeByName(typeroom);
		
		System.out.println(listingsService.getListings(roomtype_id, city_id).size());

		model.addAttribute("list_room", setImageForListingsResponse(listingsService.getListings(roomtype_id, city_id)));

		return "views/ListRoomsSearchFromFooter";
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
}
