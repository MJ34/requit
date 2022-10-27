package com.pk.recruiter.model;

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
@Table(name = "hrm_family", uniqueConstraints = @UniqueConstraint(columnNames = { "job_seeker_id", "idCard" }))
public class Family {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Family")
    @SequenceGenerator(name = "id_Family", sequenceName = "ID_Fam")
    private Integer id;
    private String statusHub;
    private String idCard;
    private String nameFam;
    private String lastEdu;
    private String profesi;
    private String companyName;
    private String telp;
    private String address;
    private String remark;

    @ManyToOne
    private JobSeeker jobSeeker;

    public String getIdCard() {
        return idCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getStatusHub() {
        return statusHub;
    }

    public void setStatusHub(final String statusHub) {
        this.statusHub = statusHub;
    }

    public void setIdCard(final String idCard) {
        this.idCard = idCard;
    }

    public String getNameFam() {
        return nameFam;
    }

    public void setNameFam(final String nameFam) {
        this.nameFam = nameFam;
    }

    public String getLastEdu() {
        return lastEdu;
    }

    public void setLastEdu(final String lastEdu) {
        this.lastEdu = lastEdu;
    }

    public String getProfesi() {
        return profesi;
    }

    public void setProfesi(final String profesi) {
        this.profesi = profesi;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(final String telp) {
        this.telp = telp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(final String remark) {
        this.remark = remark;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(final JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    @Override
    public String toString() {
        return "Family [address=" + address + ", companyName=" + companyName + ", remark=" + remark + ", id=" + id
                + ", idCard=" + idCard + ", lastEdu=" + lastEdu + ", nameFam=" + nameFam + ", profesi=" + profesi
                + ", statusHub=" + statusHub + ", telp=" + telp + "]";
    }

    public Family(String statusHub, String idCard, String nameFam, String lastEdu, String profesi, String companyName,
            String telp, String address, String remark) {
        super();
        this.statusHub = statusHub;
        this.idCard = idCard;
        this.nameFam = nameFam;
        this.lastEdu = lastEdu;
        this.profesi = profesi;
        this.companyName = companyName;
        this.telp = telp;
        this.address = address;
        this.remark = remark;
    }

    public Family() {
        super();
    }

}
