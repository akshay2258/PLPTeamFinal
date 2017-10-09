package com.capgemini.uas.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.uas.dao.AdminDaoImpl;
import com.capgemini.uas.dao.IAdminDao;
import com.capgemini.uas.dto.ApplicationBean;
import com.capgemini.uas.dto.ProgramOfferedBean;
import com.capgemini.uas.dto.ProgramScheduledBean;
import com.capgemini.uas.exception.UniversityException;

public class AdminServiceImpl implements IAdminService {
	private IAdminDao dao;
	public AdminServiceImpl()
	{
		dao=new AdminDaoImpl();
	}
	@Override
	public boolean addProgramOffered(ProgramOfferedBean pOffered)
			throws UniversityException {
		return dao.addProgramOffered(pOffered);
	}

	@Override
	public boolean deleteProgramOffered(String programName)
			throws UniversityException {
		return dao.deleteProgramOffered(programName);
	}

	@Override
	public int addProgramScheduled(ProgramScheduledBean pScheduled)
			throws UniversityException {
		// TODO Auto-generated method stub
		return dao.addProgramScheduled(pScheduled);
	}

	@Override
	public boolean deleteProgramScheduled(String programId)
			throws UniversityException {
		return dao.deleteProgramScheduled(programId);
	}
	@Override
	public List<ProgramScheduledBean> getAllDetails()
			throws UniversityException {
		return dao.getAllDetails();
	}
	@Override
	public List<String> getAllScheduleId() throws UniversityException {
		return dao.getAllScheduleId();
	}
	@Override
	public List<String> getAllProgramName() throws UniversityException {
		return dao.getAllProgramName();
	}
	
	@Override
	public List<String> getAllScheduleNames() throws UniversityException {
		return dao.getAllScheduleNames();
	}
	
	@Override
	public List<ApplicationBean> getApplicantsByStatusByScheduledProgramId(String status, String pScheduledId)
			throws UniversityException {
		return dao.getApplicantsByStatusByScheduledProgramId(status, pScheduledId);
	}
	@Override
	public List<ApplicationBean> getApplicantsByScheduledProgramId(String pScheduledId) throws UniversityException {
		return dao.getApplicantsByScheduledProgramId(pScheduledId);
	}
	
	public boolean validateProgramDescription(String pDesc){	
		Pattern pt= Pattern.compile("[A-Za-z ]{3,15}");
		Matcher match=pt.matcher(pDesc);
		return  match.matches();
	}
	
	public boolean validateLocation(String location)
	{
		Pattern pt= Pattern.compile("[A-Za-z ]{3,15}");
		Matcher match=pt.matcher(location);
		return match.matches();
	}
	@Override
	public boolean generateParticipants(List<ApplicationBean> confApplicants)
			throws UniversityException {
		return dao.generateParticipants(confApplicants);
	}
	@Override
	public List<ApplicationBean> getAllConfirmedApplicants()
			throws UniversityException {
		// TODO Auto-generated method stub
		return dao.getAllConfirmedApplicants();
	}
}
