package com.pk.recruiter.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="hrm_job")

public class Job {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Job")
	@SequenceGenerator(name = "id_Job", sequenceName = "ID_Job")
	private int id;

	@Column(name="company")
	private String company;
	@Column(name="job_name")
	private String jobName;
	@Column(name="job_type")
	private String jobType;
	@Column(name="city")
	private String city;
	@Column(name="description")
	private String description;
	@Column(name="vacancy")
	private String vacancy;
	@Column(name="dept")
	private String dept;
	@Column(name="post_date")
	private Date postDate;
	@Column(name = "expired_date")
	private Date expiredDate;
	@ManyToOne(cascade=CascadeType.ALL)
	private Recruiter recruiter;
	@OneToMany(targetEntity=Application.class,cascade=CascadeType.ALL)
	@JoinColumn(name="job_id")
	private List<Application> applicaionsList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVacancy() {
		return vacancy;
	}
	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPostDate() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		return df.format(postDate);
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getExpiredDate() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		return df.format(expiredDate);
	}
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
	public Recruiter getRecruiter() {
		return recruiter;
	}
	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}
	public List<Application> getApplicaionsList() {
		return applicaionsList;
	}
	public void setApplicaionsList(List<Application> applicaionsList) {
		this.applicaionsList = applicaionsList;
	}

	public Job(String company, String jobName, String jobType, String city, String description, String vacancy,
			String dept, Date postDate, Date expiredDate) {
		super();
		this.company = company;
		this.jobName = jobName;
		this.jobType = jobType;
		this.city = city;
		this.description = description;
		this.vacancy = vacancy;
		this.dept = dept;
		this.postDate = postDate;
		this.expiredDate = expiredDate;
	}

	public Job() {
		super();
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", company=" + company + ", jobName=" + jobName + ", jobType=" + jobType + ", city="
				+ city + ", description=" + description + ", vacancy=" + vacancy + ", dept=" + dept + ", postDate="
				+ postDate + ", expiredDate=" + expiredDate + ", recruiter=" + recruiter + "]";
	}  	
	
}
