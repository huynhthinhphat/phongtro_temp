package com.example.PHONGTROSPRING.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FooterController {

	@GetMapping("/footer/{page}")
	public String redirectPage(@PathVariable String page) {
		switch (page) {
		case "gioithieu": {
			return "views/footer-infor-about-website/vephongtro/gioithieu";
		}
//		case "banggiadichvu":{
//			return "views/footer-infor-about-website/danhchokhachhang/banggiadichvu";
//		}
		default:
			return "views/footer-infor-about-website/vephongtro/gioithieu";
		}
	}

}
