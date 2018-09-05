package com.tensquare.recruit.service;

import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface RecruitService {
    // 查询全部招聘信息
    List<Recruit> findAll();

    // 根据ID查询招聘信息
    Recruit findByID(String id);

    // 添加招聘信息
    void add(Recruit recruit);

    // 修改招聘信息
    void update(Recruit recruit);

    // 根据ID删除招聘信息
    void deleteById(String id);

    // 多条件查询
    List<Recruit> findSearch(Map searchMap);

    // 多条件分页查询
    Page<Recruit> findSearch(Map searchMap, int page, int size);
}
