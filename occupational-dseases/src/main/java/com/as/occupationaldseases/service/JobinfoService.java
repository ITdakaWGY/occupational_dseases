package com.as.occupationaldseases.service;

import com.as.occupationaldseases.common.response.CommonCode;
import com.as.occupationaldseases.common.response.QueryResponseResult;
import com.as.occupationaldseases.common.response.QueryResult;
import com.as.occupationaldseases.dao.JobinfoMapper;
import com.as.occupationaldseases.domain.jobinfo.Jobinfo;
import com.as.occupationaldseases.domain.jobinfo.responce.JobinfoCode;
import com.as.occupationaldseases.domain.jobinfo.responce.JobinfoResult;
import com.as.occupationaldseases.exception.ExceptionCast;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JobinfoService {
    @Resource
    private JobinfoMapper jobinfoMapper;

    //新增
    public JobinfoResult add(Jobinfo jobinfo) {
        if (jobinfo == null) {
            //抛出异常，非法参数异常..指定异常信息的内容
            return new JobinfoResult(CommonCode.INVALID_PARAM, null);
        }
        //校验用户Id的唯一性
        //根据用户Id集合，如果查到说明此用户已经存在，如果查询不到再继续添加
        Jobinfo jobinfo1 = jobinfoMapper.selectById(jobinfo.getId());
        if (jobinfo1 != null) {
            //用户已经存在
            //抛出异常，异常内容就是用户已经存在
            ExceptionCast.cast(JobinfoCode.JOBINFO_ADD_EXISTSNAME);
        }

        //调用dao新增用户
        jobinfoMapper.insert(jobinfo);
        return new JobinfoResult(CommonCode.SUCCESS, jobinfo);

    }


    //根据id修改
    public JobinfoResult update(int id, Jobinfo jobinfo) {
        //根据id从数据库查询页面信息
        Jobinfo one = jobinfoMapper.selectById(id);
        if (one != null) {
            //提交修改
            jobinfoMapper.updateById(jobinfo);
            return new JobinfoResult(CommonCode.SUCCESS, jobinfo);
        }
        //修改失败
        return new JobinfoResult(JobinfoCode.JOBINFO_NOTEXISTS, null);
    }


    //根据id删除
    public JobinfoResult delete(int id) {
        //先查询一下
        Jobinfo jobinfo = jobinfoMapper.selectById(id);
        if (jobinfo != null) {
            jobinfoMapper.deleteById(id);
            return new JobinfoResult(CommonCode.SUCCESS, jobinfo);
        }
        return new JobinfoResult(JobinfoCode.JOBINFO_NOTEXISTS, null);
    }


    /**
     * 分页查询方法
     *
     * @param current 页码，从1开始记数
     * @param size    每页记录数
     * @param jobinfo 查询条件
     * @return
     */
    public QueryResponseResult findList(int current, int size, Jobinfo jobinfo) {
        if (jobinfo == null) {
            jobinfo = new Jobinfo();
        }
        //分页参数
        if (current <= 0) {
            current = 1;
        }
//        current = current - 1;
        if (size <= 0) {
            size = 10;
        }
        IPage<Jobinfo> page = new Page<>(current, size);
        QueryWrapper<Jobinfo> wrapper = new QueryWrapper<>();
        wrapper.setEntity(jobinfo);

        IPage<Jobinfo> companyinfoIPage = jobinfoMapper.selectPage(page, wrapper);
        QueryResult queryResult = new QueryResult();

        queryResult.setList(companyinfoIPage.getRecords());//数据列表
        queryResult.setTotal(companyinfoIPage.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }


    //查询单条数据
    public JobinfoResult findBySingle(Jobinfo jobinfo) {
        QueryWrapper<Jobinfo> wrapper = new QueryWrapper<>();
        wrapper.setEntity(jobinfo);
        Integer row = jobinfoMapper.selectCount(wrapper);
        if (row == 1) {
            return new JobinfoResult(CommonCode.SUCCESS, jobinfoMapper.selectOne(wrapper));
        } else if (row > 1) {
            return new JobinfoResult(JobinfoCode.JOBINFO_GREATERTHAN, null);
        }
        return new JobinfoResult(JobinfoCode.JOBINFO_NOTEXISTS, null);
    }

    //根据条件查询条数
    public Integer count(Jobinfo jobinfo) {
        QueryWrapper<Jobinfo> wrapper = new QueryWrapper<>();
        wrapper.setEntity(jobinfo);
        return jobinfoMapper.selectCount(wrapper);
    }


}
