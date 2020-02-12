package com.as.occupationaldseases.domain.inquiry_wgk;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("inquiry_wgk")
public class InquiryWgk {
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("用户id")
    private String personalid;
    @ApiModelProperty("条码号")
    private String tmh;
    @ApiModelProperty("左眼视力")
    private String zysl;
    @ApiModelProperty("有眼视力")
    private String yysl;
    @ApiModelProperty("左眼矫正视力")
    private String zyjzsl;
    @ApiModelProperty("右眼矫正视力")
    private String yyjzsl;
    @ApiModelProperty("视力备注")
    private String slbz;
    @ApiModelProperty("外眼")
    private String wy;
    @ApiModelProperty("外眼描述")
    private String wyms;
    @ApiModelProperty("外眼备注")
    private String wybz;
    @ApiModelProperty("晶体")
    private String jt;
    @ApiModelProperty("晶体描述")
    private String jtms;
    @ApiModelProperty("晶体备注")
    private String jtbz;
    @ApiModelProperty("神经乳头")
    private String sjrt;
    @ApiModelProperty("神经乳头描述")
    private String sjrtms;
    @ApiModelProperty("视网膜血管")
    private String swmxg;
    @ApiModelProperty("视网膜血管描述")
    private String swmxgms;
    @ApiModelProperty("黄斑区")
    private String hbq;
    @ApiModelProperty("黄斑区描述")
    private String hbqms;
    @ApiModelProperty("眼底备注")
    private String ydbz;
    @ApiModelProperty("耳廓")
    private String ek;
    @ApiModelProperty("耳廓描述")
    private String ekms;
    @ApiModelProperty("外耳道")
    private String wed;
    @ApiModelProperty("外耳道描述")
    private String wedms;
    @ApiModelProperty("外耳备注")
    private String webz;
    @ApiModelProperty("左耳听力")
    private String ztl;
    @ApiModelProperty("右耳听力")
    private String ytl;
    @ApiModelProperty("听力备注")
    private String tlbz;
    @ApiModelProperty("鼻外形")
    private String bwx;
    @ApiModelProperty("外形描述")
    private String bwxms;
    @ApiModelProperty("鼻中隔")
    private String bzg;
    @ApiModelProperty("鼻中隔描述")
    private String bzgms;
    @ApiModelProperty("鼻腔粘膜")
    private String bqnm;
    @ApiModelProperty("鼻腔粘膜描述")
    private String bqnmms;
    @ApiModelProperty("鼻窦区压痛")
    private String bdqyt;
    @ApiModelProperty("鼻窦区压痛描述")
    private String bdqytms;
    @ApiModelProperty("鼻备注")
    private String bbz;
    @ApiModelProperty("口唇")
    private String kc;
    @ApiModelProperty(" ")
    private String cl;
    @ApiModelProperty("口腔咽部")
    private String kqyb;
    @ApiModelProperty("口腔备注")
    private String kqbz;
    @ApiModelProperty("咽喉咽部")
    private String yhyb;
    @ApiModelProperty("咽喉咽部描述")
    private String yhybms;
    @ApiModelProperty("扁桃体")
    private String btt;
    @ApiModelProperty("扁桃体描述")
    private String bttms;
    @ApiModelProperty("口咽部")
    private String kyb;
    @ApiModelProperty("口咽部描述")
    private String kybms;
    @ApiModelProperty(" ")
    private String yhbz;
    @ApiModelProperty(" ")
    private String ysqz;
    @ApiModelProperty(" ")
    private String ysqzurl;
    private String res1;
    private String res2;
    private String res3;
    private String res4;
    private String res5;

}

