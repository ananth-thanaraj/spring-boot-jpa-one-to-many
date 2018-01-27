package com.dashboard.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name ="portfolio")
@XmlRootElement
public class PortfolioEntity {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "portfolio_id")
		private Integer portfolioId;
		
		@Column(name = "portfolio_name")
		private String portfolioName;
		
		
		@Column(name = "created_userID")
		private String createdUserID;
		
		
		@Column(name = "updated_userID")
		private String updatedUserID;
		
		@CreationTimestamp
		@Column(name = "created_time")
		@Temporal(TemporalType.TIMESTAMP)
		private Date createdTime;
		
		@UpdateTimestamp
		@Column(name = "updated_time")
		@Temporal(TemporalType.TIMESTAMP)
		private Date updatedTime;
		

		@JsonManagedReference
		@OneToMany(mappedBy="portfolioEntity", cascade=CascadeType.PERSIST)
	    private Set<PortfolioBpMappingEntity> portfolioBpMapping = new HashSet<>();
	 
		public PortfolioEntity() {
			
		}

		public PortfolioEntity(Integer portfolioId,String portfolioname,String createdUserID) {
			this.portfolioId=portfolioId;
			this.portfolioName=portfolioname;
			this.createdUserID=createdUserID;
		}
		
	/*	public PortfolioEntity(Integer portfolioId,String portfolio_name,String createdUserID,String updatedUserID,Date createdTime,Date updatedTime) {
			// TODO Auto-generated constructor stub
			this.portfolioId=portfolioId;
			this.portfolioName=portfolio_name;
			this.createdTime=createdTime;
			this.createdUserID=createdUserID;
			this.updatedTime=updatedTime;
			this.updatedUserID=updatedUserID;
			
		}*/



		public String getCreatedUserID() {
			return createdUserID;
		}

		public void setCreatedUserID(String createdUserID) {
			this.createdUserID = createdUserID;
		}

		public String getUpdatedUserID() {
			return updatedUserID;
		}

		public void setUpdatedUserID(String updatedUserID) {
			this.updatedUserID = updatedUserID;
		}

		public Date getCreatedTime() {
			return createdTime;
		}

		public void setCreatedTime(Date createdTime) {
			this.createdTime = createdTime;
		}

		public Date getUpdatedTime() {
			return updatedTime;
		}

		public void setUpdatedTime(Date updatedTime) {
			this.updatedTime = updatedTime;
		}


		public Integer getPortfolioId() {
			return portfolioId;
		}


		public void setPortfolioId(Integer portfolioId) {
			this.portfolioId = portfolioId;
		}


		public String getPortfolioName() {
			return portfolioName;
		}


		public void setPortfolioName(String portfolioName) {
			this.portfolioName = portfolioName;
		}

		public Set<PortfolioBpMappingEntity> getPortfolioBpMapping() {
			return portfolioBpMapping;
		}

		public void setPortfolioBpMapping(Set<PortfolioBpMappingEntity> portfolioBpMapping) {
			this.portfolioBpMapping = portfolioBpMapping;
		}

	
		
	
}
