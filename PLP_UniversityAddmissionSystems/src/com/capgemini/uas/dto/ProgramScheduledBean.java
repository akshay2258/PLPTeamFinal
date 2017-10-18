package com.capgemini.uas.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="PROGRAM_SCHEDULED")
public class ProgramScheduledBean {
	
	@Id
	@Column(name="SCHEDULED_PROGRAM_ID")
	@Size(min=3,max=5,message="Min 3 & Max 5 character Alpha Numeric")
	private String scheduledProgramId;
	
	@Column(name="PROGRAM_NAME")
	@Size(min=5,max=10,message="Min 5 and Max 10 characters")
	private String programName;
	
	@Column(name="LOCATION")
	@NotEmpty(message="Should Not be Empty")
	@Size(min=3,max=15,message="Min 3 and Max 15 characters")
	private String location;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	@Column(name="START_DATE")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	@Column(name="END_DATE")
	private Date endDate;
	
	@Column(name="SESSIONS_PER_WEEK")
	@Min(1) @Max(50)
	private int sessionPerWeek;
	
	public ProgramScheduledBean() {
	}
	public ProgramScheduledBean(String scheduledProgramId, String programName,
			String location, Date startDate, Date endDate, int sessionPerWeek) {
		super();
		this.scheduledProgramId = scheduledProgramId;
		this.programName = programName;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.sessionPerWeek = sessionPerWeek;
	}
	public String getScheduledProgramId() {
		return scheduledProgramId;
	}
	public void setScheduledProgramId(String scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getSessionPerWeek() {
		return sessionPerWeek;
	}
	public void setSessionPerWeek(int sessionPerWeek) {
		this.sessionPerWeek = sessionPerWeek;
	}
	@Override
	public String toString() {
		return "ProgramScheduledBean [scheduledProgramId=" + scheduledProgramId
				+ ", programName=" + programName + ", location=" + location
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", sessionPerWeek=" + sessionPerWeek + "]";
	}
	
	
}
