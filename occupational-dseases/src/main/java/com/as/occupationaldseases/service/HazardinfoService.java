package com.as.occupationaldseases.service;

import com.as.occupationaldseases.common.response.CommonCode;
import com.as.occupationaldseases.common.response.QueryResponseResult;
import com.as.occupationaldseases.common.response.QueryResult;
import com.as.occupationaldseases.dao.HazardinfoMapper;
import com.as.occupationaldseases.domain.hazardinfo.Hazardinfo;
import com.as.occupationaldseases.domain.hazardinfo.responce.HazardinfoCode;
import com.as.occupationaldseases.domain.hazardinfo.responce.HazardinfoResult;
import com.as.occupationaldseases.exception.ExceptionCast;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HazardinfoService {

    @Resource
    private HazardinfoMapper hazardinfoMapper;

    //新增
    public HazardinfoResult add(Hazardinfo hazardinfo) {
        if (hazardinfo == null) {
            //抛出异常，非法参数异常..指定异常信息的内容
            return new HazardinfoResult(CommonCode.INVALID_PARAM, null);
        }
        //校验用户Id的唯一性
        //根据用户Id集合，如果查到说明此用户已经存在，如果查询不到再继续添加
        Hazardinfo hazardinfo1 = hazardinfoMapper.selectById(hazardinfo.getId());
        if (hazardinfo1 != null) {
            //用户已经存在
            //抛出异常，异常内容就是用户已经存在
            ExceptionCast.cast(HazardinfoCode.HAZARDINFO_ADD_EXISTSNAME);
        }

        //调用dao新增用户
        hazardinfoMapper.insert(hazardinfo);
        return new HazardinfoResult(CommonCode.SUCCESS, hazardinfo);

    }


    //根据id修改
    public HazardinfoResult update(int id, Hazardinfo hazardinfo) {
        //根据id从数据库查询页面信息
        Hazardinfo one = hazardinfoMapper.selectById(id);
        if (one != null) {
            //提交修改
            hazardinfoMapper.updateById(hazardinfo);
            return new HazardinfoResult(CommonCode.SUCCESS, hazardinfo);
        }
        //修改失败
        return new HazardinfoResult(HazardinfoCode.HAZARDINFO_NOTEXISTS, null);
    }


    //根据id删除
    public HazardinfoResult delete(int id) {
        //先查询一下
        Hazardinfo hazardinfo = hazardinfoMapper.selectById(id);
        if (hazardinfo != null) {
            hazardinfoMapper.deleteById(id);
            return new HazardinfoResult(CommonCode.SUCCESS, hazardinfo);
        }
        return new HazardinfoResult(HazardinfoCode.HAZARDINFO_NOTEXISTS, null);
    }


    /**
     * 分页查询方法
     *
     * @param current    页码，从1开始记数
     * @param size       每页记录数
     * @param hazardinfo 查询条件
     * @return
     */
    public QueryResponseResult findList(int current, int size, Hazardinfo hazardinfo) {
        if (hazardinfo == null) {
            hazardinfo = new Hazardinfo();
        }
        //分页参数
        if (current <= 0) {
            current = 1;
        }
        current = current - 1;

        if (size <= 0) {
            size = 10;
        }
        IPage<Hazardinfo> page = new Page<>(current, size);
        QueryWrapper<Hazardinfo> wrapper = new QueryWrapper<>();
        wrapper.setEntity(hazardinfo);

        IPage<Hazardinfo> companyinfoIPage = hazardinfoMapper.selectPage(page, wrapper);
        QueryResult queryResult = new QueryResult();

        queryResult.setList(companyinfoIPage.getRecords());//数据列表
        queryResult.setTotal(companyinfoIPage.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }


    //查询单条数据
    public HazardinfoResult findBySingle(Hazardinfo hazardinfo) {
        QueryWrapper<Hazardinfo> wrapper = new QueryWrapper<>();
        wrapper.setEntity(hazardinfo);
        Integer row = hazardinfoMapper.selectCount(wrapper);
        if (row == 1) {
            return new HazardinfoResult(CommonCode.SUCCESS, hazardinfoMapper.selectOne(wrapper));
        } else if (row > 1) {
            return new HazardinfoResult(HazardinfoCode.HAZARDINFO_GREATERTHAN, null);
        }
        return new HazardinfoResult(HazardinfoCode.HAZARDINFO_NOTEXISTS, null);
    }


    //根据条件查询数据条数
    public Integer count(Hazardinfo hazardinfo) {
        QueryWrapper<Hazardinfo> wrapper = new QueryWrapper<>();
        wrapper.setEntity(hazardinfo);
        return hazardinfoMapper.selectCount(wrapper);
    }

}
