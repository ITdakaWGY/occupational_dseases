package com.as.occupationaldseases.domain.inquiry_nk;

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
@TableName("inquiry_nk")
public class InquiryNk {
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("身份证")
    private String sfz;
    @ApiModelProperty("姓名")
    private String xm;
    @ApiModelProperty("体检日期")
    private Date tjrq;
    @ApiModelProperty("用户id")
    @TableField("personalid")
    private String personalid;
    @ApiModelProperty("条码号")
    private String tmh;
    @ApiModelProperty("体检标识")
    private String tjflag;
    @ApiModelProperty("胸廓(1、正常2、扁平胸3、桶状胸4、其他)")
    private String xk;
    @ApiModelProperty("胸廓其他")
    private String xkqt;
    @ApiModelProperty("胸廓备注")
    private String xkbz;
    @ApiModelProperty("心率次数")
    private String xlnumber;
    @ApiModelProperty("心率情况(1、齐2、不齐3、绝对不齐)")
    private String xlqk;
    @ApiModelProperty("杂音(1、无2、有)")
    private String zy;
    @ApiModelProperty("杂音描述")
    private String zyms;
    @ApiModelProperty("心脏备注")
    private String xzbz;
    @ApiModelProperty("呼吸音(1、正常2、异常)")
    private String hxy;
    @ApiModelProperty("呼吸音描述")
    private String hxyms;
    @ApiModelProperty("呼吸音备注")
    private String hxybz;
    @ApiModelProperty("罗音(1、无2、干罗音3、湿罗音4、其他)")
    private String ly;
    @ApiModelProperty("罗音描述")
    private String lyms;
    @ApiModelProperty("肺备注")
    private String fbz;
    @ApiModelProperty("压痛(1、无2、有)")
    private String yt;
    @ApiModelProperty("压痛描述")
    private String ytms;
    @ApiModelProperty("包块(1、无2、有)")
    private String bk;
    @ApiModelProperty("包块描述")
    private String bkms;
    @ApiModelProperty("肝大(1、无2、有)")
    private String gd;
    @ApiModelProperty("肝大描述")
    private String dams;
    @ApiModelProperty("脾大(1、无2、有)")
    private String pd;
    @ApiModelProperty("脾大描述")
    private String pdms;
    @ApiModelProperty("移动性浊音(1、无2、有)")
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
    @ApiModelProperty("创建时间")
    @TableField("createtime")
    private Date createtime;
    private String res1;
    private String res2;
    private String res3;
    private String res4;
    private String res5;

}

