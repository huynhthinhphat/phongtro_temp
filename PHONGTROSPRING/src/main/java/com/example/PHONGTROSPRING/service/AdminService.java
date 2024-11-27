package com.example.PHONGTROSPRING.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PHONGTROSPRING.entities.Transactions;
import com.example.PHONGTROSPRING.repository.TransactionsRepository;
import com.example.PHONGTROSPRING.request.TransactionsRequest;

@Service
public class AdminService {

	@Autowired
	private TransactionsRepository transactionRepository;

	public List<Transactions> viewTransactions() {
		return transactionRepository.findAll();
	}
	
	public Transactions updateTransactions(Integer transactionId, String newStatus) {
		
		Transactions transaction = transactionRepository.findById(transactionId).orElse(null);
		
		transaction.setStatus(newStatus);
		return transactionRepository.save(transaction);
	}

	public List<Transactions> searchTransactions(TransactionsRequest transactionsRequest) {
	    String status = transactionsRequest.getStatus();	    
	    return transactionRepository.seachTransactions(status);
	}
}
