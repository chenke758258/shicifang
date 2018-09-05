package com.tensquare.recruit.service.impl;

import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.pojo.Recruit;
import com.tensquare.recruit.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public List<Recruit> findAll() {
        return recruitDao.findAll();
    }

    @Override
    public Recruit findByID(String id) {
        return recruitDao.findById(id).get();
    }

    @Override
    public void add(Recruit recruit) {
        recruit.setId(String.valueOf(idWorker.nextId()));
        recruitDao.save(recruit);
    }

    @Override
    public void update(Recruit recruit) {
        recruitDao.save(recruit);
    }

    @Override
    public void deleteById(String id) {
        recruitDao.deleteById(id);
    }

    @Override
    public List<Recruit> findSearch(Map searchMap) {
        Specification<Recruit> specification = createSpecification(searchMap);
        return recruitDao.findAll(specification);
    }

    @Override
    public Page<Recruit> findSearch(Map searchMap, int page, int size) {
        Specification<Recruit> specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(page, size);
        return recruitDao.findAll(specification, pageRequest);
    }

    // 构造查询条件
    private Specification<Recruit> createSpecification(Map searchMap) {
        return new Specification<Recruit>() {
            @Override
            public Predicate toPredicate(Root<Recruit> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicateList = new ArrayList<>();

                // 添加查询条件 labelname
                Object labelname = searchMap.get("labelname");
                if (labelname != null && !"".equals(labelname)) {
                    predicateList.add(criteriaBuilder.like(root.get("labelname").as(String.class), "%" + (String)labelname + "%"));
                }

                // 添加查询条件 state
                Object state = searchMap.get("state");
                if (state != null && !"".equals(state)) {
                    predicateList.add(criteriaBuilder.like(root.get("state").as(String.class), "%" + (String)state + "%"));
                }
                // 添加查询条件 recommend
                Object recommend = searchMap.get("recommend");
                if (recommend != null && !"".equals(recommend)) {
                    predicateList.add(criteriaBuilder.like(root.get("recommend").as(String.class), "%" + (String)recommend + "%"));
                }

                // 返回查询条件
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }
}
