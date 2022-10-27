package com.pk.recruiter.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "hrm_resume",uniqueConstraints= @UniqueConstraint(columnNames = {"jobSeeker", "fileName"}))

public class Resume {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Resume")
	@SequenceGenerator(name = "id_Resume", sequenceName = "ID_Resume")
	private int id;
	
	private String fileName;
	private String fileType;
	
	@Lob
	private byte[] data;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "jobSeeker")
	private JobSeeker jobSeeker;


	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public Resume() {
		super();
	}

	public Resume(String fileName, String fileType, byte[] data) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Resume [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + "]";
	}

	public Resume(String fileName, String fileType) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
	}


	
	
	

}
