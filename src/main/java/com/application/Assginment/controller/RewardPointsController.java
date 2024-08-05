package com.application.Assginment.controller;

import java.time.Month;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.Assginment.Service.RewardPointService;
import com.application.Assginment.model.RewardPoints;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class RewardPointsController {

	@Autowired
	RewardPointService rewardPointService;

	@GetMapping("/reward/{customerId}")
	public ResponseEntity<Map<Long, Map<Month, Integer>>> getRewardPoints(@PathVariable Long customerId) {
		Map<Long, Map<Month, Integer>> rewardPoints = rewardPointService.calculateRewards(customerId);
		if (rewardPoints != null) {
			return new ResponseEntity<Map<Long, Map<Month, Integer>>>(rewardPoints,HttpStatus.OK);
		} else {
			return new ResponseEntity<Map<Long, Map<Month, Integer>>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/reward/getAll")
	public ResponseEntity<List<RewardPoints>> getAllGetRewardPoints() {
		List<RewardPoints> rewardPoints = rewardPointService.getAllRewardPoints();
		if (rewardPoints != null) {
			return new ResponseEntity<List<RewardPoints>>(HttpStatus.FOUND);
		} else {
			return new ResponseEntity<List<RewardPoints>>(HttpStatus.NOT_FOUND);

		}
	}
}