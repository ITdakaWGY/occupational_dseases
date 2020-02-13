package com.as.occupationaldseases.domain.diseaseItem;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@TableName("disease_item")
public class DiseaseItem {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("体检项目编码")
    @TableField("ITEM_CODE")
    private Integer itemCode;

    @ApiModelProperty("体检项目id")
    @TableField("device_id")
    private Integer deviceId;

    @ApiModelProperty("体检项目名称")
    @TableField("iteam_name")
    private String iteamName;

    @ApiModelProperty("机构编号")
    @TableField("orgcode")
    private String orgcode;

    @ApiModelProperty("机构名称")
    @TableField("orgname")
    private String orgname;


    @ApiModelProperty("创建时间")
    private Date createtime;


    @ApiModelProperty("res1")
    @TableField("res1")
    private String res1;

    @ApiModelProperty("res2")
    @TableField("res2")
    private String res2;

    @ApiModelProperty("res3")
    @TableField("res3")
    private String res3;


    @ApiModelProperty("res4")
    @TableField("res4")
    private String res4;

    @ApiModelProperty("res5")
    @TableField("res5")
    private String res5;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getIteamName() {
        return iteamName;
    }

    public void setIteamName(String iteamName) {
        this.iteamName = iteamName;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
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

    @Override
    public String toString() {
        return "DiseaseItem{" +
                "id=" + id +
                ", itemCode=" + itemCode +
                ", deviceId=" + deviceId +
                ", iteamName='" + iteamName + '\'' +
                ", orgcode='" + orgcode + '\'' +
                ", orgname='" + orgname + '\'' +
                ", createtime=" + createtime +
                ", res1='" + res1 + '\'' +
                ", res2='" + res2 + '\'' +
                ", res3='" + res3 + '\'' +
                ", res4='" + res4 + '\'' +
                ", res5='" + res5 + '\'' +
                '}';
    }
}
