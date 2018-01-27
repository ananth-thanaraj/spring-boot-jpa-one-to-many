package com.dashboard.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="portfolio_bp_mapping")
public class PortfolioBpMappingEntity {

	/*	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "portfolio_id",nullable=false)
		private Integer portfolioId;
		
		@Column(name="bp_id")
		private Integer bpId;
		
		@Column(name = "bp_name")
		private String bpName;
		*/
		
		@EmbeddedId
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private PortfolioBpKey portfolioBpId;
		
		@Column(name = "bp_name")
		private String bpName;
		
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
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="portfolioEntity_Id", referencedColumnName="portfolio_id", insertable=true, updatable=true, nullable=false)
		@NotNull
		@JsonBackReference
		private PortfolioEntity portfolioEntity;
		
		
		@OneToMany(mappedBy="portfolioBpEntity", cascade=CascadeType.ALL)
		@JsonManagedReference
	    private Set<MilestoneJobMappingEntity> milestoneJobMapping = new HashSet<>();
		
		public PortfolioBpMappingEntity() {
			
		}
		
		public PortfolioBpMappingEntity(PortfolioBpKey portfolioBpId,String bpName,String createdUserID, String updatedUserID) {
			this.bpName=bpName;
			this.createdUserID=createdUserID;
			this.updatedUserID=updatedUserID;
			this.portfolioBpId=portfolioBpId;
		}

		public PortfolioBpKey getPortfolioBpId() {
			return portfolioBpId;
		}

		public void setPortfolioBpId(PortfolioBpKey portfolioBpId) {
			this.portfolioBpId = portfolioBpId;
		}

		public String getBpName() {
			return bpName;
		}

		public void setBpName(String bpName) {
			this.bpName = bpName;
		}

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

		/*public PortfolioEntity getPortfolioEntity() {
			return portfolioEntity;
		}*/

		public void setPortfolioEntity(PortfolioEntity portfolioEntity) {
			this.portfolioEntity = portfolioEntity;
		}

		public Set<MilestoneJobMappingEntity> getMilestoneJobMapping() {
			return milestoneJobMapping;
		}

		public void setMilestoneJobMapping(Set<MilestoneJobMappingEntity> milestoneJobMapping) {
			this.milestoneJobMapping = milestoneJobMapping;
		}		
	
}
