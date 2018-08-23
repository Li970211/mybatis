package com.lijia.dao;

import com.lijia.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 李嘉
 * @create 2018-08-21-8:00
 */
public interface EmployeeMapper {

    public Employee getEmployee(Integer id);

    List<Employee> getAll();
    //批量插入
    public void addBatch(Employee employee);
}
