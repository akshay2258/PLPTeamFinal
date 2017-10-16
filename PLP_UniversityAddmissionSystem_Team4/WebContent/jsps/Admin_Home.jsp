<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Admin</title>
		
		 <style type="text/css">
			#leftside{
				position:fixed;
				left:0%;
				width:20%;
				height:100%;
				background-color:#CD853F;
			}
			#rightside{
				position:absolute;
				right:0%;	
				width:79%;	
				height:auto;
				background-color:#FFFACD;
			}
			#top{
				text-align:center;
					
			}
			#tablehead{
				font-weight: bold;
				text-align: center;
			}
			table{
				border-collapse: collapse;
				border: 2px solid grey;				
			}
			th, td {
				padding: 10px;
				text-align: center;
			}
			button{
				text-align: center;
				width: 250px;
				height: 38px;
				font-size:15px;
			}
			div{
				border: solid;				
			}
			body{
				background-color:grey;
			}
			input{
				background-color: #FFFACD;
			}
	</style>
	
	</head>
	<body>
		<h3 id="top">Welcome to Admin ${loginId}</h3>		
		<div id="leftside">
			<table>
				<tr><td><button onclick="window.location.href='AdminSheduledProgramlist.do';" ><b>Scheduled Program</b></button></td></tr>
				<tr><td><button onclick="window.location.href='AdminOfferedProgramlist.do';" ><b>Offered Program</b></button></td></tr>
				<tr><td><button onclick="window.location.href='AdminApplicants.do';" ><b>Applicant Details</b></button></td></tr>
				<tr><td><button onclick="window.location.href='getEntryPage.do';"><b>Add program Offered</b></button> </td> </tr>
				<tr><td><button onclick="window.location.href='AdminDeleteOffered.do';"> <b>Delete Program Offered</b></button></td></tr>
				<tr><td><button onclick="window.location.href='getScheduleProgramPage.do';" ><b>Schedule A Program</b></button></td></tr>
				<tr><td><button onclick="window.location.href='DeleteScheduledProgramPage.do';" ><b>Delete Scheduled Program </b></button></td></tr>
				<tr><td><button onclick="Admin/" ><b>Search Applicants</b></button></td></tr>
				<tr><td><button onclick="Admin/" ><b>Generate Confirmed Students List</b></button></td></tr>
			</table>
		</div>
		
		<div id="rightside">
		
			<c:if test="${scheduleList ne null }">
			<c:if test="${msg eq true}">
				<h2 id="tablehead">Scheduled Program Deleted.Please see the Updated List</h2>
			</c:if>
				<h2 align="center">Scheduled Programs</h2>
				<table border="1" id="scheduleList" align="center">
						<tr>
							<th>Program Id</th>
							<th>Program Name</th>				
							<th>location</th>
							<th>Start date</th>
							<th>End Date</th>
							<th>Session per Week</th>
						</tr>
							<c:forEach items="${scheduleList }" var="scheduledPrg">
							<tr>
								<td>${scheduledPrg.scheduledProgramId }</td>
								<td>${scheduledPrg.programName }</td>
								<td>${scheduledPrg.location }</td> 
								<td>${scheduledPrg.startDate }</td>
								<td>${scheduledPrg.endDate }</td>	
								<td>${scheduledPrg.sessionPerWeek }</td>
								<c:if test="${delete eq true}"><td><a href="FinalDeleteScheduledProgram.do?pId=${scheduledPrg.scheduledProgramId}"><b>Delete</b></a></td></c:if>								
							</tr>
						</c:forEach>
					</table>
					
			</c:if>
			
			
			<c:if test="${offeredList ne null }">
					<h2 align="center">Offered Program list</h2>
					<c:if test="${msg eq true}">
						<h2 id="tablehead">Selected Program Deleted. See the Updated List</h2>
					</c:if>	
					<table border="1" id="offrdlist" align="center">
						<tr>
							<th>Program Name</th>
							<th>Description</th>
							<th>Eligibility</th>
							<th>Duration(in Months)</th>
							<th>Degree Certificate</th>
						</tr>
						<c:forEach items="${offeredList}" var="offeredprogram">
							<tr>
								<td>${offeredprogram.programName }</td>
								<td>${offeredprogram.description }</td>
								<td>${offeredprogram.applicantEligiblity }</td> 
								<td>${offeredprogram.duration }</td>
								<td>${offeredprogram.degreeCertificate }</td>
								<c:if test="${delete eq true}"><td><a href="FinalDeleteOffered.do?prog=${offeredprogram.programName}"><b>Delete</b></a></td></c:if>	
								<c:if test="${schedule eq true}"><td><a href="FinalScheduleProgramPage.do?prog=${offeredprogram.programName}"><b>Schedule</b></a></td></c:if>				
							</tr>
						</c:forEach>
					</table>
					
			</c:if >
			
			<c:if test="${var eq true}">
				<h2 id="tablehead">Enter Programm Offered Details</h2>
				
			<table border="1" align="center">
				<sf:form action="addProgramOffered.do" modelAttribute="poffered" method="post">
			  <tr><td> Enter Program Name :</td><td>
			   <sf:input path="programName"  type="text" />
			   <sf:errors path="programName" name="error"></sf:errors></td></tr>
				
				<tr><td>Enter Description :</td><td>
				<sf:input path="description" type="text" />
				<sf:errors path="description" name="error"></sf:errors></td></tr>
				
				<tr><td>Enter Eligiblity :</td><td>
				<sf:input path="applicantEligiblity" type="text"/>
				<sf:errors path="applicantEligiblity" name="error"></sf:errors></td></tr>
				
			    <tr><td>Enter Programm Duration :</td><td> 
				<sf:input path="duration" type="text"/>
				<sf:errors path="duration" type="text" ></sf:errors></td></tr>
				
				 <tr><td>Enter Degree : </td><td>
				<sf:input path="degreeCertificate" type="text"/>
				<sf:errors path="degreeCertificate" type="text" ></sf:errors></td></tr>
				
				<tr><td><input type="reset" value="Reset"/></td><td><input type="submit" value="Add Programm"/></td></tr>
				
				</sf:form>
				</table>
			</c:if>
			
			
			<c:if test="${pscheduleform eq true}">
			 <c:if test="${key eq 1}">
				<h2 id="tablehead">Already Existing Schedules for the Program Selected</h2>
			
			<table border="1" align="center">
						<tr>
							<th>Program Id</th>
							<th>Program Name</th>				
							<th>location</th>
							<th>Start date</th>
							<th>End Date</th>
							<th>Session per Week</th>
						</tr>
							<c:forEach items="${pscheduledList}" var="scheduledPrg">
							<tr>
								<td>${scheduledPrg.scheduledProgramId }</td>
								<td>${scheduledPrg.programName }</td>
								<td>${scheduledPrg.location }</td> 
								<td>${scheduledPrg.startDate }</td>
								<td>${scheduledPrg.endDate }</td>	
								<td>${scheduledPrg.sessionPerWeek }</td>								
							</tr>
						</c:forEach>
					</table>
					
			</c:if>
			
			<h2 id="tablehead">Schedule a Program</h2>
			<table border="1" align="center">
				<sf:form action="addProgramSchedule.do" modelAttribute="pschedule" method="post">
			  <tr><td> Enter Program ID :</td><td>
			   	<sf:input path="scheduledProgramId"  type="text" />
			   	<sf:errors path="scheduledProgramId" name="error"></sf:errors></td></tr>
				
				<tr><td>Enter Program Name :</td><td>
				<sf:input path="programName" type="text" value="${prog}" readonly="true"/>
				<sf:errors path="programName" name="error"></sf:errors></td></tr>
				
				<tr><td>Enter Location :</td><td>
				<sf:input path="location" type="text"/>
				<sf:errors path="location" name="error"></sf:errors></td></tr>
				
			    <tr><td>Enter Start Date :</td><td> 
				<sf:input path="startDate" type="text"/>
				<sf:errors path="startDate" type="text" ></sf:errors></td></tr>
				
				 <tr><td>Enter End Date : </td><td>
				<sf:input path="endDate" type="text"/>
				<sf:errors path="endDate" type="text" ></sf:errors></td></tr>
				
				<tr><td>Enter No. Of Sessions per week: </td><td>
				<sf:input path="sessionPerWeek" type="text"/>
				<sf:errors path="sessionPerWeek" type="text" ></sf:errors></td></tr>
				<input type="hidden" name="prog" value="${prog}">
				<tr><td><input type="reset" value="Reset"/></td>
				<td><input type="submit" value="Schedule Programm"/></td></tr>
				
				</sf:form>
				</table>
			</c:if>			
		</div>
	</body>
</html>