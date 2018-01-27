package com.dashboard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "milestone_job_mapping")
public class MilestoneJobMappingEntity {

	@EmbeddedId
	@Id
	private MilestoneJobKey milestoneJobId;

	@Column(name = "job_name")
	private String jobName;
	
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
	
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
	@JoinColumn(name="bp_id", insertable=true, updatable=true),
	@JoinColumn(name="portfolioid", insertable=true, updatable=true)})
	private PortfolioBpMappingEntity portfolioBpEntity;
	
	public MilestoneJobMappingEntity() {
		
	}
	
public MilestoneJobMappingEntity(MilestoneJobKey milestoneJobId,String jobName,String createdUserID,String updatedUserID) {
		this.milestoneJobId=milestoneJobId;
		this.jobName=jobName;
		this.createdUserID=createdUserID;
		this.updatedUserID=updatedUserID;
	}

	public MilestoneJobKey getMilestoneJobId() {
		return milestoneJobId;
	}

	public void setMilestoneJobId(MilestoneJobKey milestoneJobId) {
		this.milestoneJobId = milestoneJobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
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

	/*public PortfolioBpMappingEntity getPortfolioBpEntity() {
		return portfolioBpEntity;
	}*/

	public void setPortfolioBpEntity(PortfolioBpMappingEntity portfolioBpEntity) {
		this.portfolioBpEntity = portfolioBpEntity;
	}
	
	
}
