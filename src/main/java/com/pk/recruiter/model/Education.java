package com.pk.recruiter.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="hrm_edu", uniqueConstraints=  @UniqueConstraint(columnNames = {"education_category_id","job_seeker_id"}) )
public class Education {

	@Id
	@Column(name = "educationId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Education")
	@SequenceGenerator(name = "id_Education", sequenceName = "ID_Edu")
	private int educationId;
	private String university;
	private String major;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateIn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOut;
	
	
	private Float percentage;
	@ManyToOne()
	private EducationCategory educationCategory;
	
	@ManyToOne()
	
	private JobSeeker jobSeeker;
	

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	public EducationCategory getEducationCategory() {
		return educationCategory;
	}

	public void setEducationCategory(EducationCategory educationCategory) {
		this.educationCategory = educationCategory;
	}

	public Education() {
		super();
		educationCategory=new EducationCategory();
	}

	public Education(String university, String major, Date dateIn, Date dateOut, Float percentage) {
		super();
		this.university = university;
		this.major = major;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.percentage = percentage;
	}	

	public Education(int educationId, String university, String major, Date dateIn, Date dateOut, Float percentage) {
		super();
		this.educationId = educationId;
		this.university = university;
		this.major = major;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.percentage = percentage;
	}

	public int getEducationId() {
		return educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}	

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public Date getDateOut() {
		return dateOut;
	}

	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	@Override
	public String toString() {
		return "Education [dateIn=" + dateIn + ", dateOut=" + dateOut + ", major=" + major + ", percentage="
				+ percentage + ", university=" + university + "]";
	}

	
	
}
