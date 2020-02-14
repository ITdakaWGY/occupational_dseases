package com.as.occupationaldseases.controller;

import com.as.occupationaldseases.api.CompanyinfoApi;
import com.as.occupationaldseases.common.response.QueryResponseResult;
import com.as.occupationaldseases.domain.companyinfo.Companyinfo;
import com.as.occupationaldseases.domain.companyinfo.responce.CompanyinfoResult;
import com.as.occupationaldseases.service.CompanyinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companyinfo")
public class CompanyinfoController implements CompanyinfoApi {
    @Autowired
    private CompanyinfoService companyinfoService;

    @Override
    @PostMapping("/add")
    public CompanyinfoResult add(@RequestBody Companyinfo companyinfo) {

        return companyinfoService.add(companyinfo);
    }

    @Override
    @PutMapping("/update/{id}")//这里使用put方法，http 方法中put表示更新
    public CompanyinfoResult update(@PathVariable("id") int id, @RequestBody Companyinfo companyinfo) {
        return companyinfoService.update(id, companyinfo);
    }

    @Override
    @DeleteMapping("/del/{id}")
    public CompanyinfoResult delete(@PathVariable("id") int id) {
        return companyinfoService.delete(id);
    }

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Companyinfo companyinfo) {
        return companyinfoService.findList(page, size, companyinfo);
    }

    @Override
    @GetMapping("/findBySingle")
    public CompanyinfoResult findBySingle(@RequestBody Companyinfo companyinfo) {
        return companyinfoService.findBySingle(companyinfo);
    }

    @Override
    @GetMapping("/count")
    public Integer count(@RequestBody Companyinfo companyinfo) {
        return companyinfoService.count(companyinfo);
    }
}
