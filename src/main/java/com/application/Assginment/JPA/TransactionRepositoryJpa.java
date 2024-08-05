package com.application.Assginment.JPA;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.Assginment.model.Transaction;
import com.application.Assginment.model.User;


public interface TransactionRepositoryJpa extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCustomer(User customer);

	Optional<Transaction> findById(Long userId);

	void deleteById(Long id);

	
}
