package com.pk.recruiter.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hrm_jbseek", uniqueConstraints = @UniqueConstraint(columnNames = { "id", "users_id" }))

public class JobSeeker {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_JobSeeker")
	@SequenceGenerator(name = "id_JobSeeker", sequenceName = "ID_JbSeek")
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String idCard;
	private String placeBirth;
	private String phoneNumber;
	private String religion;
	private String address;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateBirth;

	@OneToOne(cascade = CascadeType.ALL) // Restrict some crud ops
	@JoinColumn(name = "users_id")
	private Users users;

	@OneToMany(targetEntity = Education.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "job_seeker_id")
	@JsonIgnore
	private List<Education> educationSet;

	@OneToOne(mappedBy = "jobSeeker")
	@JsonIgnore
	private Resume resume;

	@OneToMany(targetEntity = Skills.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "job_seeker_id")
	@JsonIgnore
	private List<Skills> skillList;

	@OneToMany(targetEntity = Certifications.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "job_seeker_id")
	@JsonIgnore
	private List<Certifications> certificationsList;

	@OneToMany(targetEntity = Family.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "job_seeker_id")
	@JsonIgnore
	private List<Family> familyList;

	@OneToMany(targetEntity = Organization.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "job_seeker_id")
	@JsonIgnore
	private List<Organization> organizationList;

	@OneToMany(targetEntity = WorkExperience.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "job_seeker_id")
	@JsonIgnore
	private List<WorkExperience> workExperienceList;

	@OneToMany(targetEntity = Application.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "job_seeker_id")
	@JsonIgnore
	private List<Application> appliedJobs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPlaceBirth() {
		return placeBirth;
	}

	public void setPlaceBirth(String placeBirth) {
		this.placeBirth = placeBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Education> getEducationSet() {
		return educationSet;
	}

	public void setEducationSet(List<Education> educationSet) {
		this.educationSet = educationSet;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public List<Skills> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skills> skillList) {
		this.skillList = skillList;
	}

	public List<Certifications> getCertificationsList() {
		return certificationsList;
	}

	public void setCertificationsList(List<Certifications> certificationsList) {
		this.certificationsList = certificationsList;
	}

	public List<Family> getFamilyList() {
		return familyList;
	}

	public void setFamilyList(List<Family> familyList) {
		this.familyList = familyList;
	}	

	public List<Organization> getOrganizationList() {
		return organizationList;
	}

	public void setOrganizationList(List<Organization> organizationList) {
		this.organizationList = organizationList;
	}

	public List<WorkExperience> getWorkExperienceList() {
		return workExperienceList;
	}

	public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
		this.workExperienceList = workExperienceList;
	}

	public List<Application> getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(List<Application> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}

	@Override
	public String toString() {
		return "JobSeeker [address=" + address + ", dateBirth=" + dateBirth + ", firstName="
				+ firstName + ", id=" + id + ", idCard=" + idCard + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", placeBirth=" + placeBirth + ", religion=" + religion + ", users=" + users + "]";
	}

	public JobSeeker(String firstName, String lastName, String idCard, String phoneNumber, Date dateBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idCard = idCard;
		this.phoneNumber = phoneNumber;
		this.dateBirth = dateBirth;
	}

	public JobSeeker() {
		super();
	}

}
