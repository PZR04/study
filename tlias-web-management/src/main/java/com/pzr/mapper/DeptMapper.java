package com.pzr.mapper;

import com.pzr.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询所有部门
     */
    //方法一：手动结果映射
    //@Results({
    //@Result(property = "createTime", column = "create_time"),
    //        @Result(property = "updateTime", column = "update_time")
    //})
    @Select("SELECT * FROM dept ORDER BY update_time DESC;")
    List<Dept> findAll();

/**
 * 根据id删除部门
 */
@Delete("DELETE FROM dept WHERE id = #{id}")
    void deleteById(Integer id);
/**
 * 添加部门
 */
@Insert("INSERT INTO dept(name, create_time, update_time) VALUES (#{name}, #{createTime}, #{updateTime})")
    void addDept(Dept dept);

/**
 * 查询部门
 */
@Select("SELECT * FROM dept WHERE id = #{id}")
    Dept getById(Integer id);

/**
 * 修改部门
 */
@Update("UPDATE dept SET name = #{name}, update_time = #{updateTime} WHERE id = #{id}")
    void update(Dept dept);
}


