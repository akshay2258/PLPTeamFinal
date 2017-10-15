package com.capgemini.uas.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.uas.dto.UsersBean;
import com.capgemini.uas.exception.UniversityException;
import com.capgemini.uas.service.IUsersService;

@Controller
public class UniversityController {
	
	@Resource
	IUsersService service;
	
	@RequestMapping("/getHomePage.do")
	public ModelAndView goToHome(){
		ModelAndView mAndV = new ModelAndView();
		//mAndV.setViewName("Welcome");
		mAndV.setViewName("test3");
		return mAndV;
		
	}
	
	@RequestMapping("/validateUser.do")
	public ModelAndView validateUser(@RequestParam("loginId") String loginId, @RequestParam("password") String password){
		UsersBean userBeanMain = new UsersBean();
		String role; 
		userBeanMain.setLoginId(loginId);
		userBeanMain.setPassword(password);
		ModelAndView mAndV = new ModelAndView();
		try {
			role = service.checkUser(userBeanMain);
			if(role.equals("admin")){
				mAndV.addObject("role",role);
				mAndV.addObject("loginId",userBeanMain.getLoginId());
				mAndV.setViewName("Admin_Home");
				return mAndV;
			}else if(role.equals("mac")){
				mAndV.addObject("role",role);
				mAndV.addObject("loginId",userBeanMain.getLoginId());
				mAndV.setViewName("MACHomePage");
				return mAndV;
			}
		} catch (UniversityException e) {
			mAndV.addObject("error",e.getMessage());
			mAndV.setViewName("Error");
			return mAndV;
		}
		mAndV.addObject("error","Not Found");
		mAndV.setViewName("Error");
		return mAndV;
	}
}
