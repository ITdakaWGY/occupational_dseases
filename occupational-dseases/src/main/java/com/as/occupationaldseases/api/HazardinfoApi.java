package com.as.occupationaldseases.api;

import com.as.occupationaldseases.common.response.CommonCode;
import com.as.occupationaldseases.common.response.QueryResponseResult;
import com.as.occupationaldseases.common.response.QueryResult;
import com.as.occupationaldseases.domain.hazardinfo.Hazardinfo;
import com.as.occupationaldseases.domain.hazardinfo.responce.HazardinfoCode;
import com.as.occupationaldseases.domain.hazardinfo.responce.HazardinfoResult;
import com.as.occupationaldseases.exception.ExceptionCast;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

public interface HazardinfoApi {
    //新增
    @ApiOperation("新增")
    public HazardinfoResult add(Hazardinfo hazardinfo);


    //根据id修改
    @ApiOperation("根据id修改")
    public HazardinfoResult update(int id, Hazardinfo hazardinfo);


    //根据id删除
    @ApiOperation("根据id删除")
    public HazardinfoResult delete(int id);


    /**
     * 分页查询方法
     *
     * @param current    页码，从1开始记数
     * @param size       每页记录数
     * @param hazardinfo 查询条件
     * @return
     */
    //页面查询
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int")
    })
    public QueryResponseResult findList(int current, int size, Hazardinfo hazardinfo);


    //查询单条数据
    @ApiOperation("查询单条数据")
    public HazardinfoResult findBySingle(Hazardinfo hazardinfo);


    //根据条件查询数据条数
    @ApiOperation("根据条件查询条数")
    public Integer count(Hazardinfo hazardinfo);
}
