package com.dashboard.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.PortfolioBpKey;
import com.dashboard.model.PortfolioBpMappingEntity;
import com.dashboard.model.PortfolioEntity;
import com.dashboard.repository.PortfolioBpMappingRepository;
import com.dashboard.repository.PortfolioRepository;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {

	@Autowired
	private PortfolioRepository prepo;
	
	@Autowired
	private PortfolioBpMappingRepository pbrepo;
	
	
	@PostMapping("/portfolio")
	public ResponseEntity<String> createPortfolio(@RequestBody PortfolioEntity entity){
		prepo.save(entity);
		return new ResponseEntity<>("Details added to db", HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getportfolios")
	public ResponseEntity<List<PortfolioEntity>> getPortfolio(){
		
		List<PortfolioEntity> list = prepo.findAll()
			.stream()
			.collect(Collectors.toList());
		
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
}
