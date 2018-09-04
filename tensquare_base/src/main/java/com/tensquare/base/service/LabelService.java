package com.tensquare.base.service;

import com.tensquare.base.pojo.Label;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface LabelService {
    // 查询全部标签
    List<Label> findAll();

    // 根据ID查询标签
    Label findByID(String id);

    // 添加标签
    void add(Label label);

    // 修改标签
    void update(Label label);

    // 根据ID删除标签
    void deleteById(String id);

    // 多条件查询
    List<Label> findSearch(Map searchMap);

    // 多条件分页查询
    Page<Label> findSearch(Map searchMap, int page, int size);
}
