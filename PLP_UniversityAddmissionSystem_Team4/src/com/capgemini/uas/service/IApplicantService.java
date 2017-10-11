package com.capgemini.uas.service;

import java.util.List;

import com.capgemini.uas.entities.ApplicationBean;
import com.capgemini.uas.entities.ProgramScheduledBean;
import com.capgemini.uas.exception.UniversityException;

public interface IApplicantService {
	public List<ProgramScheduledBean> showProgramScheduled() throws UniversityException;
	public int addDetail(ApplicationBean ab) throws UniversityException;
	public ApplicationBean showStatus(int applicationId) throws UniversityException;
}
