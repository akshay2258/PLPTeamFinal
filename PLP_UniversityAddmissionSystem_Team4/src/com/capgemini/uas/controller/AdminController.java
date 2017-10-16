package com.capgemini.uas.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.uas.dto.ProgramOfferedBean;
import com.capgemini.uas.dto.ProgramScheduledBean;
import com.capgemini.uas.exception.UniversityException;
import com.capgemini.uas.service.IAdminService;

@Controller
public class AdminController {
	
	@Resource
	IAdminService service;

	/*@RequestMapping("/getAdminHomePage.do")
	public ModelAndView getAdminHomePage(){
		System.out.println("in admin fun");
		ModelAndView mAndV = new ModelAndView();
		
		mAndV.setViewName("Admin_Home");
		return mAndV;
	}*/
	
	@RequestMapping("/AdminSheduledProgramlist.do")
	public ModelAndView getScheduleProgramList() throws UniversityException{
		ModelAndView mAndV = new ModelAndView();
		List<ProgramScheduledBean> scheduleList =service.getAllDetails();
		
		if(scheduleList.size()>0){
		mAndV.addObject("scheduleList", scheduleList);
		mAndV.addObject("flag", true);
		}else{
			mAndV.addObject("flag", false);
			mAndV.addObject("errorMsg", "There is no Scheduled Program.");
		}
		mAndV.setViewName("Admin_Home");
		return mAndV;
	}
	
	@RequestMapping("/AdminOfferedProgramlist.do")
	public ModelAndView getOfferedProgramList() throws UniversityException {
		ModelAndView mAndV = new ModelAndView();
		List<ProgramOfferedBean> offeredList =service.getOfferedProgram();
		
		if(offeredList.size()>0){
				mAndV.addObject("offeredList", offeredList);
				mAndV.addObject("flag", true);
			}else{
				mAndV.addObject("flag", false);
				mAndV.addObject("errorMsg", "There is no Offered Program.");
			}
		mAndV.setViewName("Admin_Home");
		return mAndV;
	}
	
				
	@RequestMapping("/getEntryPage.do")
	public ModelAndView getEntryPageProgramOffered() throws UniversityException {
		ModelAndView mAndV = new ModelAndView();
        ProgramOfferedBean poffered=new ProgramOfferedBean();
        mAndV.addObject("poffered", poffered);
        mAndV.addObject("var", true);
		mAndV.setViewName("Admin_Home");
		return mAndV;
	}
		
	@RequestMapping(value="/addProgramOffered.do",method=RequestMethod.POST)
	public ModelAndView addProgramOffered(@ModelAttribute("poffered") ProgramOfferedBean pbean,BindingResult result){
		ModelAndView mAndV = new ModelAndView();
	if(result.hasErrors())
				{   ProgramOfferedBean poffered=new ProgramOfferedBean();
		        mAndV.addObject("poffered", poffered);
		        mAndV.addObject("var", true);
					mAndV.setViewName("Admin_Home");
				}
			else
				{
				try {
					service.addProgramOffered(pbean);
				} catch (UniversityException e) {
					
					e.printStackTrace();
				}
				mAndV.addObject("poffered",pbean);
				mAndV.setViewName("Admin_Home");
				}
		return mAndV;
	}	
		
		

	@RequestMapping("/AdminDeleteOffered.do")
	public ModelAndView deleteProgPage() throws UniversityException {
		ModelAndView mAndV = new ModelAndView();
		List<ProgramOfferedBean> offeredList =service.getOfferedProgram();
		
		if(offeredList.size()>0){
				mAndV.addObject("offeredList", offeredList);
				mAndV.addObject("flag", true);
				mAndV.addObject("delete", true);
			}else{
				mAndV.addObject("flag", false);
				mAndV.addObject("errorMsg", "There is no Offered Program.");
			}
		mAndV.setViewName("Admin_Home");
		return mAndV;
	}
			
	@RequestMapping("/FinalDeleteOffered.do")
	public ModelAndView finaldeleteProg(@RequestParam("prog") String prog) throws UniversityException {		
		ModelAndView mAndV = new ModelAndView();
		
		service.deleteProgramOffered(prog);
		
		List<ProgramOfferedBean> offeredList =service.getOfferedProgram();
		if(offeredList.size()>0){
			mAndV.addObject("offeredList", offeredList);
			mAndV.addObject("flag", true);
			mAndV.addObject("msg", true);
			
		}else{
			mAndV.addObject("flag", false);
			mAndV.addObject("errorMsg", "There is no Offered Program.");
		}
		mAndV.setViewName("Admin_Home");
		return mAndV;				
	}

