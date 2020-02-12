package com.as.occupationaldseases.domain.inquiry_nk;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("inquiry_nk")
public class InquiryNk {
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("用户id")
    @TableField("personalid")
    private String personalid;
    @ApiModelProperty("条码号")
    private String tmh;
    @ApiModelProperty("胸廓")
    private String xk;
    @ApiModelProperty("胸廓其他")
    private String xkqt;
    @ApiModelProperty("胸廓备注")
    private String xkbz;
    @ApiModelProperty("心率次数")
    private String xlnumber;
    @ApiModelProperty("心率情况")
    private String xlqk;
    @ApiModelProperty("杂音")
    private String zy;
    @ApiModelProperty("杂音描述")
    private String zyms;
    @ApiModelProperty("心脏备注")
    private String xzbz;
    @ApiModelProperty("呼吸音")
    private String hxy;
    @ApiModelProperty("呼吸音描述")
    private String hxyms;
    @ApiModelProperty("罗音")
    private String ly;
    @ApiModelProperty("罗音描述")
    private String lyms;
    @ApiModelProperty("肺备注")
    private String fbz;
    @ApiModelProperty("压痛")
    private String yt;
    @ApiModelProperty("压痛描述")
    private String ytms;
    @ApiModelProperty("包块")
    private String bk;
    @ApiModelProperty("包块描述")
    private String bkms;
    @ApiModelProperty("肝大")
    private String gd;
    @ApiModelProperty("肝大描述")
    private String dams;
    @ApiModelProperty("脾大")
    private String pd;
    @ApiModelProperty("脾大描述")
    private String pdms;
    @ApiModelProperty("移动性浊音")
    private String ydxzy;
    @ApiModelProperty("浊音描述")
    private String ydxzyms;
    @ApiModelProperty("腹部备注")
    private String fbbz;
    @ApiModelProperty("其他")
    private String qt;
    @ApiModelProperty("医师签字")
    private String ysqz;
    @ApiModelProperty("医师签字URL")
    private String ysqzurl;
    private String res1;
    private String res2;
    private String res3;
    private String res4;
    private String res5;

}

