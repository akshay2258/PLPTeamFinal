package com.capgemini.uas.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.capgemini.uas.dto.ApplicationBean;
import com.capgemini.uas.dto.ProgramOfferedBean;
import com.capgemini.uas.dto.ProgramScheduledBean;
import com.capgemini.uas.exception.UniversityException;
import com.capgemini.uas.service.AdminServiceImpl;
import com.capgemini.uas.service.IAdminService;
import com.capgemini.uas.service.IMacService;
import com.capgemini.uas.service.MacServiceImpl;

public class AdminConsole {
	String userName;
	IAdminService service;
	IMacService macService=new MacServiceImpl();
	public AdminConsole(String userName) {
		super();
		this.userName = userName;
	}
	
	@SuppressWarnings("resource")
	public void start() throws UniversityException {
			int choice=-1;
			String scheduledProgramId;
			service = new AdminServiceImpl();
			Scanner sc;
			sc = new Scanner(System.in);
			System.out.println("Welcome "+userName);
			System.out.println("Choose an operation");
			
			do											//do-while loop
			{				
				System.out.println("1. View particular program scheduled Details");
				System.out.println("2. View list of applicants of particular program Confirmed after interview");
				System.out.println("3. Add program Offered");
				System.out.println("4. Delete Program Offered");
				System.out.println("5. Add Programs Scheduled");
				System.out.println("6. Delete Programs Scheduled");
				System.out.println("7. View list of applicants of particular program scheduled");
				System.out.println("8. Exit");
				System.out.println("******************************");
				System.out.print("\nPlease Enter a Choice : ");
				
				if (sc.hasNextInt()) {
					choice = sc.nextInt();
				} else {
					System.out.println("Please enter a number as in menu");
					sc.next();
					continue;
				}
				
				System.out.println("\n******************************");

				switch (choice) {
				case 1:
					boolean flag2=false;
					
					do{
						System.out.println("Enter Program Scheduled Id");
					scheduledProgramId = sc.next();
					List<String> schlist=service.getAllScheduleId();		
					if(schlist.contains(scheduledProgramId))
					{  flag2=true;
					System.out.println("The List is As Shown");
						List<ProgramScheduledBean> list1 = service.getAllDetails();
										 for (ProgramScheduledBean sch : list1) {
							System.out.println(sch);
						}										 
					}
					else
					{
						flag2=false;
						System.out.println("You Entered Wrong Id");
					}
					}while(flag2==false);
					break;
					
				case 2:{
					boolean flag;
					do{
						System.out.println("Enter Program Scheduled Id");
						String pScheduledId = sc.next();									
						flag = MacServiceImpl.validateScheduledId(pScheduledId);
						if(flag==false){
							System.out.println("Scheduled ID should be number and less than 5 digit");
						}else{
							List<String> cList = macService.getscheduleId();
							if(cList.contains(pScheduledId)){						
								List<ApplicationBean> confirmedList=service.getApplicantsByStatusByScheduledProgramId("confirmed", pScheduledId);
								if(confirmedList.isEmpty()){
									System.out.println("No confirmed student!!");
								}else{
									System.out.println("Confirmed Students List");
									for (ApplicationBean applicants : confirmedList) 
										System.out.println(applicants.getApplicationId()+": "+applicants.getFullName());		
								}
							}else{
								System.out.println("No such Id found");
							}
						}
						System.out.println("To continue press 1 otherwise any other key");
						if("1".equals(sc.next())){
							flag=true;	
						}else	
							flag=false;
					}while(flag);
					break;
					}
					
				case 3:
					boolean flag3=true;
					System.out.println("Enter Program offered details to add: ");
					ProgramOfferedBean pOffered=new ProgramOfferedBean() ;
					System.out.println("Enter Program Name: ");
					sc.nextLine();
					String pName;
					do{
						pName = sc.nextLine();
						if(pName.matches("[a-zA-Z0-9 .]{1,15}")) {
							flag3=false;
						}else
							System.out.println("Enter Program Name wihtout special characters: ");
					}while(flag3);
					pOffered.setProgramName(pName);
					System.out.print("Enter Program Description: ");
					//sc.nextLine();
					String pDesc;
					do{	
						  pDesc=sc.nextLine();
						  flag3=service.validateProgramDescription(pDesc);
						  if(!flag3)
							  System.out.println("Enter Description in correct format ");
					}while(!flag3);
					pOffered.setDescription(pDesc);
					System.out.println("Enter Program Eligibilty");
					pOffered.setApplicantEligiblity(sc.next());
					
					System.out.println("Enter Program duration");
					String description = sc.next();
					flag3=true;
					do {
					try {			
						int desc=Integer.parseInt(description);
						pOffered.setDuration(desc);
						flag3=false;
					} catch (NumberFormatException e) {
						System.out.println("Enter duration in number");
						description = sc.next();
					}
					}while(flag3);
					System.out.println("Enter Program degree Certificate offered");
					pOffered.setDegreeCertificate(sc.next());
					if(service.addProgramOffered(pOffered))
						System.out.println("Program Succesfully Added");
					else
						System.out.println("There was some problem while adding");
					break;
					
				case 4:
					flag3=true;
					do {
						System.out.println("Enter the program name Which you want to delete.");
						pName=sc.next();
						List<String> schlist3=service.getAllProgramName();
						
						if(schlist3.contains(pName)){
							flag3=false;
							boolean flag=service.deleteProgramOffered(pName);
		                    if(flag==true)                    
		                    	System.out.println("Delete Successful");                  
		                    else                   
		                    	System.out.println("Failed!!");										
						}else {
							flag3=true;
							System.out.println("Enter Valid Program name");
						}
					}while(flag3);
					break;
					
				case 5:
					boolean flag=true;
					System.out.println("Enter Program Scheduled details to add: ");
					ProgramScheduledBean pScheduled=new ProgramScheduledBean() ;
					do{
						List<String> idList=service.getAllScheduleId();
						System.out.println("Enter Schedule Program Id: ");
						String schId=sc.next();
						if(idList.contains(schId))
						{
							System.out.println("Entered Id Already Exists In the Schedule Table");
							flag=true;
						}
						else
						{
							pScheduled.setScheduledProgramId(schId);
							System.out.println("Enter schedule Program as Available in Offered program Table(shown below) ");
							List<String> oFPNameList=service.getAllProgramName();
							
							for (String id : oFPNameList) 
								System.out.print(id+" ");
							
							String schProgName= sc.next();
							if(oFPNameList.contains(schProgName)){							
								pScheduled.setProgramName(schProgName);
								flag=false;
						
								do
								{
									System.out.println("Enter the New Location");
									String location=sc.next();
									flag=service.validateLocation(location);
								}while(flag==false);
								
								System.out.println("Enter the Start Date");
								String date=sc.next();
								DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
								LocalDate date1 = LocalDate.parse(date,formatter);
					            Date date2=java.sql.Date.valueOf(date1);
					            pScheduled.setStartDate(date2);
								System.out.println("Enter End Date");
								String edate=sc.next();
								DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("yyyy-MM-dd");
								LocalDate edate1 = LocalDate.parse(edate,formatter1);
					            Date edate2=java.sql.Date.valueOf(edate1);
					            pScheduled.setEndDate(edate2);
					            
					            System.out.println("Enter the number of Sessions per week");
					            pScheduled.setSessionPerWeek(sc.nextInt());
					            
								service.addProgramScheduled(pScheduled);
								
								System.out.println("The Program Added successfully with Scheduled id "+ schId);
							}
							else
							{
								System.out.println("Entred Program Not Found");
							}
						}
					}while(flag);
					break;
					
				case 6:
					System.out.println("The List of Schedules is As follows:");
					List<ProgramScheduledBean> schList=service.getAllDetails();
					for(ProgramScheduledBean list:schList)
					System.out.println(list);
					
					System.out.println("Enter the Schedule ID ");
					String schId=sc.next();
					boolean flag1=service.deleteProgramScheduled(schId);
					if(flag1==true)
					{
						System.out.println("Delete Succesful");
					}
					else
					{
						System.out.println("Failed");
					}
					break;
				case 7:{
					do{
						System.out.println("Enter Program Scheduled Id");
						String pScheduledId = sc.next();									
						flag = MacServiceImpl.validateScheduledId(pScheduledId);
						if(flag==false){
							System.out.println("Scheduled ID should be number and less than 5 digit");
						}else{
							List<String> cList = macService.getscheduleId();
							if(cList.contains(pScheduledId)){						
								List<ApplicationBean> confirmedList=service.getApplicantsByStatusByScheduledProgramId("confirmed", pScheduledId);
								List<ApplicationBean> acceptedList=service.getApplicantsByStatusByScheduledProgramId("accepted", pScheduledId);
								List<ApplicationBean> rejectedList=service.getApplicantsByStatusByScheduledProgramId("rejected", pScheduledId);
								if(confirmedList.isEmpty()){
									System.out.println("No confirmed student!!");
								}else{
									System.out.println("Confirmed Students List");
									for (ApplicationBean applicants : confirmedList) 
										System.out.println(applicants.getApplicationId()+": "+applicants.getFullName());		
								}
								if(acceptedList.isEmpty()){
									System.out.println("No Accepted student!!");
								}else{
									System.out.println("Accepted Students List");
									for (ApplicationBean applicants : acceptedList) 
										System.out.println(applicants.getApplicationId()+": "+applicants.getFullName());		
								}
								if(rejectedList.isEmpty()){
									System.out.println("No Rejected student!!");
								}else{
									System.out.println("Rejected Students List");
									for (ApplicationBean applicants : rejectedList) 
										System.out.println(applicants.getApplicationId()+": "+applicants.getFullName());		
								}
							}else{
								System.out.println("No such Id found");
							}
						}
						System.out.println("To continue press 1 otherwise any other key");
						if("1".equals(sc.next())){
							flag=true;	
						}else	
							flag=false;
					}while(flag);
					break;
					}
					default:
						if(choice!=8) {
							if(choice<1 || choice>8) {
								System.out.println("No such choice ");
							}
						System.out.println("Do You Want to continue : \nPress 1  to continue\nAny Other key to exit ");
						String decision = sc.next();
						if(!("1".equals(decision))) {
							System.out.println("Thanks For Visiting..");
							choice=8;
						}
						}else
							System.out.println("Thanks For Visiting..");
				}
				}while(choice!=8);
	}
}
