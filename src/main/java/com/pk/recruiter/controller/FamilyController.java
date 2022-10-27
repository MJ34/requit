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

import com.pk.recruiter.model.Family;
import com.pk.recruiter.model.JobSeeker;
import com.pk.recruiter.model.LoginUsers;
import com.pk.recruiter.model.Users;
import com.pk.recruiter.service.FamilyService;
import com.pk.recruiter.service.JobSeekerService;

@Controller
public class FamilyController {

    @Autowired
	private JobSeekerService jobSeekerService;

    @Autowired
    private FamilyService familyService;
    
    @RequestMapping("/family")
	public ModelAndView family(HttpServletRequest request) {
		ModelAndView model = null;
		HttpSession session=request.getSession();
		JobSeeker activeUser = (JobSeeker) session.getAttribute("userId");		
		if (activeUser != null) {
			model = new ModelAndView("family");
			model.addObject("family", new Family());
			
			JobSeeker jobSeeker = jobSeekerService.findById(activeUser.getId());
			if (jobSeeker.getFamilyList().isEmpty()) 
			{
				model.addObject("familyList", null);
			} else 
			{
				model.addObject("familyList", jobSeeker.getFamilyList());
			}
		} else {
			model = new ModelAndView("login-jobseeker");
			model.addObject("loginusers", new Users());
		}
		return model;
	}

	@RequestMapping("/addFamily")
	public ModelAndView addFamily(HttpServletRequest request,
			@ModelAttribute("family") Family famili) {
		ModelAndView model = null;
		JobSeeker activeUser = (JobSeeker) request.getSession().getAttribute("userId");
		
		if (activeUser != null) {
			model = new ModelAndView("family");
			
			JobSeeker jobSeeker = jobSeekerService.findById(activeUser.getId());
			Family family = familyService.findByIdCard(famili.getIdCard());

			if(family==null)
			{jobSeeker.getFamilyList().add(famili);
				model.addObject("msg", famili.getNameFam() + " sucessfully Added");
				jobSeekerService.saveJobSeeker(jobSeeker);	
			}
			else
			{
				model.addObject("msg", "Already Added");

			}
			
		
			model.addObject("family", new Family());
			if (jobSeeker.getFamilyList().isEmpty()) {
				model.addObject("familyList", null);
			} else {
				 jobSeeker = jobSeekerService.findById(activeUser.getId());
				model.addObject("familyList", jobSeeker.getFamilyList());
			}
		} else {
			model = new ModelAndView("login-jobseeker");
			model.addObject("loginusers", new LoginUsers());
		}
		return model;
	}
	@RequestMapping("/deleteFamily")
	public ModelAndView deleteFamily(HttpServletRequest request,@RequestParam("familyId") Integer Id)
	{
		JobSeeker activeUser = (JobSeeker) request.getSession().getAttribute("userId");
		ModelAndView model = null;
		
			
			if (activeUser == null) {
				model = new ModelAndView("login-jobseeker");
				model.addObject("loginusers", new Users());

			} else {
				model = new ModelAndView("family");
				JobSeeker jobSeeker=jobSeekerService.findById(activeUser.getId());
				List<Family> familyList = familyService.findByJobSeeker(activeUser);
				
				Family famili= familyList.get(Id);
				
					familyList.remove(familyList.get(Id));
					jobSeeker.setFamilyList(familyList);
				//}
				familyService.deleteById(famili.getId());
				
				jobSeekerService.saveJobSeeker(jobSeeker);
				model.addObject("familyList", jobSeeker.getFamilyList());
			}
		
		return model;
		
	}

}
