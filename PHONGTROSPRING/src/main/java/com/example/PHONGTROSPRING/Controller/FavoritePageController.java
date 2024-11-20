package com.example.PHONGTROSPRING.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FavoritePageController {

	@GetMapping("/favorite")
	public String redirectFavoritepage() {
		
		return "views/favoritePage";
	}
}
