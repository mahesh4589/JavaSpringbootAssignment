package com.application.Assginment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.Assginment.Service.TransactionService;
import com.application.Assginment.dto.TransactionDto;
import com.application.Assginment.dto.responce.TransactionResDto;
import com.application.Assginment.model.Transaction;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@PostMapping("/transaction")
	ResponseEntity<TransactionResDto> createTransaction(@RequestBody TransactionDto transactionDto)			{
		TransactionResDto dto = new TransactionResDto();
		boolean flag = transactionService.createTransaction(transactionDto);
		if (flag) {
			dto.setMassages("Transaction add sucessfully...");
			dto.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<TransactionResDto>(dto, HttpStatus.CREATED);
		} else {
			dto.setMassages("Transaction add sucessfully...");
			dto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<TransactionResDto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getAll")
	ResponseEntity<List<Transaction>> getTransactionAllRecords() {
		List<Transaction> transactionRecord = transactionService.getTransactionAllRecords();
		if (transactionRecord != null) {
			return new ResponseEntity<>(transactionRecord, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getTransaction/{customerId}")
	public Transaction getTransactions(@PathVariable("customerId") Long userId) {
		Transaction recordInfo = transactionService.getTransactionsByUser(userId);
		return recordInfo;
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<TransactionResDto> updateTransaction(@PathVariable(value = "id") Long id,
			@Validated @RequestBody Transaction transactionDetails) {
		boolean flag = transactionService.updateTransaction(id, transactionDetails);
		TransactionResDto dto= new TransactionResDto();
		if (flag) {
			dto.setMassages("Transaction Record Updated");
			dto.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			dto.setMassages("Transaction Record not Updated");
			dto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TransactionResDto> deleteTransaction(@PathVariable(value = "id") Long id) {
		boolean flag = transactionService.deleteTransactionRecord(id);
		TransactionResDto dto = new TransactionResDto();
		if (flag) {
			dto.setMassages("Transaction Record Delete");
			dto.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<TransactionResDto>(dto, HttpStatus.OK);

		} else {
			dto.setMassages("Transaction Record not Delete");
			dto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<TransactionResDto>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
