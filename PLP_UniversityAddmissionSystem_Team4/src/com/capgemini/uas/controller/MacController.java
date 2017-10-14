package com.capgemini.uas.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
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
		mAndV.setViewName("MACApplicantListPage");
		return mAndV;
	}
	
	@RequestMapping("/MACApplicantsList.do")
	public ModelAndView MACApplicantsList(@RequestParam ("scheduledProId") String scheduledProgramId){
		ModelAndView mAndV = new ModelAndView();
		List<ApplicationBean> applicantsList = null;
		try {
			applicantsList = service.getApplicantsOnSchduledId(scheduledProgramId);
		} catch (UniversityException e) {
			mAndV.addObject("error",e.getMessage());
			mAndV.setViewName("Error");
			return mAndV;
		}
		mAndV.addObject("appList",applicantsList);
		mAndV.setViewName("MACApplicantListPage");
		return mAndV;
	}
	
	@RequestMapping("/MACApplicantListAfterInterviewPage.do")
	public ModelAndView MACApplicantListAfterInterviewPage(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("appList",null);
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
		mAndV.addObject("successMsg","Successfully Updated");
		mAndV.setViewName("MACUpdateStatus");
		return mAndV;
	}
	
	@RequestMapping("/MACupdateDateOfInterview.do")
	public ModelAndView MACupdateDateOfInterview(@RequestParam("doi") Date dateOfInterview,@RequestParam("appId") int applicationId){
		ModelAndView mAndV = new ModelAndView();
		try {
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
