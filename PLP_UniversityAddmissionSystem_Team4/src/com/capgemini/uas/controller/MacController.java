package com.capgemini.uas.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.uas.dto.ApplicationBean;
import com.capgemini.uas.exception.UniversityException;
import com.capgemini.uas.service.IMacService;

@Controller
public class MacController {
	
	@Resource
	IMacService service;
	
	@RequestMapping("/MACHomePage.do")
	public ModelAndView MACHomePage(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("MACHomePage");
		return mAndV;
	}
	
	@RequestMapping("/MACApplicantsListPage.do")
	public ModelAndView MACApplicantsListPage(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("appList",null);
		mAndV.addObject("flag","first");
		mAndV.setViewName("MACHomePage");
		return mAndV;
	}
	
	@RequestMapping("/MACApplicantsList.do")
	public ModelAndView MACApplicantsList(@RequestParam ("scheduledProId") String scheduledProgramId){
		ModelAndView mAndV = new ModelAndView();
		List<ApplicationBean> applicantsList = null;
		try {
			applicantsList = service.getApplicantsOnSchduledId(scheduledProgramId);
			if(applicantsList.isEmpty()) {
				mAndV.addObject("appListError","Sorry! No Data Found for this Program Id");
				mAndV.addObject("flag","second");
				mAndV.setViewName("MACHomePage");
				return mAndV;
			}
		} catch (UniversityException e) {
			mAndV.addObject("error",e.getMessage());
			mAndV.setViewName("Error");
			return mAndV;
		}
		mAndV.addObject("appList",applicantsList);
		mAndV.addObject("flag","second");
		mAndV.setViewName("MACHomePage");
		return mAndV;
	}
	
	@RequestMapping("/MACApplicantListAfterInterviewPage.do")
	public ModelAndView MACApplicantListAfterInterviewPage(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("appList",null);
		mAndV.addObject("flag","first");
		mAndV.setViewName("MACApplicantListAfterInterview");
		return mAndV;
	}
	
	@RequestMapping("/MACApplicantListAfterInterview.do")
	public ModelAndView MACApplicantListAfterInterview(@RequestParam ("scheduledProId") String scheduledProgramId){
		ModelAndView mAndV = new ModelAndView();
		List<ApplicationBean> applicantsList = null;
		try {
			applicantsList = service.getApplicantsAfterInterviewOnId(scheduledProgramId);
		} catch (UniversityException e) {
			mAndV.addObject("error",e.getMessage());
			mAndV.setViewName("Error");
			return mAndV;
		}
		mAndV.addObject("appList",applicantsList);
		mAndV.addObject("flag","second");
		mAndV.setViewName("MACApplicantListAfterInterview");
		return mAndV;
	}
	
	@RequestMapping("/MACupdateStatusPage.do")
	public ModelAndView MACupdateStatusPage(@RequestParam("appId") int applicationId){
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("appId",applicationId);
		mAndV.addObject("status","Yet to Update");
		mAndV.setViewName("MACUpdateStatus");
		return mAndV;
	}
	
	@RequestMapping("/MACupdateStatusAfterInterviewPage.do")
	public ModelAndView MACupdateStatusAfterInterviewPage(@RequestParam("appId") int applicationId){
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("appId",applicationId);
		mAndV.addObject("status","Yet to Update");
		mAndV.setViewName("MACUpdateStatusAfterInterview");
		return mAndV;
	}
	
	@RequestMapping("/MACupdateStatus.do")
	public ModelAndView MACupdateStatus(@RequestParam("status") String status,@RequestParam("appId") int applicationId){
		ModelAndView mAndV = new ModelAndView();
		try {
			service.updateApplicantStatus(applicationId, status);
		} catch (UniversityException e) {
			mAndV.addObject("error",e.getMessage());
			mAndV.setViewName("Error");
			return mAndV;
		}
		mAndV.addObject("appId",applicationId);
		mAndV.addObject("status",status);
		mAndV.addObject("sysdate",LocalDate.now());
		mAndV.addObject("successMsg","Successfully Updated");
		mAndV.setViewName("MACUpdateStatus");
		return mAndV;
	}
	
	@RequestMapping("/MACupdateStatusAfterInterview.do")
	public ModelAndView MACupdateStatusAfterInterview(@RequestParam("status") String status,@RequestParam("appId") int applicationId){
		ModelAndView mAndV = new ModelAndView();
		try {
			service.updateApplicantStatus(applicationId, status);
		} catch (UniversityException e) {
			mAndV.addObject("error",e.getMessage());
			mAndV.setViewName("Error");
			return mAndV;
		}
		mAndV.addObject("appId",applicationId);
		mAndV.addObject("successMsg","Successfully Updated");
		mAndV.setViewName("MACUpdateStatusAfterInterview");
		return mAndV;
	}
	
	@RequestMapping("/MACupdateDateOfInterview.do")
	public ModelAndView MACupdateDateOfInterview(@RequestParam("doi") String doi,@RequestParam("appId") int applicationId){
		ModelAndView mAndV = new ModelAndView();
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate tape = LocalDate.parse(doi,format);
			Date dateOfInterview = java.sql.Date.valueOf(tape);
			service.updateApplicantDateOfInterview(applicationId, dateOfInterview);
		} catch (UniversityException e) {
			mAndV.addObject("error",e.getMessage());
			mAndV.setViewName("Error");
			return mAndV;
		}
		mAndV.addObject("status","updated");
		mAndV.addObject("successMsg","Successfully Updated");
		mAndV.setViewName("MACUpdateStatus");
		return mAndV;
	}
}
