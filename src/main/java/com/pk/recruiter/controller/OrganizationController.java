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
import com.pk.recruiter.model.Organization;
import com.pk.recruiter.model.Users;
import com.pk.recruiter.service.JobSeekerService;
import com.pk.recruiter.service.OrganizationService;

@Controller
public class OrganizationController {
    
    @Autowired
	private JobSeekerService jobSeekerService;

    @Autowired
    private OrganizationService orgService;
    
    @RequestMapping("/organization")
	public ModelAndView organization(HttpServletRequest request) {
		ModelAndView model = null;
		HttpSession session=request.getSession();
		JobSeeker activeUser = (JobSeeker) session.getAttribute("userId");		
		if (activeUser != null) {
			model = new ModelAndView("organization");
			model.addObject("organization", new Organization());
			
			JobSeeker jobSeeker = jobSeekerService.findById(activeUser.getId());
			if (jobSeeker.getFamilyList().isEmpty()) 
			{
				model.addObject("organizationList", null);
			} else 
			{
				model.addObject("organizationList", jobSeeker.getOrganizationList());
			}
		} else {
			model = new ModelAndView("login-jobseeker");
			model.addObject("loginusers", new Users());
		}
		return model;
	}

	@RequestMapping("/addOrganization")
	public ModelAndView addOrganization(HttpServletRequest request,
			@ModelAttribute("organization") Organization organiz) {
		ModelAndView model = null;
		JobSeeker activeUser = (JobSeeker) request.getSession().getAttribute("userId");
		
		if (activeUser != null) {
			model = new ModelAndView("organization");
			
			JobSeeker jobSeeker = jobSeekerService.findById(activeUser.getId());
			Organization organization = orgService.findByName(organiz.getName());

			if(organization==null)
			{jobSeeker.getOrganizationList().add(organiz);
				model.addObject("msg", organiz.getName() + " sucessfully Added");
				jobSeekerService.saveJobSeeker(jobSeeker);	
			}
			else
			{
				model.addObject("msg", "Already Added");

			}
			
		
			model.addObject("organization", new Organization());
			if (jobSeeker.getOrganizationList().isEmpty()) {
				model.addObject("organizationList", null);
			} else {
				 jobSeeker = jobSeekerService.findById(activeUser.getId());
				model.addObject("organizationList", jobSeeker.getOrganizationList());
			}
		} else {
			model = new ModelAndView("login-jobseeker");
			model.addObject("loginusers", new LoginUsers());
		}
		return model;
	}
	@RequestMapping("/deleteOrganization")
	public ModelAndView deleteOrganization(HttpServletRequest request,@RequestParam("organizationId") Integer Id)
	{
		JobSeeker activeUser = (JobSeeker) request.getSession().getAttribute("userId");
		ModelAndView model = null;
		
			
			if (activeUser == null) {
				model = new ModelAndView("login-jobseeker");
				model.addObject("loginusers", new Users());

			} else {
				model = new ModelAndView("family");
				JobSeeker jobSeeker=jobSeekerService.findById(activeUser.getId());
				List<Organization> organizationList = orgService.findByJobSeeker(activeUser);
				
				Organization organization= organizationList.get(Id);
				
					organizationList.remove(organizationList.get(Id));
					jobSeeker.setOrganizationList(organizationList);
				
				orgService.deleteById(organization.getId());
				
				jobSeekerService.saveJobSeeker(jobSeeker);
				model.addObject("organizationList", jobSeeker.getOrganizationList());
			}
		
		return model;
		
	}
}
