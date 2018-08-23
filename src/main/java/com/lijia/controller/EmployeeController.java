package com.lijia.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lijia.bean.Employee;
import com.lijia.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author 李嘉
 * @create 2018-08-22-10:22
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")
    public String getEmp(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
                         Map<String,Object> map){
        //在查询之前只需要调用，传入页码，以及每页记录数
        PageHelper.startPage(pn,5);
        List<Employee> emps = employeeService.getAll();
        //使用pageInfo包装查询后的结果及连续显示多少页
        PageInfo pageInfo = new PageInfo(emps, 5);
        map.put("allEmps",emps);
        map.put("pageInfo",pageInfo);
        return "list";
    }

}
