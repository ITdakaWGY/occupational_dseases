package com.as.occupationaldseases.domain.inquiry_sjk;

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
@TableName("inquiry_sjk")
public class InquirySjk {
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("用户id")
    private String personalid;
    @ApiModelProperty("条码号")
    private String tmh;
    @ApiModelProperty("体检标识")
    private String tjflag;
    @ApiModelProperty("肌萎缩")
    private String jws;
    @ApiModelProperty("肌萎缩描述")
    private String jwsms;
    @ApiModelProperty("肌萎缩备注")
    private String jwsbz;
    @ApiModelProperty("肌力")
    private String jl;
    @ApiModelProperty("肌力描述")
    private String jlms;
    @ApiModelProperty("肌力备注")
    private String jlbz;
    @ApiModelProperty("三颤")
    private String sc;
    @ApiModelProperty("三颤描述")
    private String scms;
    @ApiModelProperty("三颤备注")
    private String scbz;
    @ApiModelProperty("共济运动")
    private String gjyd;
    @ApiModelProperty("共济运动描述")
    private String gjydms;
    @ApiModelProperty("共济运动备注")
    private String gjydbz;
    @ApiModelProperty("痛觉")
    private String tj;
    @ApiModelProperty("痛觉描述")
    private String tjms;
    @ApiModelProperty("触觉")
    private String cj;
    @ApiModelProperty("触觉描述")
    private String cjms;
    @ApiModelProperty("浅感觉备注")
    private String qgnbz;
    @ApiModelProperty("腱反射")
    private String jfs;
    @ApiModelProperty("腱反射备注")
    private String jfsbz;
    @ApiModelProperty("病理反射")
    private String blfs;
    @ApiModelProperty("病理反射备注")
    private String blfsbz;
    @ApiModelProperty("自主神经")
    private String zzsj;
    @ApiModelProperty("自主神经备注")
    private String zzsjbz;
    @ApiModelProperty("医师签字")
    private String ysqz;
    @ApiModelProperty("医师签字URL")
    private String ysqzul;
    @ApiModelProperty("创建时间")
    @TableField("createtime")
    private Date createtime;
    private String res1;
    private String res2;
    private String res3;
    private String res4;
    private String res5;

}

