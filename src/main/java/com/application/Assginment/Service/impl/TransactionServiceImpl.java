package com.application.Assginment.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.application.Assginment.Service.TransactionService;
import com.application.Assginment.dao.TransactionRepositorydao;
import com.application.Assginment.dao.UserRepositoryDao;
import com.application.Assginment.dto.TransactionDto;
import com.application.Assginment.dto.responce.TransactionResDto;
import com.application.Assginment.model.Transaction;
import com.application.Assginment.model.User;

@Service(value = "TransactionService")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepositorydao transactionRepositorydao;

	@Autowired
	UserRepositoryDao userRepositoryDao;

	@Override
	public boolean createTransaction(TransactionDto transactionDto) {
		Long id = transactionDto.getCustomer().getId();
		Optional<User> UserInfo = userRepositoryDao.findById(id);
		User userinfo = null;
		if (UserInfo.isPresent()) {
			userinfo = UserInfo.get();
		}

		Transaction transaction = new Transaction();
		transaction.setAmount(transactionDto.getAmount());
		transaction.setCustomer(userinfo);
		transaction.setDate(transactionDto.getDate());
		transaction.setId(transactionDto.getId());
		transaction.setSpentDetails(transactionDto.getSpentDetails());
		return transactionRepositorydao.createTransaction(transaction);
	}

	@Override
	public List<Transaction> getTransactionAllRecords() {
		List<Transaction> getRecordList = transactionRepositorydao.getTransactionAllRecords();

		return getRecordList;
	}

	@Override
	public List<Transaction> getUserTransactionsByUser(User customer) {
		List<Transaction> result = transactionRepositorydao.getUserTransactionsByUser(customer);
		return result;
	}

	@Override
	public Transaction getTransactionsByUser(Long userId) {

		return transactionRepositorydao.getTransactionsByUser(userId);
	}

	@Override
	public boolean updateTransaction(Long id, Transaction transactionDetails) {
		Transaction userTransactionRecord = transactionRepositorydao.getTransactionsByUser(id);
		userTransactionRecord.setAmount(transactionDetails.getAmount());
		userTransactionRecord.setCustomer(transactionDetails.getCustomer());
		userTransactionRecord.setDate(transactionDetails.getDate());
		userTransactionRecord.setSpentDetails(transactionDetails.getSpentDetails());
		boolean flag = transactionRepositorydao.updateTransaction(userTransactionRecord);
		return flag;
	}

	@Override
	public boolean deleteTransactionRecord(Long id) {
		 boolean flag = transactionRepositorydao.deleteTransactionRecord(id);
		return flag;
	}

}
