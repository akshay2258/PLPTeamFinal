package com.capgemini.uas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capgemini.uas.dto.ApplicationBean;
import com.capgemini.uas.dto.ProgramOfferedBean;
import com.capgemini.uas.dto.ProgramScheduledBean;
import com.capgemini.uas.exception.UniversityException;
import com.capgemini.uas.util.ConnectionUtil;

public class AdminDaoImpl implements IAdminDao {
	private Connection connect;
	
	@Override
	public boolean addProgramOffered(ProgramOfferedBean pOffered)
			throws UniversityException {
		
		int recsAffected=0;		
		ConnectionUtil util = new ConnectionUtil();
		connect = util.getConnection();
		PreparedStatement stmt = null;
		try{
			stmt = connect.prepareStatement(IQueryMapper.ADD_PROGRAM);
			stmt.setString(1,pOffered.getProgramName());
			stmt.setString(2,pOffered.getDescription());
			 //to convert date of birth local date to sql date
			stmt.setString(3,pOffered.getApplicantEligiblity());
			stmt.setInt(4,pOffered.getDuration());
			stmt.setString(5,pOffered.getDegreeCertificate());
			
			recsAffected= stmt.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
				throw new UniversityException("Problem in writing data in programOffered",e);
			}finally {
					try {
						if (connect != null) {
							stmt.close();
							connect.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new UniversityException(
						"Could not close the connection in programOffered");
					}
			}
		if(recsAffected==1)
		{
			return true;
	}
		else
		return false;
	}

	
	@Override
	public boolean deleteProgramOffered(String programName)
			throws UniversityException {
		
		int recsAffected=0;
		ConnectionUtil util = new ConnectionUtil();
		connect = util.getConnection();
		PreparedStatement stmt = null;
		
		try{
			stmt = connect.prepareStatement(IQueryMapper.DELETE_PROGRAM_OFFERED);
			stmt.setString(1,programName);
			System.out.println("In Dao3");
			recsAffected=stmt.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
				throw new UniversityException("Problem in deleting  data in programOffered",e);
			}finally {
					try {
						if (connect != null) {
							stmt.close();
							connect.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new UniversityException(
						"Could not close the connection in programOffered");
					}
			}
		if(recsAffected==1)
			return true;
		else
		return false;
	}

	@Override
	public int addProgramScheduled(ProgramScheduledBean pScheduled)
			throws UniversityException {
		//int recsAffected=0;
		ConnectionUtil util = new ConnectionUtil();
		connect = util.getConnection();
		PreparedStatement stmt = null;
		try{
			stmt = connect.prepareStatement(IQueryMapper.INSERT_PROGRAM_SCHEDULED);
			stmt.setString(1,pScheduled.getScheduledProgramId());
			stmt.setString(2,pScheduled.getProgramName());
			stmt.setString(3,pScheduled.getLocation());
			stmt.setDate(4,new java.sql.Date(pScheduled.getStartDate().getTime()));
			stmt.setDate(5,new java.sql.Date(pScheduled.getEndDate().getTime()));
			stmt.setInt(6,pScheduled.getSessionPerWeek());			
			stmt.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
				throw new UniversityException("Problem in writing data in addProgramScheduled",e);
			}finally {
					try {
						if (connect != null) {
							stmt.close();
							connect.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new UniversityException(
						"Could not close the connection in addProgramScheduled");
					}
			}
		return 1;
	}

	@Override
	public boolean deleteProgramScheduled(String programId)
			throws UniversityException {
		int recsAffected=0;
		System.out.println("In Dao");
		ConnectionUtil util = new ConnectionUtil();
		connect = util.getConnection();
		PreparedStatement stmt = null;
		System.out.println("In Dao2");
		try{
			stmt = connect.prepareStatement(IQueryMapper.DELETE_PROGRAM_SCHEDULED);
			stmt.setString(1,programId);
			System.out.println("In Dao3");
		recsAffected=stmt.executeUpdate();
			System.out.println("In Dao4");
			}catch(SQLException e){
				e.printStackTrace();
				throw new UniversityException("Problem in deleting  data in programOffered",e);
			}finally {
					try {
						if (connect != null) {
							stmt.close();
							connect.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new UniversityException(
						"Could not close the connection in programOffered");
					}
			}
		if(recsAffected==1)
		{
			return true;
	}
		else
		return false;	
		
	}
	/*private int getProgramId() throws UniversityException 
	{
		ConnectionUtil util = new ConnectionUtil();
		connect = util.getConnection();
		int programId = 0;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try
		{
			pstmt= connect.prepareStatement(IQueryMapper.GEN_PROGID);
			res = pstmt.executeQuery();
			if(res.next())
				{
					programId = res.getInt(1);
				}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new UniversityException("Problem in generating Program Id");
		}finally {
			try {
				if (connect != null) {
					pstmt.close();
					res.close();
					connect.close();
				}
				} catch (Exception e) {
					e.printStackTrace();
					throw new UniversityException(
					"Could not close the connection in getProgramId()");
				}
			}
return programId;
}*/


	@Override
	public List<ProgramScheduledBean> getAllDetails()
			throws UniversityException {
		ConnectionUtil util = new ConnectionUtil();
		connect = util.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		List<ProgramScheduledBean> progDetails = new ArrayList<ProgramScheduledBean>();
		try{
			stmt = connect.createStatement();
			rs = stmt.executeQuery(IQueryMapper.LIST_PROGRAM);
			while(rs.next()){
				String scheduledProgramId = rs.getString(1);
				String programName = rs.getString(2);
				String location = rs.getString(3);
				Date startDate = rs.getDate(4);
				Date endDate = rs.getDate(5);
				int sessionPerWeek = rs.getInt(6);
				ProgramScheduledBean pb= new ProgramScheduledBean(scheduledProgramId, programName, location, startDate, endDate, sessionPerWeek);
				progDetails.add(pb);
			}
			}catch(SQLException e){
				e.printStackTrace();
				throw new UniversityException("Problem in writing data getAllDetails",e);
			} finally {
					try {
						if (connect != null) {
							stmt.close();
							rs.close();
							connect.close();
						}
						} catch (Exception e) {
							e.printStackTrace();
							throw new UniversityException(
							"Could not close the connection in getAllDetails()");
						}
					}
		return progDetails;
		
	}


	@Override
	public List<String> getAllScheduleId() throws UniversityException {
		
		ConnectionUtil util = new ConnectionUtil();
		connect = util.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		List<String> schDetails = new ArrayList<String>();
		
		try{
			stmt = connect.createStatement();
			rs = stmt.executeQuery(IQueryMapper.GET_SCHEDULED_IDS);
			while(rs.next()){
				String schID = rs.getString(1);				
				schDetails.add(schID);
			}
			}catch(SQLException e){
				e.printStackTrace();
				throw new UniversityException("Problem in writing data getAllScheduleId",e);
			} finally {
					try {
						if (connect != null) {
							stmt.close();
							rs.close();
							connect.close();
						}
						} catch (Exception e) {
							e.printStackTrace();
							throw new UniversityException("Could not close the connection in getAllScheduleId()");
						}
					}
		return schDetails;
	}
	@Override
	public List<String> getAllProgramName() throws UniversityException {
		// TODO Auto-generated method stub
		ConnectionUtil util = new ConnectionUtil();
		connect = util.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		List<String> schDetails = new ArrayList<String>();
		try{
			stmt = connect.createStatement();
			rs = stmt.executeQuery(IQueryMapper.LIST_PROGRAMNAMES);
			while(rs.next()){	
				String schID = rs.getString(1);	
				schDetails.add(schID);
			}
			}catch(SQLException e){
				e.printStackTrace();
				throw new UniversityException("Problem in writing data showProgramScheduledID",e);
			} finally {
					try {
						if (connect != null) {
							stmt.close();
							rs.close();
							connect.close();
						}
						} catch (Exception e) {
							e.printStackTrace();
							throw new UniversityException(
							"Could not close the connection in showProgramScheduledID()");
						}
					}
		return schDetails;
}


	@Override
	public List<String> getAllScheduleNames() throws UniversityException {
		// TODO Auto-generated method stub
		ConnectionUtil util = new ConnectionUtil();
		connect = util.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		List<String> schDetails = new ArrayList<String>();
		try{
			stmt = connect.createStatement();
			rs = stmt.executeQuery(IQueryMapper.LIST_PROGRAMNAME);
			while(rs.next()){
				
				String schID = rs.getString(1);
				
				schDetails.add(schID);
			}
			}catch(SQLException e){
				e.printStackTrace();
				throw new UniversityException("Problem in writing data showProgramScheduledID",e);
			} finally {
					try {
						if (connect != null) {
							stmt.close();
							rs.close();
							connect.close();
						}
						} catch (Exception e) {
							e.printStackTrace();
							throw new UniversityException(
							"Could not close the connection in showProgramScheduledID()");
						}
					}
		return schDetails;
	}


	@Override
	public List<ApplicationBean> getApplicantsByScheduledProgramId(String pScheduledId) throws UniversityException {
		ConnectionUtil util = new ConnectionUtil();
		connect = util.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		List<ApplicationBean> applicantDetails = new ArrayList<ApplicationBean>();
		try{
			stmt = connect.prepareStatement(IQueryMapper.LIST_APPLICANTS);
			stmt.setString(1,pScheduledId);
			//stmt.setString(2,status);
			rs = stmt.executeQuery();
			while(rs.next()){
				int applicationId = rs.getInt(1);
				String fullName = rs.getString(2);
				LocalDate dateOfBirth = rs.getDate(3).toLocalDate();
				String highestQualification = rs.getString(4);
				int marksObtained = rs.getInt(5);
				String goals = rs.getString(6);
				String emailId = rs.getString(7);
				String status = rs.getString(9);
				LocalDate dateOfInterview = rs.getDate(10).toLocalDate();
				ApplicationBean aB = new ApplicationBean(applicationId, fullName, dateOfBirth, highestQualification, marksObtained, goals, emailId, pScheduledId, status, dateOfInterview);
				applicantDetails.add(aB);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new UniversityException("Problem in writing data in getApplicantsByStatusByScheduledProgramId",e);
		} finally {
			try {
				if (connect != null) {
					stmt.close();
					rs.close();
					connect.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new UniversityException(
						"Could not close the connection in getApplicantsByStatusByScheduledProgramId",e);
			}
		}
		return applicantDetails;
	}


	@Override
	public List<ApplicationBean> getApplicantsByStatusByScheduledProgramId(String status, String pScheduledId)
			throws UniversityException {
		ConnectionUtil util = new ConnectionUtil();
		connect = util.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		List<ApplicationBean> applicantDetails = new ArrayList<ApplicationBean>();
		try{
			stmt = connect.prepareStatement(IQueryMapper.LIST_APPLICANTS_BYSTATUS);
			stmt.setString(1,pScheduledId);
			stmt.setString(2,status);
			rs = stmt.executeQuery();
			while(rs.next()){
				int applicationId = rs.getInt(1);
				String fullName = rs.getString(2);
				LocalDate dateOfBirth = rs.getDate(3).toLocalDate();
				String highestQualification = rs.getString(4);
				int marksObtained = rs.getInt(5);
				String goals = rs.getString(6);
				String emailId = rs.getString(7);
				//String status = rs.getString(9);
				LocalDate dateOfInterview = rs.getDate(10).toLocalDate();
				ApplicationBean aB = new ApplicationBean(applicationId, fullName, dateOfBirth, highestQualification, marksObtained, goals, emailId, pScheduledId, status, dateOfInterview);
				applicantDetails.add(aB);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new UniversityException("Problem in writing data in getApplicantsByStatusByScheduledProgramId",e);
		} finally {
			try {
				if (connect != null) {
					stmt.close();
					rs.close();
					connect.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new UniversityException(
						"Could not close the connection in getApplicantsByStatusByScheduledProgramId",e);
			}
		}
		return applicantDetails;
	}


	@Override
	public boolean generateParticipants(List<ApplicationBean> confApplicants) throws UniversityException {
		System.out.println(confApplicants);
		ConnectionUtil util = new ConnectionUtil();
		connect = util.getConnection();
		PreparedStatement stmt = null;
		int recsAffected=0;
		try{
			for (Iterator iterator = confApplicants.iterator(); iterator
					.hasNext();) {
				stmt = connect.prepareStatement(IQueryMapper.INSERT_PARTICIPANT);
				ApplicationBean applicationBean = (ApplicationBean) iterator
						.next();
				stmt.setInt(2,applicationBean.getApplicationId());
				stmt.setString(1,applicationBean.getEmailId());
				stmt.setString(3,applicationBean.getScheduledProgramId());			
				recsAffected=stmt.executeUpdate();
			}
			}catch(SQLException e){
				e.printStackTrace();
				throw new UniversityException("Problem in writing data in generateParticipants",e);
			}finally {
					try {
						if (connect != null) {
							stmt.close();
							connect.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new UniversityException(
						"Could not close the connection in generateParticipants");
					}
			}
		if(recsAffected==1)
		{
			return true;
	}
		else
		return false;	
	}


	@Override
	public List<ApplicationBean> getAllConfirmedApplicants()
			throws UniversityException {
		ConnectionUtil util = new ConnectionUtil();
		connect = util.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		List<ApplicationBean> applicantDetails = new ArrayList<ApplicationBean>();
		try{
			stmt = connect.prepareStatement(IQueryMapper.LIST_ALL_APPLICANTS_CONFIRMED);
			rs = stmt.executeQuery();
			while(rs.next()){
				int applicationId = rs.getInt(1);
				String fullName = rs.getString(2);
				LocalDate dateOfBirth = rs.getDate(3).toLocalDate();
				String highestQualification = rs.getString(4);
				int marksObtained = rs.getInt(5);
				String goals = rs.getString(6);
				String emailId = rs.getString(7);
				String pScheduledId = rs.getString(8);
				String status = rs.getString(9);
				LocalDate dateOfInterview = rs.getDate(10).toLocalDate();
				ApplicationBean aB = new ApplicationBean(applicationId, fullName, dateOfBirth, highestQualification, marksObtained, goals, emailId, pScheduledId, status, dateOfInterview);
				applicantDetails.add(aB);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new UniversityException("Problem in writing data in getApplicantsByStatusByScheduledProgramId",e);
		} finally {
			try {
				if (connect != null) {
					stmt.close();
					rs.close();
					connect.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new UniversityException(
						"Could not close the connection in getApplicantsByStatusByScheduledProgramId",e);
			}
		}
		return applicantDetails;
		
	}
}