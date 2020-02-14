package com.as.occupationaldseases.domain.diseaseDevice;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("disease_device")
public class DiseaseDevice {

    @ApiModelProperty("体检项目id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("体检项目编码")
    @TableField("ITEM_CODE")
    private Integer itemCode;

    @ApiModelProperty("体检项目名称")
    @TableField("ITEM_NAME")
    private String itemName;

    @ApiModelProperty("单位")
    @TableField("RESULT_UNIT")
    private String resultUnit;

    @ApiModelProperty("下限")
    @TableField("VALUE_LOWER")
    private String valueLower;

    @ApiModelProperty("上限")
    @TableField("VALUE_UPPER")
    private String valueUpper;

    @ApiModelProperty("设备编码")
    @TableField("DEVICE_CODE")
    private Integer deviceCode;

    @ApiModelProperty("设备名称")
    @TableField("DEVICE_NAME")
    private String deviceName;

    @ApiModelProperty("机构编码")
    @TableField("ORGNO")
    private Integer orgno;

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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getResultUnit() {
        return resultUnit;
    }

    public void setResultUnit(String resultUnit) {
        this.resultUnit = resultUnit;
    }

    public String getValueLower() {
        return valueLower;
    }

    public void setValueLower(String valueLower) {
        this.valueLower = valueLower;
    }

    public String getValueUpper() {
        return valueUpper;
    }

    public void setValueUpper(String valueUpper) {
        this.valueUpper = valueUpper;
    }

    public Integer getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(Integer deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getOrgno() {
        return orgno;
    }

    public void setOrgno(Integer orgno) {
        this.orgno = orgno;
    }

    @Override
    public String toString() {
        return "DiseaseDevice{" +
                "id=" + id +
                ", itemCode=" + itemCode +
                ", itemName='" + itemName + '\'' +
                ", resultUnit='" + resultUnit + '\'' +
                ", valueLower='" + valueLower + '\'' +
                ", valueUpper='" + valueUpper + '\'' +
                ", deviceCode=" + deviceCode +
                ", deviceName='" + deviceName + '\'' +
                ", orgno=" + orgno +
                '}';
    }
}
