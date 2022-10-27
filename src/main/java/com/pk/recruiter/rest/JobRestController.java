package com.pk.recruiter.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pk.recruiter.model.Job;
import com.pk.recruiter.model.Recruiter;
import com.pk.recruiter.model.Users;
import com.pk.recruiter.repository.ApplicationRepository;
import com.pk.recruiter.repository.JobRepository;
import com.pk.recruiter.repository.JobSeekerRepository;
import com.pk.recruiter.repository.RecruiterRepository;
import com.pk.recruiter.repository.UsersRepository;

@CrossOrigin(origins = { "http://localhost:4200", "http://localHost:8080" })
@RestController
@RequestMapping("/api/jobs")
public class JobRestController {
	@Autowired
	private UsersRepository usersRepo;
	@Autowired
	private JobRepository jobRepo;
	@Autowired
	private RecruiterRepository recruiterRepo;
	@Autowired
	private JobSeekerRepository jobSeekerRepo;
	@Autowired
	private ApplicationRepository applicationRepo;

	List<Job> removeMapping(List<Job> jobList) {

		for (Job job : jobList) {
			System.out.println(job);
			job.setRecruiter(null);
			job.setApplicaionsList(null);
		}
		return jobList;

	}

	@GetMapping("")
	public List<Job> jobListing() {
		return removeMapping(jobRepo.findAll());
	}

	@PostMapping("/showPostedJobs")
	public /* Map<String, */List<Job>/* > */ jobListPostedByRecruiter(@RequestBody Users recruiter) {
		Map<String, List<Job>> jobList = new HashMap<String, List<Job>>();
		System.out.println(recruiter.getId());
		recruiter = usersRepo.findById(recruiter.getId()).get();
		List<Job> jobListValues = jobRepo.findByRecruiterOrderByPostDateAsc(recruiter.getRecruiter());
		if(!jobListValues.isEmpty()) {
		for (Job job : jobListValues) {
			System.out.println(job);
			job.setRecruiter(null);
			job.setApplicaionsList(null);
		}}
		jobList.put("list", jobListValues);
		return jobListValues;
	}

	@PostMapping("/postjob")
	public List<Job> postJob(@RequestBody Map<String, String> job) {
		Integer userId = Integer.parseInt(job.get("recruiter"));
		Date postDate = new Date(job.get("postDate"));
		String[] expiredDateWithoutFormat = job.get("expiredDate").split("-");
		Date expiredDate = new Date(
				expiredDateWithoutFormat[1] + "/" + expiredDateWithoutFormat[2] + "/" + expiredDateWithoutFormat[0]);
		String description = job.get("description");
		String company = job.get("employerEmail");
		String title = job.get("name");
		String jobType = job.get("jobType");
		String vacancy = job.get("vacancy");
		Users user = usersRepo.findById(userId).get();
		Recruiter recruiter = recruiterRepo.findById(user.getRecruiter().getId()).get();
		System.out.println(recruiter);
		Job postJob = new Job();
		postJob.setDescription(description);
		postJob.setPostDate(postDate);
		postJob.setCompany(company);
		postJob.setExpiredDate(expiredDate);
		postJob.setJobName(title);
		postJob.setJobType(jobType);
		postJob.setVacancy(vacancy);
		postJob.setRecruiter(recruiter);
		System.out.println(postJob);
		recruiter.getJobList().add(jobRepo.save(postJob));
		List<Job> jobListValues = jobRepo.findByRecruiterOrderByPostDateAsc(recruiter);
		if (!jobListValues.isEmpty()) {
			for (Job job1 : jobListValues) {
				System.out.println(job1);
				job1.setRecruiter(null);
				job1.setApplicaionsList(null);
			}
		}
		
		return jobListValues;
	}

}
