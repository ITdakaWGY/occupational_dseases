package com.as.occupationaldseases.controller;

import com.as.occupationaldseases.api.HazardinfoApi;
import com.as.occupationaldseases.common.response.QueryResponseResult;
import com.as.occupationaldseases.domain.hazardinfo.Hazardinfo;
import com.as.occupationaldseases.domain.hazardinfo.responce.HazardinfoResult;
import com.as.occupationaldseases.service.HazardinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class HazardinfoContorller implements HazardinfoApi {
    @Autowired
    private HazardinfoService hazardinfoService;

    @Override
    @PostMapping("/add")
    public HazardinfoResult add(@RequestBody Hazardinfo hazardinfo) {
        return hazardinfoService.add(hazardinfo);
    }

    @Override
    @PutMapping("/update/{id}")//这里使用put方法，http 方法中put表示更新
    public HazardinfoResult update(@PathVariable("id")int id, @RequestBody Hazardinfo hazardinfo) {
        return hazardinfoService.update(id,hazardinfo);
    }

    @Override
    @DeleteMapping("/del/{id}")
    public HazardinfoResult delete(@PathVariable("id")int id) {
        return hazardinfoService.delete(id);
    }

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page,@PathVariable("size") int size,@RequestBody Hazardinfo hazardinfo) {
        return hazardinfoService.findList(page,size,hazardinfo);
    }

    @Override
    @GetMapping("/findBySingle")
    public HazardinfoResult findBySingle(@RequestBody Hazardinfo hazardinfo) {
        return hazardinfoService.findBySingle(hazardinfo);
    }

    @Override
    @GetMapping("/count")
    public Integer count(@RequestBody Hazardinfo hazardinfo) {
        return hazardinfoService.count(hazardinfo);
    }
}
