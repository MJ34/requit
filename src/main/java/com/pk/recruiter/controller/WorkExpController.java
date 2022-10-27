package com.pk.recruiter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pk.recruiter.model.JobSeeker;
import com.pk.recruiter.model.LoginUsers;
import com.pk.recruiter.model.Users;
import com.pk.recruiter.model.WorkExperience;
import com.pk.recruiter.service.JobSeekerService;
import com.pk.recruiter.service.WorkExpService;

@Controller
public class WorkExpController {
    
    @Autowired
	private JobSeekerService jobSeekerService;

    @Autowired
    private WorkExpService workService;
    
    @RequestMapping("/workExp")
	public ModelAndView workExp(HttpServletRequest request) {
		ModelAndView model = null;
		HttpSession session=request.getSession();
		JobSeeker activeUser = (JobSeeker) session.getAttribute("userId");		
		if (activeUser != null) {
			model = new ModelAndView("workExp");
			model.addObject("workExp", new WorkExperience());
			
			JobSeeker jobSeeker = jobSeekerService.findById(activeUser.getId());
			if (jobSeeker.getWorkExperienceList().isEmpty()) 
			{
				model.addObject("workExperienceList", null);
			} else 
			{
				model.addObject("workExperienceList", jobSeeker.getWorkExperienceList());
			}
		} else {
			model = new ModelAndView("login-jobseeker");
			model.addObject("loginusers", new Users());
		}
		return model;
	}

	@RequestMapping("/addWorkExp")
	public ModelAndView addWorkExp(HttpServletRequest request,
			@ModelAttribute("workExp") WorkExperience wExperience) {
		ModelAndView model = null;
		JobSeeker activeUser = (JobSeeker) request.getSession().getAttribute("userId");
		
		if (activeUser != null) {
			model = new ModelAndView("workExp");
			
			JobSeeker jobSeeker = jobSeekerService.findById(activeUser.getId());
			WorkExperience workExperience = workService.findByName(wExperience.getName());

			if(workExperience==null)
			{jobSeeker.getWorkExperienceList().add(wExperience);
				model.addObject("msg", wExperience.getName() + " sucessfully Added");
				jobSeekerService.saveJobSeeker(jobSeeker);	
			}
			else
			{
				model.addObject("msg", "Already Added");

			}
			
		
			model.addObject("workExp", new WorkExperience());
			if (jobSeeker.getWorkExperienceList().isEmpty()) {
				model.addObject("workExp", null);
			} else {
				 jobSeeker = jobSeekerService.findById(activeUser.getId());
				model.addObject("workExp", jobSeeker.getWorkExperienceList());
			}
		} else {
			model = new ModelAndView("login-jobseeker");
			model.addObject("loginusers", new LoginUsers());
		}
		return model;
	}
	@RequestMapping("/deleteWorkExp")
	public ModelAndView deleteWorkExp(HttpServletRequest request,@RequestParam("workExpId") Integer Id)
	{
		JobSeeker activeUser = (JobSeeker) request.getSession().getAttribute("userId");
		ModelAndView model = null;
		
			
			if (activeUser == null) {
				model = new ModelAndView("login-jobseeker");
				model.addObject("loginusers", new Users());

			} else {
				model = new ModelAndView("workExp");
				JobSeeker jobSeeker=jobSeekerService.findById(activeUser.getId());
				List<WorkExperience> workExpList = workService.findByJobSeeker(activeUser);
				
				WorkExperience workExp= workExpList.get(Id);
				
                workExpList.remove(workExpList.get(Id));
					jobSeeker.setWorkExperienceList(workExpList);
				
				workService.deleteById(workExp.getId());
				
				jobSeekerService.saveJobSeeker(jobSeeker);
				model.addObject("workExpList", jobSeeker.getWorkExperienceList());
			}
		
		return model;
		
	}
}
