package com.pzr.mapper;


import com.pzr.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工经历
 */
@Mapper
public interface EmpExprMapper {
    /**
     * 批量插入员工工作经历数据
     */
    void insertBatch(List<EmpExpr> exprList);

    /**
     * 根据员工ID批量删除员工工作经历
     */
    void deleteByEmpIds(List<Integer> empIds);
}
