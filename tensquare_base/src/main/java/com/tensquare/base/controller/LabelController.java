package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
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
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 查询全部标签
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result<List> findAll() {
        return new Result<>(true, StatusCode.OK, "查询成功", labelService.findAll());
    }

    /**
     * 根据ID查询标签
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result<Label> findById(@PathVariable String id) {
        return new Result<>(true, StatusCode.OK, "查询成功", labelService.findByID(id));
    }

    /**
     * 添加单个标签
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Label label) {
        labelService.add(label);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改标签
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Result update(@RequestBody Label label, @PathVariable String id) {
        label.setId(id);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除标签
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id) {
        labelService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 多条件组合查询
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result<List> findSearch(@RequestBody Map searchMap) {
        return new Result<>(true, StatusCode.OK, "查询成功", labelService.findSearch(searchMap));
    }

    /**
     * 带分页的多条件组合查询
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result<PageResult> findSearch(@RequestBody Map SearchMap, @PathVariable int page, @PathVariable int size) {
        Page<Label> pageList = labelService.findSearch(SearchMap, page, size);

        return new Result<>(true, StatusCode.OK, "查询成功",
                new PageResult<>(pageList.getTotalElements(), pageList.getContent()));
    }

}
