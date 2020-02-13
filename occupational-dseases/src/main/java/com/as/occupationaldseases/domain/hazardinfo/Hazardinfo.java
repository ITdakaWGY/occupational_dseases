package com.as.occupationaldseases.domain.hazardinfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("hazardinfo")
public class Hazardinfo {

    @ApiModelProperty("危险因素id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("危险因素名称")
    @TableField("hazard_name")
    private String hazardName;

    @ApiModelProperty("危险因素编号")
    @TableField("hazard_code")
    private String hazardCode;

    @ApiModelProperty("危险因素类型")
    @TableField("hazard_type")
    private String hazardType;

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

    public String getHazardName() {
        return hazardName;
    }

    public void setHazardName(String hazardName) {
        this.hazardName = hazardName;
    }

    public String getHazardCode() {
        return hazardCode;
    }

    public void setHazardCode(String hazardCode) {
        this.hazardCode = hazardCode;
    }

    public String getHazardType() {
        return hazardType;
    }

    public void setHazardType(String hazardType) {
        this.hazardType = hazardType;
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
        return "Hazardinfo{" +
                "id=" + id +
                ", hazardName='" + hazardName + '\'' +
                ", hazardCode='" + hazardCode + '\'' +
                ", hazardType='" + hazardType + '\'' +
                ", res1='" + res1 + '\'' +
                ", res2='" + res2 + '\'' +
                ", res3='" + res3 + '\'' +
                ", res4='" + res4 + '\'' +
                ", res5='" + res5 + '\'' +
                '}';
    }
}
