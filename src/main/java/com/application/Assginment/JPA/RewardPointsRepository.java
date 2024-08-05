package com.application.Assginment.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.Assginment.model.RewardPoints;
import com.application.Assginment.model.User;

@Repository
public interface RewardPointsRepository extends JpaRepository<RewardPoints, Long> {
    List<RewardPoints> findByCustomerId(Long customerId);

	RewardPoints findByCustomer(User customer);

	
}
