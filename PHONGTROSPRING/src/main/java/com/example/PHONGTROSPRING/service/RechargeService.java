package com.example.PHONGTROSPRING.service;

import com.example.PHONGTROSPRING.entities.Transactions;
import com.example.PHONGTROSPRING.entities.User;
import com.example.PHONGTROSPRING.repository.TransactionsRepository;
import com.example.PHONGTROSPRING.repository.UserRepository;
import com.example.PHONGTROSPRING.request.RechargeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Service
public class RechargeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    public void recharge(RechargeRequest request, HttpSession session) {
        // Lấy thông tin người dùng từ session
        User user = (User) session.getAttribute("user");
        
        // Cập nhật số dư
        BigDecimal newBalance = user.getBalance().add(request.getAmount());
        user.setBalance(newBalance);
        userRepository.save(user);

        // Tạo giao dịch
        Transactions transaction = new Transactions();
        transaction.setUser(user);
        transaction.setAmount(request.getAmount());
        transaction.setTransactionDate();
        transaction.setStatus("Đang xử lý");
        transactionsRepository.save(transaction);    
        
    }
    
    public List<Transactions> getRechargeHistory(HttpSession session) {
    	User user = (User)session.getAttribute("user");
    	return transactionsRepository.findByUser(user);
    }
    
}
