package com.pk.recruiter.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "hrm_educat", uniqueConstraints = @UniqueConstraint(columnNames = { "id", "educationCategoryName" }))
public class EducationCategory {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_EducationCategory")
	@SequenceGenerator(name = "id_EducationCategory", sequenceName = "ID_Educat")
	private int id;

	private String educationCategoryName;
	@OneToMany(targetEntity = Education.class)

	@JoinColumn(name = "education_category_id")
	private List<Education> educationList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEducationCategoryName() {
		return educationCategoryName;
	}

	public void setEducationCategoryName(String educationCategoryName) {
		this.educationCategoryName = educationCategoryName;
	}

	public EducationCategory(String educationCategoryName, Set<Education> education) {
		super();
		this.educationCategoryName = educationCategoryName;

	}

	public EducationCategory(int id, String educationCategoryName, Set<Education> education) {
		super();
		this.id = id;
		this.educationCategoryName = educationCategoryName;

	}

	public EducationCategory() {
		super();
	}

	public EducationCategory(String educationCategoryName) {
		super();
		this.educationCategoryName = educationCategoryName;
	}

	@Override
	public String toString() {
		return "EducationCategory [id=" + id + ", educationCategoryName="
				+ educationCategoryName + "]";
	}

}