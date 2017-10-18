package com.capgemini.uas.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.uas.dto.ApplicationBean;
import com.capgemini.uas.dto.ProgramScheduledBean;
import com.capgemini.uas.exception.UniversityException;
import com.capgemini.uas.service.IApplicantService;

@Controller
public class ApplicantController {
	
		@Resource
		IApplicantService service;
		
		
		@RequestMapping("/applicantSheduledProgramlist.do")
		public ModelAndView applicantSheduledProgramlist(){
			ModelAndView mAndV = new ModelAndView();
			try {
				List<ProgramScheduledBean> psb = service.showProgramScheduled();
				mAndV.addObject("scheduledProgramList",psb);
			} catch (UniversityException e) {
				mAndV.addObject("error",e.getMessage());
				mAndV.setViewName("Error");
				return mAndV;
			}
//			mAndV.setViewName("Welcome");
			mAndV.setViewName("test3");
			return mAndV;
			
		}
		
		@RequestMapping("/applicantSheduledProgramlistbyLocation.do")
		public ModelAndView applicantSheduledProgramlistbyLocation(@RequestParam("location") String location){
			ModelAndView mAndV = new ModelAndView();
			try {
				List<ProgramScheduledBean> psb = service.applicantSheduledProgramlistbyLocation(location);
				mAndV.addObject("scheduledProgramList",psb);
			} catch (UniversityException e) {
				mAndV.addObject("error",e.getMessage());
				mAndV.setViewName("Error");
				return mAndV;
			}
//			mAndV.setViewName("Welcome");
			mAndV.setViewName("test3");
			return mAndV;
			
		}
		@RequestMapping("/getApplicantRegisterationPage.do")
		public ModelAndView getRegisterationPage(@RequestParam("schId") String scheduledProgramId){
			ModelAndView mAndV = new ModelAndView();
			mAndV.setViewName("test3");
			ApplicationBean applicant = new ApplicationBean();  //command object
			mAndV.addObject("applicant", applicant);
			mAndV.addObject("applyFlag","Applying");
			mAndV.addObject("appId",0);
			mAndV.addObject("scheduledId",scheduledProgramId);
			return mAndV;
		}


		
		@RequestMapping(value="/applicantRegister.do",method=RequestMethod.POST)
			public ModelAndView register(@ModelAttribute("applicant") @Valid ApplicationBean applicant,BindingResult result){
				ModelAndView mAndV = new ModelAndView();
				int applicationId = 0;
				if(result.hasErrors())
					{
							mAndV.setViewName("test3");
					}
					else
						{
							try {
								applicationId = service.addDetail(applicant);
							} catch (UniversityException e) {
								mAndV.addObject("error",e.getMessage());
								mAndV.setViewName("Error");
								return mAndV;
							}
							mAndV.addObject("applyFlag","Applied");
							mAndV.addObject("appId", applicationId);
							mAndV.addObject("Applicant",applicant);
							mAndV.setViewName("test3");
						}
				return mAndV;
			}
		
		@RequestMapping("/applicantShowStatusPage.do")
		public ModelAndView MACApplicantsListPage(){
			ModelAndView mAndV = new ModelAndView();
			mAndV.addObject("applicant",null);
			mAndV.addObject("statusFlag","Check Status");
			mAndV.setViewName("test3");
			return mAndV;
		}
		
		@RequestMapping("/applicantShowStatus.do")
		public ModelAndView applicantShowStatus(@RequestParam("applicationId") int applicationId){
			ModelAndView mAndV = new ModelAndView();
			ApplicationBean appBean = null;
			try {
				appBean = service.showStatus(applicationId);
			} catch (UniversityException e) {
				mAndV.addObject("error",e.getMessage());
				mAndV.setViewName("Error");
				return mAndV;
			}
			mAndV.addObject("statusFlag","Checked Status");
			mAndV.addObject("applicant",appBean);
			mAndV.setViewName("test3");
			return mAndV;
		}
		
}
