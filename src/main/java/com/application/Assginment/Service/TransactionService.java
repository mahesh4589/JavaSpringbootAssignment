package com.application.Assginment.Service;

import java.util.List;

import com.application.Assginment.dto.TransactionDto;
import com.application.Assginment.dto.responce.TransactionResDto;
import com.application.Assginment.model.Transaction;
import com.application.Assginment.model.User;

public interface TransactionService {

	boolean createTransaction(TransactionDto transactionDto);

	List<Transaction> getTransactionAllRecords();


	List<Transaction> getUserTransactionsByUser(User customer);

	
	Transaction getTransactionsByUser(Long userId);

	boolean updateTransaction(Long id, Transaction transactionDetails);

	boolean deleteTransactionRecord(Long id);

	

}
