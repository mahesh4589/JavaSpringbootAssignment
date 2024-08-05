package com.application.Assginment.dao;

import java.util.List;

import com.application.Assginment.dto.TransactionDto;
import com.application.Assginment.dto.responce.TransactionResDto;
import com.application.Assginment.model.Transaction;
import com.application.Assginment.model.User;

public interface TransactionRepositorydao {

	boolean createTransaction(Transaction transaction);

	List<Transaction> getTransactionAllRecords();

	List<Transaction> getUserTransactionsByUser(User customer);

	

	Transaction getTransactionsByUser(Long userId);

	boolean updateTransaction(Transaction userTransactionRecord);

	boolean deleteTransactionRecord(Long id);

}
