package com.as.occupationaldseases.service;

import com.as.occupationaldseases.common.response.CommonCode;
import com.as.occupationaldseases.common.response.QueryResponseResult;
import com.as.occupationaldseases.common.response.QueryResult;
import com.as.occupationaldseases.dao.CompanyinfoMapper;
import com.as.occupationaldseases.domain.companyinfo.Companyinfo;
import com.as.occupationaldseases.domain.companyinfo.responce.CompanyinfoCode;
import com.as.occupationaldseases.domain.companyinfo.responce.CompanyinfoResult;
import com.as.occupationaldseases.exception.ExceptionCast;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyinfoService {

    @Resource
    private CompanyinfoMapper companyinfoMapper;


    //新增
    public CompanyinfoResult add(Companyinfo companyinfo) {
        if(companyinfo == null){
            //抛出异常，非法参数异常..指定异常信息的内容
            return new CompanyinfoResult(CommonCode.INVALID_PARAM,null);
        }
        //校验用户Id的唯一性
        //根据用户Id集合，如果查到说明此用户已经存在，如果查询不到再继续添加
        Companyinfo companyinfo1 = companyinfoMapper.selectById(companyinfo.getId());
        if(companyinfo1!=null){
            //用户已经存在
            //抛出异常，异常内容就是用户已经存在
            ExceptionCast.cast(CompanyinfoCode.COMPANYINFO_ADD_EXISTSNAME);
        }
        Integer row = companyinfoMapper.maxCode();
        companyinfo.setCompanycode(String.valueOf(row+1));

        //调用dao新增用户
        companyinfoMapper.insert(companyinfo);
        return new CompanyinfoResult(CommonCode.SUCCESS,companyinfo);

    }


    //根据id修改
    public CompanyinfoResult update(int id, Companyinfo companyinfo){
        //根据id从数据库查询页面信息
        Companyinfo one = companyinfoMapper.selectById(id);
        if(one!=null){
            //提交修改
            companyinfoMapper.updateById(companyinfo);
            return new CompanyinfoResult(CommonCode.SUCCESS,companyinfo);
        }
        //修改失败
        return new CompanyinfoResult(CompanyinfoCode.COMPANYINFO_NOTEXISTS,null);
    }


    //根据id删除
    public CompanyinfoResult delete(int id){
        //先查询一下
        Companyinfo companyinfo = companyinfoMapper.selectById(id);
        if (companyinfo!=null){
            companyinfoMapper.deleteById(id);
            return new CompanyinfoResult(CommonCode.SUCCESS,companyinfo);
        }
        return new CompanyinfoResult(CompanyinfoCode.COMPANYINFO_NOTEXISTS,null);
    }


    /**
     * 分页查询方法
     * @param current 页码，从1开始记数
     * @param size 每页记录数
     * @param companyinfo 查询条件
     * @return
     */
    public QueryResponseResult findList(int current, int size, Companyinfo companyinfo){
        if(companyinfo == null){
            companyinfo = new Companyinfo();
        }
        //分页参数
        if(current <=0){
            current = 1;
        }
        current = current -1;

        if(size<=0){
            size = 10;
        }
        IPage<Companyinfo> page = new Page<>(current, size);
        QueryWrapper<Companyinfo> wrapper = new QueryWrapper<>();
        wrapper.setEntity(companyinfo);

        IPage<Companyinfo> companyinfoIPage = companyinfoMapper.selectPage(page, wrapper);
        QueryResult queryResult = new QueryResult();

        queryResult.setList(companyinfoIPage.getRecords());//数据列表
        queryResult.setTotal(companyinfoIPage.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }


    //查询单条数据
    public CompanyinfoResult findBySingle(Companyinfo companyinfo){
        QueryWrapper<Companyinfo> wrapper = new QueryWrapper<>();
        wrapper.setEntity(companyinfo);
        Integer row = companyinfoMapper.selectCount(wrapper);
        if(row == 1){
            return new CompanyinfoResult(CommonCode.SUCCESS,companyinfoMapper.selectOne(wrapper));
        }else if(row > 1){
            return new CompanyinfoResult(CompanyinfoCode.COMPANYINFO_GREATERTHAN,null);
        }
        return new CompanyinfoResult(CompanyinfoCode.COMPANYINFO_NOTEXISTS,null);
    }



    //根据条件查询数据条数
    public Integer count(Companyinfo companyinfo){
        QueryWrapper<Companyinfo> wrapper = new QueryWrapper<>();
        wrapper.setEntity(companyinfo);
        return companyinfoMapper.selectCount(wrapper);
    }



}
