package com.as.occupationaldseases.service;

import com.as.occupationaldseases.common.response.CommonCode;
import com.as.occupationaldseases.common.response.QueryResponseResult;
import com.as.occupationaldseases.common.response.QueryResult;
import com.as.occupationaldseases.dao.DiseaseItemMapper;
import com.as.occupationaldseases.domain.diseaseItem.DiseaseItem;
import com.as.occupationaldseases.domain.diseaseItem.responce.DiseaseItemCode;
import com.as.occupationaldseases.domain.diseaseItem.responce.DiseaseItemResult;
import com.as.occupationaldseases.exception.ExceptionCast;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DiseaseItemService {

    @Resource
    private DiseaseItemMapper diseaseItemMapper;

    //新增
    public DiseaseItemResult add(DiseaseItem diseaseItem) {
        if(diseaseItem == null){
            //抛出异常，非法参数异常..指定异常信息的内容
            return new DiseaseItemResult(CommonCode.INVALID_PARAM,null);
        }
        //校验用户Id的唯一性
        //根据用户Id集合，如果查到说明此用户已经存在，如果查询不到再继续添加
        DiseaseItem diseaseItem1 = diseaseItemMapper.selectById(diseaseItem.getId());
        if(diseaseItem!=null){
            //用户已经存在
            //抛出异常，异常内容就是用户已经存在
            ExceptionCast.cast(DiseaseItemCode.DISEASEITEM_ADD_EXISTSNAME);
        }

        //调用dao新增用户
        diseaseItemMapper.insert(diseaseItem);
        return new DiseaseItemResult(CommonCode.SUCCESS,diseaseItem);

    }


    //根据id修改
    public DiseaseItemResult update(int id, DiseaseItem diseaseItem){
        //根据id从数据库查询页面信息
        DiseaseItem one = diseaseItemMapper.selectById(id);
        if(one!=null){
            //提交修改
            diseaseItemMapper.updateById(diseaseItem);
            return new DiseaseItemResult(CommonCode.SUCCESS,diseaseItem);
        }
        //修改失败
        return new DiseaseItemResult(DiseaseItemCode.DISEASEITEM_NOTEXISTS,null);
    }


    //根据id删除
    public DiseaseItemResult delete(int id){
        //先查询一下
        DiseaseItem diseaseItem = diseaseItemMapper.selectById(id);
        if (diseaseItem!=null){
            diseaseItemMapper.deleteById(id);
            return new DiseaseItemResult(CommonCode.SUCCESS,diseaseItem);
        }
        return new DiseaseItemResult(DiseaseItemCode.DISEASEITEM_NOTEXISTS,null);
    }


    /**
     * 分页查询方法
     * @param current 页码，从1开始记数
     * @param size 每页记录数
     * @param diseaseItem 查询条件
     * @return
     */
    public QueryResponseResult findList(int current, int size, DiseaseItem diseaseItem){
        if(diseaseItem == null){
            diseaseItem = new DiseaseItem();
        }
        //分页参数
        if(current <=0){
            current = 1;
        }
        current = current -1;

        if(size<=0){
            size = 10;
        }
        IPage<DiseaseItem> page = new Page<>(current, size);
        QueryWrapper<DiseaseItem> wrapper = new QueryWrapper<>();
        wrapper.setEntity(diseaseItem);

        IPage<DiseaseItem> companyinfoIPage = diseaseItemMapper.selectPage(page, wrapper);
        QueryResult queryResult = new QueryResult();

        queryResult.setList(companyinfoIPage.getRecords());//数据列表
        queryResult.setTotal(companyinfoIPage.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }


    //查询单条数据
    public DiseaseItemResult findBySingle(DiseaseItem diseaseItem){
        QueryWrapper<DiseaseItem> wrapper = new QueryWrapper<>();
        wrapper.setEntity(diseaseItem);
        Integer row = diseaseItemMapper.selectCount(wrapper);
        if(row == 1){
            return new DiseaseItemResult(CommonCode.SUCCESS,diseaseItemMapper.selectOne(wrapper));
        }else if(row > 1){
            return new DiseaseItemResult(DiseaseItemCode.DISEASEITEM_GREATERTHAN,null);
        }
        return new DiseaseItemResult(DiseaseItemCode.DISEASEITEM_NOTEXISTS,null);
    }



    //根据条件查询数据条数
    public Integer count(DiseaseItem diseaseItem){
        QueryWrapper<DiseaseItem> wrapper = new QueryWrapper<>();
        wrapper.setEntity(diseaseItem);
        return diseaseItemMapper.selectCount(wrapper);
    }
}
