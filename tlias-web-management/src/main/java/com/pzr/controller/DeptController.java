package com.pzr.controller;

import com.pzr.pojo.Dept;
import com.pzr.pojo.Result;
import com.pzr.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController//标识当前为一个请求处理类

public class DeptController {

    //private static final Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /**
     *查询全部部门信息
     */
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list(){
        //System.out.println("查询全部部门信息");
        log.info("查询全部部门信息");
        List<Dept> deptlist = deptService.findAll();
        return Result.success(deptlist);
    }

    /*
      删除部门
     */
//    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request){
//        String idStr = request.getParameter("id");
//        Integer id = Integer.parseInt(idStr);
//        System.out.println("根据id删除部门" +id);
//        return Result.success();
//    }

    /*
      方式二: 使用@RequestParam注解
      @RequestParam注解required属性默认为true，代表该参数必须传递，如果不传递将报错。 如果参数可选，可以将属性设置为false.
     */
//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam ("id") Integer deptId){
//        System.out.println("根据id删除部门" +deptId);
//        return Result.success();
//    }

    /*
     方式三:如果请求参数名与形参变量名相同，直接定义方法形参即可接收。(省略@RequestParam)
     */
    @DeleteMapping
    public Result delete(Integer id){
        //System.out.println("根据id删除部门" +id);
        log.info("根据id删除部门：{}" , id);
        deptService.deleteById(id);

        return Result.success();
    }
    /*
      添加部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        //System.out.println("添加部门" +dept);
        log.info("添加部门：{}" , dept);
        deptService.add(dept);
        return Result.success();
    }

    /*
     根据id查询部门
     */
//    @GetMapping("/depts/{id}")
//    public Result getInfo(@PathVariable("id") Integer deptid){
//        System.out.println("查询部门id" +deptid);
//        return Result.success();
//    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        //System.out.println("查询部门id" +id);
        log.info("查询部门id：{}" , id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /*
     修改部门
     */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        //System.out.println("修改部门" +dept);
        log.info("修改部门：{}" , dept);
        dept.setUpdateTime(LocalDateTime.now());
        deptService.update(dept);
        return Result.success();
    }

}
