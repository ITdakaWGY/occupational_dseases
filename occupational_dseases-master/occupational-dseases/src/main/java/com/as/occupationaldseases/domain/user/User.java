package com.as.occupationaldseases.domain.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    @ApiModelProperty("用户id")
    private Long id;
    @ApiModelProperty("用户名称")
    private String name;
    @ApiModelProperty("用户年龄")
    private int age;
    @ApiModelProperty("用户邮箱")
    private String email;
    @ApiModelProperty("用户地址")
    private String addr;
    private String remark;
}
