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
@Table(name = "hrm_org", uniqueConstraints = @UniqueConstraint(columnNames = { "job_seeker_id", "name" }))
public class Organization {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Organization")
    @SequenceGenerator(name = "id_Organization", sequenceName = "ID_Org")
    private Integer id;
    private String name;
    private String position;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateIn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOut;

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
        return "Organization [dateIn=" + dateIn + ", dateOut=" + dateOut + ", remark=" + remark + ", id=" + id
                + ", name=" + name + ", position=" + position + "]";
    }

    public Organization(String name, String position, Date dateIn, Date dateOut, String remark) {
        super();
        this.name = name;
        this.position = position;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.remark = remark;
    }

    public Organization() {
        super();
    }

}
