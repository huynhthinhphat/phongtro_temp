package com.example.PHONGTROSPRING.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.PHONGTROSPRING.request.LoginRequest;
import com.example.PHONGTROSPRING.request.RegisterRequest;
import com.example.PHONGTROSPRING.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String loginPage(Model model) {
		if (model.containsAttribute("registerSuccess")) {
			model.addAttribute("loginMessage", model.getAttribute("registerSuccess"));
		}
		model.addAttribute("userlogin", new LoginRequest());
		return "views/login";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("userlogin") LoginRequest user, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			return "views/login";
		}
		if (userService.login(user) != null) {
			model.addAttribute("login", "Đăng nhập thành công");
			session.setAttribute("user", userService.login(user));
			return "views/home";

		}
		model.addAttribute("loginfail", "Tài khoản hoặc mật khẩu không chính xác");
		return "views/login";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("userRegister", new RegisterRequest());
		return "views/register";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("userRegister") RegisterRequest user, BindingResult result,
			Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "views/register";
		}
		if (!user.getPassword().equals(user.getConfirmPass())) {
			model.addAttribute("erros", "Mật khẩu không trùng khớp");
			return "views/register";
		}
		if (userService.checkPhone(user.getPhoneNumber())) {
			model.addAttribute("erros", "Tài khoản đã tồn tại trên hệ thống");
			return "views/register";
		}
		if (userService.register(user)) {
			redirectAttributes.addFlashAttribute("registerSuccess", "Đăng kí thành công , vui lòng đăng nhập");
			return "redirect:/login";
		} else {
			model.addAttribute("erros", "Có lỗi xảy ra");
			return "views/register";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		// Hủy session
		request.getSession().invalidate();
		return "redirect:/";
	}

}
