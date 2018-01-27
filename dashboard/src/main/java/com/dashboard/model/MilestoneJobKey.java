package com.dashboard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MilestoneJobKey implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "milestone_id", nullable = false)
	private Integer milestoneId;

	@Column(name = "job_id", nullable = false)
	private Long jobID;
	
	public MilestoneJobKey() {
		
	}
	
	public MilestoneJobKey(Integer milestoneId,Long jobID) {
		this.milestoneId=milestoneId;
		this.jobID=jobID;
	}


	public Integer getMilestoneId() {
		return milestoneId;
	}

	public void setMilestoneId(Integer milestoneId) {
		this.milestoneId = milestoneId;
	}

	public Long getJobID() {
		return jobID;
	}

	public void setJobID(Long jobID) {
		this.jobID = jobID;
	}
}
