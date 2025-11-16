package com.pzr.service;

import com.pzr.pojo.Emp;
import com.pzr.pojo.EmpQueryParam;
import com.pzr.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    //新增员工
    void save(Emp emp) throws Exception;;
    /**
     * 分页查询员工信息
     */
    //PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除员工
     */
    void delete(List<Integer> ids);

    /**
     * 根据ID查询员工
     */
    Emp getInfo(Integer id);

    /**
     * 修改员工
     */
    void update(Emp emp);
}
