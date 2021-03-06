package com.as.occupationaldseases.api;

import com.as.occupationaldseases.common.response.QueryResponseResult;
import com.as.occupationaldseases.domain.companyinfo.Companyinfo;
import com.as.occupationaldseases.domain.companyinfo.responce.CompanyinfoResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

public interface CompanyinfoApi {
    //新增用户
    @ApiOperation("新增用人单位")
    public CompanyinfoResult add(Companyinfo companyinfo);

    @ApiOperation("根据id修改")
    public CompanyinfoResult update(int id, Companyinfo companyinfo);

    @ApiOperation("根据id删除")
    public CompanyinfoResult delete(int id);

    //页面查询
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int")
    })
    public QueryResponseResult findList(int current, int size, Companyinfo companyinfo);

    @ApiOperation("查询单条数据")
    public CompanyinfoResult findBySingle(Companyinfo companyinfo);

    @ApiOperation("根据条件查询条数")
    public Integer count(Companyinfo companyinfo);


}
