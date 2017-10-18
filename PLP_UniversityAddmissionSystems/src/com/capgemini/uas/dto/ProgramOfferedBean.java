package com.capgemini.uas.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="PROGRAM_OFFERED")
public class ProgramOfferedBean {
	
	@Id
	@Column(name="PROGRAM_NAME")
	@Size(min=5,max=10,message="Min 5 and Max 10 characters")
	private String programName;
	
	@Column(name="DESCRIPTION")
	@Size(min=5,max=20,message="Min 5 and Max 20 characters")
	private String description;
	
	@Column(name="APPLICANT_ELIGIBILITY")
	@Size(min=2,max=20,message="Min 2 and Max 20 characters")
	private String applicantEligiblity;
	
	@Column(name="DURATION")
	//@Pattern(message="should be number", regexp = "[0-9]{1,2}")
	 @Min(1) @Max(50)
	//@Digits(message="should be integer", fraction = 0, integer = 2)
	private int duration;
	
	
	@Column(name="DEGREE_CERTIFICATE_OFFERED")
	@Size(min=2,max=10,message="Min 2 and Max 10 characters")
	private String degreeCertificate;
	
	public ProgramOfferedBean() {
	}
	
	public ProgramOfferedBean(String programName, String description,
			String applicantEligiblity, int duration, String degreeCertificate) {
		super();
		this.programName = programName;
		this.description = description;
		this.applicantEligiblity = applicantEligiblity;
		this.duration = duration;
		this.degreeCertificate = degreeCertificate;
	}

	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getApplicantEligiblity() {
		return applicantEligiblity;
	}
	public void setApplicantEligiblity(String applicantEligiblity) {
		this.applicantEligiblity = applicantEligiblity;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDegreeCertificate() {
		return degreeCertificate;
	}
	public void setDegreeCertificate(String degreeCertificate) {
		this.degreeCertificate = degreeCertificate;
	}
	@Override
	public String toString() {
		return "ProgramOffered [programName=" + programName + ", description="
				+ description + ", applicantEligiblity=" + applicantEligiblity
				+ ", duration=" + duration + ", degreeCertificate="
				+ degreeCertificate + "]";
	}
	
	
}
