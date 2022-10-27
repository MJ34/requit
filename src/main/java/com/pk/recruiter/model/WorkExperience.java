package com.pk.recruiter.model;

import java.math.BigInteger;
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
@Table(name = "hrm_WorkExp", uniqueConstraints = @UniqueConstraint(columnNames = { "job_seeker_id", "name" }))
public class WorkExperience {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_WorkExperience")
    @SequenceGenerator(name = "id_WorkExperience", sequenceName = "ID_WorkExp")
    private Integer id;
    private String name;
    private String position;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateIn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOut;

    private String referenceName;
    private String phoneNumber;
    private BigInteger salary;

    private String remark;

    @ManyToOne
    private JobSeeker jobSeeker;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    @Override
    public String toString() {
        return "WorkExperience [dateIn=" + dateIn + ", dateOut=" + dateOut + ", id=" + id + ", name=" + name
                + ", phoneNumber=" + phoneNumber + ", position=" + position + ", referenceName=" + referenceName
                + ", remark=" + remark + ", salary=" + salary + "]";
    }

    public WorkExperience(String name, String position, Date dateIn, Date dateOut, String referenceName,
            String phoneNumber, BigInteger salary) {
        super();
        this.name = name;
        this.position = position;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.referenceName = referenceName;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public WorkExperience() {
        super();
    }

}
