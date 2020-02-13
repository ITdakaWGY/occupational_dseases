package com.as.occupationaldseases.domain.jobinfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("jobinfo")
public class Jobinfo {

    @ApiModelProperty("职工岗位信息表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("企业名称")
    private String companyname;

    @ApiModelProperty("岗位编号")
    private String jobcode;

    @ApiModelProperty("岗位名称")
    private String jobname;

    @ApiModelProperty("用人单位编号")
    private String companycode;

    @ApiModelProperty("res1")
    private String res1;

    @ApiModelProperty("res2")
    private String res2;

    @ApiModelProperty("res3")
    private String res3;

    @ApiModelProperty("res4")
    private String res4;

    @ApiModelProperty("res5")
    private String res5;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getJobcode() {
        return jobcode;
    }

    public void setJobcode(String jobcode) {
        this.jobcode = jobcode;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getRes1() {
        return res1;
    }

    public void setRes1(String res1) {
        this.res1 = res1;
    }

    public String getRes2() {
        return res2;
    }

    public void setRes2(String res2) {
        this.res2 = res2;
    }

    public String getRes3() {
        return res3;
    }

    public void setRes3(String res3) {
        this.res3 = res3;
    }

    public String getRes4() {
        return res4;
    }

    public void setRes4(String res4) {
        this.res4 = res4;
    }

    public String getRes5() {
        return res5;
    }

    public void setRes5(String res5) {
        this.res5 = res5;
    }

    @Override
    public String toString() {
        return "Jobinfo{" +
                "id=" + id +
                ", companyname='" + companyname + '\'' +
                ", jobcode='" + jobcode + '\'' +
                ", jobname='" + jobname + '\'' +
                ", companycode='" + companycode + '\'' +
                ", res1='" + res1 + '\'' +
                ", res2='" + res2 + '\'' +
                ", res3='" + res3 + '\'' +
                ", res4='" + res4 + '\'' +
                ", res5='" + res5 + '\'' +
                '}';
    }
}
