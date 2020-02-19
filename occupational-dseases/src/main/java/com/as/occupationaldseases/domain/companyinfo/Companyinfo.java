package com.as.occupationaldseases.domain.companyinfo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@TableName("companyinfo")
public class Companyinfo {
    @ApiModelProperty("用人单位信息表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("单位、公司名称")
    private String companyname;
    @ApiModelProperty("联系人")
    private String linkman;
    @ApiModelProperty("联系电话")
    private String phone;
    @ApiModelProperty("所在地、地址")
    private String address;
    @ApiModelProperty("员工总数")
    private String staffnumber;
    @ApiModelProperty("公司编号")
    private String companycode;
    @ApiModelProperty("企业规模(大中小微)")
    private String companytype;
    @ApiModelProperty("行业类型")
    private String Industrypaging;
    @ApiModelProperty("法人")
    private String legalperson;
    @ApiModelProperty("负责人")
    private String principal;
    @ApiModelProperty("风险分类")
    private String risktype;
    @ApiModelProperty("危害人数")
    private String harmperson;
    @ApiModelProperty("危害种类")
    private String harmtype;
    @ApiModelProperty("职业病危害检测报告类型")
    private String harmevaluatetype;
    @ApiModelProperty("检测报告名称以及编号")
    private String harmevaluatenamecode;
    @ApiModelProperty("服务机构名称")
    private String orgname;
    @ApiModelProperty("服务机构编号")
    private String orgcode;
    @ApiModelProperty("创建时间")
    private Date createtime;
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
    @ApiModelProperty("职业病危害因素种类其他描述")
    private String harmtypeqt;

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

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStaffnumber() {
        return staffnumber;
    }

    public void setStaffnumber(String staffnumber) {
        this.staffnumber = staffnumber;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getCompanytype() {
        return companytype;
    }

    public void setCompanytype(String companytype) {
        this.companytype = companytype;
    }

    public String getLegalperson() {
        return legalperson;
    }

    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getRisktype() {
        return risktype;
    }

    public void setRisktype(String risktype) {
        this.risktype = risktype;
    }

    public String getHarmperson() {
        return harmperson;
    }

    public void setHarmperson(String harmperson) {
        this.harmperson = harmperson;
    }

    public String getHarmtype() {
        return harmtype;
    }

    public void setHarmtype(String harmtype) {
        this.harmtype = harmtype;
    }

    public String getHarmevaluatetype() {
        return harmevaluatetype;
    }

    public void setHarmevaluatetype(String harmevaluatetype) {
        this.harmevaluatetype = harmevaluatetype;
    }

    public String getHarmevaluatenamecode() {
        return harmevaluatenamecode;
    }

    public void setHarmevaluatenamecode(String harmevaluatenamecode) {
        this.harmevaluatenamecode = harmevaluatenamecode;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public String getIndustrypaging() {
        return Industrypaging;
    }

    public void setIndustrypaging(String industrypaging) {
        Industrypaging = industrypaging;
    }

    public String getHarmtypeqt() {
        return harmtypeqt;
    }

    public void setHarmtypeqt(String harmtypeqt) {
        this.harmtypeqt = harmtypeqt;
    }

    @Override
    public String toString() {
        return "Companyinfo{" +
                "id=" + id +
                ", companyname='" + companyname + '\'' +
                ", linkman='" + linkman + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", staffnumber='" + staffnumber + '\'' +
                ", companycode='" + companycode + '\'' +
                ", companytype='" + companytype + '\'' +
                ", Industrypaging='" + Industrypaging + '\'' +
                ", legalperson='" + legalperson + '\'' +
                ", principal='" + principal + '\'' +
                ", risktype='" + risktype + '\'' +
                ", harmperson='" + harmperson + '\'' +
                ", harmtype='" + harmtype + '\'' +
                ", harmevaluatetype='" + harmevaluatetype + '\'' +
                ", harmevaluatenamecode='" + harmevaluatenamecode + '\'' +
                ", orgname='" + orgname + '\'' +
                ", orgcode='" + orgcode + '\'' +
                ", createtime=" + createtime +
                ", res1='" + res1 + '\'' +
                ", res2='" + res2 + '\'' +
                ", res3='" + res3 + '\'' +
                ", res4='" + res4 + '\'' +
                ", res5='" + res5 + '\'' +
                ", harmtypeqt='" + harmtypeqt + '\'' +
                '}';
    }
}
