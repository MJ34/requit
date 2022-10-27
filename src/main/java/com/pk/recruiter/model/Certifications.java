package com.pk.recruiter.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "hrm_cert", uniqueConstraints= @UniqueConstraint(columnNames = {"job_seeker_id", "url"}))

public class Certifications {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Certifications")
	@SequenceGenerator(name = "id_Certifications", sequenceName = "ID_Cert")
	private Integer id;
	private String url;
	private String certificationName;
	private Date issueDate;
	private Date expireDate;
	
	@ManyToOne
	private JobSeeker jobSeeker;

	public String getUrl() {
		return url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	@Override
	public String toString() {
		return "Certifications [id=" + id + ", url=" + url + ", certificationName=" + certificationName + ", issueDate="
				+ issueDate + ", expireDate=" + expireDate + "]";
	}

	public Certifications(String url, String certificationName, Date issueDate, Date expireDate) {
		super();
		this.url = url;
		this.certificationName = certificationName;
		this.issueDate = issueDate;
		this.expireDate = expireDate;
	}

	public Certifications() {
		super();
	}
	
	
}
