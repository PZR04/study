package com.pzr.service.impl;

import com.pzr.mapper.DeptMapper;

import com.pzr.pojo.Dept;
import com.pzr.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);

    }


    @Override
    public void add(Dept dept) {
        //补全基础属性 - 创建时间、更新时间
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //调用Mapper方法完成添加
        deptMapper.addDept(dept);

    }


    @Override
    public void update(Dept dept) {
        //补全更新时间
        dept.setUpdateTime(LocalDateTime.now());
        //调用Mapper方法完成修改
        deptMapper.update(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }


}
