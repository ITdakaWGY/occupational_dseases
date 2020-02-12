package com.as.occupationaldseases.domain.inquiry_wk;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("inquiry_wk")
public class InquiryWk {
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("用户id")
    private String personalid;
    @ApiModelProperty("条码号")
    private String tmh;
    @ApiModelProperty("甲状腺")
    private String jzx;
    @ApiModelProperty("甲状腺描述")
    private String jzxms;
    @ApiModelProperty("甲状腺备注")
    private String jxzbz;
    @ApiModelProperty("浅表淋巴结")
    private String qblbj;
    @ApiModelProperty("浅表淋巴结描述")
    private String qblbjms;
    @ApiModelProperty("浅表淋巴结备注")
    private String qblbjbz;
    @ApiModelProperty("其他")
    private String qt;
    @ApiModelProperty("医师签字")
    private String ysqz;
    @ApiModelProperty(" ")
    private String ysqzurl;
    private String res1;
    private String res2;
    private String res3;
    private String res4;
    private String res5;

}

