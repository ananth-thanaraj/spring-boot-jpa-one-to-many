package com.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dashboard.model.PortfolioEntity;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity, Integer>{

}
