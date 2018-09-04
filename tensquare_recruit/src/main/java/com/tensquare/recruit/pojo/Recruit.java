package com.tensquare.recruit.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_recruit")
public class Recruit {

    @Id
    private String id;

    // 招聘职位
    private String jobname;

    // 薪资范围
    private String salary;

    // 经验要求
    private String condition;

    // 学历要求
    private String education;

    // 任职方式
    private String type;

    // 办公地址
    private String address;

    // 发布日期
    private Date createtime;

    // 状态
    private String state;

    // 原网址
    private String url;

    // 标签
    private String label;

    // 职位描述
    private String content1;

    // 职位要求
    private String content2;

    // 企业ID
    private Enterprise eid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public Enterprise getEid() {
        return eid;
    }

    public void setEid(Enterprise eid) {
        this.eid = eid;
    }

    public Recruit() {
    }

    public Recruit(String id, String jobname, String salary, String condition, String education, String type, String address,
                    Date createtime, String state, String url, String label, String content1, String content2, Enterprise eid) {
        this.id = id;
        this.jobname = jobname;
        this.salary = salary;
        this.condition = condition;
        this.education = education;
        this.type = type;
        this.address = address;
        this.createtime = createtime;
        this.state = state;
        this.url = url;
        this.label = label;
        this.content1 = content1;
        this.content2 = content2;
        this.eid = eid;
    }
}