	@RequestMapping("/getScheduleProgramPage.do")
	public ModelAndView getScheduleProgramPage() throws UniversityException {
		ModelAndView mAndV = new ModelAndView();
		List<ProgramOfferedBean> offeredList =service.getOfferedProgram();
		if(offeredList.size()>0){
				mAndV.addObject("offeredList", offeredList);
				mAndV.addObject("flag", true);
				mAndV.addObject("schedule",true);
			}else{
				mAndV.addObject("flag", false);
				mAndV.addObject("errorMsg", "There is no Offered Program.");
			}
		mAndV.setViewName("Admin_Home");
		return mAndV;
	}

	@RequestMapping("/FinalScheduleProgramPage.do")
	public ModelAndView FinalScheduleProgram(@RequestParam("prog") String prog) throws UniversityException {		
		ModelAndView mAndV = new ModelAndView();
		List<ProgramScheduledBean> pscheduledList = service.getScheduledProgListForProg(prog);
		
		if(pscheduledList.isEmpty())
		{mAndV.addObject("key",0);}
		else
		{
			mAndV.addObject("key",1);
		}
		
		ProgramScheduledBean pschedule=new ProgramScheduledBean();
        mAndV.addObject("pschedule",pschedule);
        mAndV.addObject("pscheduledList",pscheduledList);
        mAndV.addObject("prog",prog);
        mAndV.addObject("pscheduleform",true);
        mAndV.setViewName("Admin_Home");
        return mAndV;				
	}

	
		
		
		
		@RequestMapping(value="/addProgramSchedule.do",method=RequestMethod.POST)
		public ModelAndView addProgramSchedule(@ModelAttribute("pschedule") ProgramScheduledBean pbean,BindingResult result,@RequestParam("prog") String prog) throws UniversityException{
		ModelAndView mAndV = new ModelAndView();		
		
		if(result.hasErrors()){  
			List<ProgramScheduledBean> pscheduledList = service.getScheduledProgListForProg(prog);
			if(pscheduledList.isEmpty()){
				mAndV.addObject("key",0);
				}
			else{
				mAndV.addObject("key",1);
				}
			
				ProgramScheduledBean pschedule=new ProgramScheduledBean();
		        mAndV.addObject("pschedule", pschedule);
		        mAndV.addObject("pscheduleform",true);
		        mAndV.addObject("prog",prog);
				mAndV.setViewName("Admin_Home");
				}
			else
				{
					try {
						service.addProgramScheduled(pbean);
					} catch (UniversityException e) {
						
						e.printStackTrace();
					}
					List<ProgramScheduledBean> scheduleList =service.getAllDetails();
					if(scheduleList.size()>0){
						mAndV.addObject("scheduleList", scheduleList);
						mAndV.addObject("flag", true);
						}else{
							mAndV.addObject("flag", false);
							mAndV.addObject("errorMsg", "There is no Scheduled Program.");
						}
					mAndV.addObject("pschedule",pbean);
					mAndV.setViewName("Admin_Home");
				}
		return mAndV;
		}	
				
		@RequestMapping("/DeleteScheduledProgramPage.do")
		public ModelAndView DeleteScheduledProgramPage() throws UniversityException {
		ModelAndView mAndV = new ModelAndView();
		List<ProgramScheduledBean> scheduleList =service.getAllDetails();
		
		if(scheduleList.size()>0){
		mAndV.addObject("scheduleList", scheduleList);
		mAndV.addObject("flag", true);
		mAndV.addObject("delete",true);
		}else{
			mAndV.addObject("flag", false);
			mAndV.addObject("errorMsg", "There is no Scheduled Program.");
		}
		mAndV.setViewName("Admin_Home");
		return mAndV;
		}
		
		@RequestMapping("/FinalDeleteScheduledProgram.do")
		public ModelAndView finaldeleteScheduledProg(@RequestParam("pId") String pId) throws UniversityException {		
			ModelAndView mAndV = new ModelAndView();
			
			service.deleteProgramScheduled(pId);
			
			List<ProgramScheduledBean> scheduleList =service.getAllDetails();
			
			if(scheduleList.size()>0){
			mAndV.addObject("scheduleList", scheduleList);
			mAndV.addObject("flag", true);
			mAndV.addObject("msg",true);
			}else{
				mAndV.addObject("flag", false);
				mAndV.addObject("errorMsg", "There is no Scheduled Program.");
			}
			mAndV.setViewName("Admin_Home");
			return mAndV;					
		}
		
}