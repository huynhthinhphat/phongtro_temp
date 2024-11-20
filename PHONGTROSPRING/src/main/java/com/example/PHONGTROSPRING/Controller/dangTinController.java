package com.example.PHONGTROSPRING.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dangTinController {

	@GetMapping({"/dangtin"})
	public String dangtin() {
		return "views/dangtin";
	}
}
