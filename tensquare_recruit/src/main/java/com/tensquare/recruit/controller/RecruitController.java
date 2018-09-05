package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Recruit;
import com.tensquare.recruit.service.RecruitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    /**
     * 查询全部招聘信息
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result<List> findAll() {
        return new Result<>(true, StatusCode.OK, "查询成功", recruitService.findAll());
    }

    /**
     * 根据ID查询招聘信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result<Recruit> findById(@PathVariable String id) {
        return new Result<>(true, StatusCode.OK, "查询成功", recruitService.findByID(id));
    }

    /**
     * 添加单个招聘信息
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Recruit recruit) {
        recruitService.add(recruit);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改招聘信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Result update(@RequestBody Recruit recruit, @PathVariable String id) {
        recruit.setId(id);
        recruitService.update(recruit);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除招聘信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id) {
        recruitService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 多条件组合查询
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result<List> findSearch(@RequestBody Map searchMap) {
        return new Result<>(true, StatusCode.OK, "查询成功", recruitService.findSearch(searchMap));
    }

    /**
     * 带分页的多条件组合查询
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result<PageResult> findSearch(@RequestBody Map SearchMap, @PathVariable int page, @PathVariable int size) {
        Page<Recruit> pageList = recruitService.findSearch(SearchMap, page, size);

        return new Result<>(true, StatusCode.OK, "查询成功",
                new PageResult<>(pageList.getTotalElements(), pageList.getContent()));
    }

}
