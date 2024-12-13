package com.example.PHONGTROSPRING.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.PHONGTROSPRING.entities.Listings;

@Controller
public class FooterController {

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

//	@GetMapping("/phongtro/{diachi}")
//	public List<Listings> danhSachPhongTro(@PathVariable String diachi){
//		
//	}
	
}
