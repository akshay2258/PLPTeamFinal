package com.capgemini.uas.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import com.capgemini.uas.dao.IMacDao;
import com.capgemini.uas.dao.MacDaoImpl;
import com.capgemini.uas.entities.ApplicationBean;
import com.capgemini.uas.entities.UsersBean;
import com.capgemini.uas.exception.UniversityException;

public class MacServiceImpl implements IMacService {
	static Logger myLogger = Logger.getLogger("myLogger");
	
	private static String patSchId = "[0-9]{1,5}";

	public static boolean validateScheduledId(String scheduledProgramId){
		myLogger.info("In Service validateScheduledId");
		return scheduledProgramId.matches(patSchId);
	}

	private IMacDao macDao;
	public MacServiceImpl() {
		myLogger.info("In Service constructor");
		macDao = new MacDaoImpl();
	}
	@Override
	public List<ApplicationBean> getApplicantsOnSchduledId(
			String scheduledProgramId) throws UniversityException {
		myLogger.info("In Service getApplicantsOnSchduledId");
		return macDao.getApplicantsOnSchduledId(scheduledProgramId);
	}

	@Override
	public List<ApplicationBean> getApplicantsAfterInterviewOnId(
			String scheduledProgramId) throws UniversityException {
		myLogger.info("In Service getApplicantsAfterInterviewOnId");
		return macDao.getApplicantsAfterInterviewOnId(scheduledProgramId);
	}

	@Override
	public String updateApplicantStatus(int applicationId, String status)
			throws UniversityException {
		myLogger.info("In Service updateApplicantStatus");
		return macDao.updateApplicantStatus(applicationId,status);
	}
	@Override
	public void updateApplicantDateOfInterview(int applicationId, LocalDate dateOfInterview)
			throws UniversityException {
		myLogger.info("In Service updateApplicantDateOfInterview");
			macDao.updateApplicantDateOfInterview(applicationId, dateOfInterview);
	}
	@Override
	public List<String> getscheduleId() throws UniversityException {
		myLogger.info("In Service getscheduleId");
		return macDao.getscheduleId();
	}
	@Override
	public List<Integer> getApplicantId() throws UniversityException {
		myLogger.info("In Service getApplicantId");
		return macDao.getApplicantId();
	}
}
