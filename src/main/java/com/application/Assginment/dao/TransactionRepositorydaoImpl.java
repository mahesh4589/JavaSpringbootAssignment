package com.application.Assginment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.application.Assginment.JPA.TransactionRepositoryJpa;
import com.application.Assginment.dto.TransactionDto;
import com.application.Assginment.dto.responce.TransactionResDto;
import com.application.Assginment.model.Transaction;
import com.application.Assginment.model.User;

@Repository(value = "TransactionRepositorydao")
public class TransactionRepositorydaoImpl implements TransactionRepositorydao {

	@Autowired
	TransactionRepositoryJpa transactionRepositoryJpa;

	@Override
	public boolean createTransaction(Transaction transaction) {
		try {
			transactionRepositoryJpa.save(transaction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Transaction> getTransactionAllRecords() {
		List<Transaction> transactionRecord = null;
		try {
			transactionRecord = transactionRepositoryJpa.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionRecord;
	}

	public List<Transaction> getUserTransactionsByUser(User customer) {
		return transactionRepositoryJpa.findByCustomer(customer);
	}

	@Override
	public Transaction getTransactionsByUser(Long userId) {
		Optional<Transaction> getRecord = null;
		try {
			getRecord = transactionRepositoryJpa.findById(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getRecord.get();
	}

	@Override
	public boolean updateTransaction(Transaction userTransactionRecord) {
		try
		{
			transactionRepositoryJpa.save(userTransactionRecord);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deleteTransactionRecord(Long id) {
		try {
			transactionRepositoryJpa.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
