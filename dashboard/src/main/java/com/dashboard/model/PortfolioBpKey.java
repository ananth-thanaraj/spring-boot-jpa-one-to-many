package com.dashboard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class PortfolioBpKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "portfolioid",nullable=false)
	private Integer portfolioId;
	
	@Column(name="bp_id",nullable=false)
	private Integer bpId;
	
	public PortfolioBpKey() {
		
	}
	
public PortfolioBpKey(Integer portfolioId,Integer bpId) {
		this.portfolioId=portfolioId;
		this.bpId=bpId;
	}

public Integer getPortfolioId() {
	return portfolioId;
}

public void setPortfolioId(Integer portfolioId) {
	this.portfolioId = portfolioId;
}

public Integer getBpId() {
	return bpId;
}

public void setBpId(Integer bpId) {
	this.bpId = bpId;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bpId == null) ? 0 : bpId.hashCode());
	result = prime * result + ((portfolioId == null) ? 0 : portfolioId.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	PortfolioBpKey other = (PortfolioBpKey) obj;
	if (bpId == null) {
		if (other.bpId != null)
			return false;
	} else if (!bpId.equals(other.bpId))
		return false;
	if (portfolioId == null) {
		if (other.portfolioId != null)
			return false;
	} else if (!portfolioId.equals(other.portfolioId))
		return false;
	return true;
}



}
