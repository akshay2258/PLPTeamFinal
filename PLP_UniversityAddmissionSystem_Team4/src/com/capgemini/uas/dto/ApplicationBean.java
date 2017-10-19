package com.capgemini.uas.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="APPLICANTS")
public class ApplicationBean {
	
	@Id
	@Column(name="APPLICATION_ID")
	@SequenceGenerator(name="appSeq",sequenceName="application_id_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="appSeq")
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int applicationId;
	
	@Column(name="FULL_NAME")
	@Size(min=3,max=20,message="Min 3 and Max 20 characters")
	@NotEmpty(message="Please Fill out this field")
	private String fullName;
	
	@Column(name="DATE_OF_BIRTH")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	@Past(message="Should be behind current date")
	@NotNull(message="Please Fill out this field")
	private Date dateOfBirth;
	
	@Column(name="HIGHEST_QUALIFICATION")
	@Size(min=2,max=10,message="Min 2 and Max 10 characters")
	@NotEmpty(message="Please Fill out this field")
	private String highestQualification;
	
	@Column(name="MARKS_OBTAINED")
	@Range(max=100,min=1,message="must be in the range of 1 to 100")
	@NotNull(message="Please Fill out this field")
	private int marksObtained;
	
	@Column(name="GOALS")
	@Size(max=20,message="Max 20 characters")
	private String goals;
	
	@Column(name="EMAIL_ID")
	@NotEmpty(message="Please Fill out this field")
	@Email(message="Not a valid Email Id")
	private String emailId;
	
	@Column(name="SCHEDULED_PROGRAM_ID")
	private String scheduledProgramId;
	
	@Column(name="STATUS")
	private String status="applied";
	
	@Column(name="DATE_OF_INTERVIEW")
	@Temporal(TemporalType.DATE)
	private Date dateOfInterview;
	
	public ApplicationBean() {
	}
	
	
	
	public ApplicationBean(int applicationId, String fullName,
			Date dateOfBirth, String highestQualification,
			int marksObtained, String goals, String emailId,
			String scheduledProgramId, String status,Date dateOfInterview) {
		super();
		this.applicationId = applicationId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.marksObtained = marksObtained;
		this.goals = goals;
		this.emailId = emailId;
		this.scheduledProgramId = scheduledProgramId;
		this.status = status;
		this.dateOfInterview = dateOfInterview;
	}



	public ApplicationBean(String fullName, Date dateOfBirth,
			String highestQualification, int marksObtained, String goals,
			String emailId, String scheduledProgramId, String status,
			Date dateOfInterview) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.marksObtained = marksObtained;
		this.goals = goals;
		this.emailId = emailId;
		this.scheduledProgramId = scheduledProgramId;
		this.status = status;
		this.dateOfInterview = dateOfInterview;
	}

	public ApplicationBean( String fullName,Date dateOfBirth,int applicationId, String goals, String emailId) {
		super();
		this.applicationId = applicationId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.goals = goals;
		this.emailId = emailId;
	}



	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getHighestQualification() {
		return highestQualification;
	}
	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getScheduledProgramId() {
		return scheduledProgramId;
	}
	public void setScheduledProgramId(String scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateOfInterview() {
		return dateOfInterview;
	}
	public void setDateOfInterview(Date dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}
	@Override
	public String toString() {
		return "ApplicationBean [applicationId=" + applicationId
				+ ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth
				+ ", highestQualification=" + highestQualification
				+ ", marksObtained=" + marksObtained + ", goals=" + goals
				+ ", emailId=" + emailId + ", scheduledProgramId="
				+ scheduledProgramId + ", status=" + status
				+ ", dateOfInterview=" + dateOfInterview + "]";
	}	
}
