package com.example.PHONGTROSPRING.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.PHONGTROSPRING.entities.Transactions;
import com.example.PHONGTROSPRING.request.TransactionsRequest;
import com.example.PHONGTROSPRING.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/transactions")
	public String viewTransactions(HttpSession session, Model model) {

		// Kiểm tra xem người dùng đã đăng nhập chưa
		if (session.getAttribute("user") == null) {
			return "redirect:/login"; // Chuyển hướng đến trang đăng nhập nếu chưa đăng nhập
		}

		List<Transactions> transactions = adminService.viewTransactions();
		model.addAttribute("transactions", transactions);
		return "views/admin/transactions";
	}

	@PostMapping("/transactions/update")
	public String updateTransactions(HttpSession session, Integer transactionId, String newStatus,  Model model) {
		// Kiểm tra xem người dùng đã đăng nhập chưa
		if (session.getAttribute("user") == null) {
			return "redirect:/login"; // Chuyển hướng đến trang đăng nhập nếu chưa đăng nhập
		}

		adminService.updateTransactions(transactionId, newStatus);
		return "redirect:/admin/transactions";
	}

	@GetMapping("/transactions/search")
	public String filterTransactions(@ModelAttribute TransactionsRequest transactionsRequest, HttpSession session,
			Model model) {

		// Kiểm tra xem người dùng đã đăng nhập chưa
	    if (session.getAttribute("user") == null) {
	        return "redirect:/login"; // Chuyển hướng đến trang đăng nhập nếu chưa đăng nhập
	    }
	    
	    List<Transactions> transactions = adminService.searchTransactions(transactionsRequest);
	    
	    model.addAttribute("transactions", transactions);
	    model.addAttribute("transactionsRequest", transactionsRequest);
	    
		return "views/admin/transactions";
	}
}
