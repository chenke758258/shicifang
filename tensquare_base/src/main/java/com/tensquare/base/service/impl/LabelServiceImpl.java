package com.tensquare.base.service.impl;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
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
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    @Override
    public Label findByID(String id) {
        return labelDao.findById(id).get();
    }

    @Override
    public void add(Label label) {
        label.setId(String.valueOf(idWorker.nextId()));
        labelDao.save(label);
    }

    @Override
    public void update(Label label) {
        labelDao.save(label);
    }

    @Override
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    @Override
    public List<Label> findSearch(Map searchMap) {
        Specification<Label> specification = createSpecification(searchMap);
        return labelDao.findAll(specification);
    }

    @Override
    public Page<Label> findSearch(Map searchMap, int page, int size) {
        Specification<Label> specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return labelDao.findAll(specification, pageRequest);
    }

    // 构造查询条件
    private Specification<Label> createSpecification(Map searchMap) {
        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

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
