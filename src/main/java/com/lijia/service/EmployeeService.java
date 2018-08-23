package com.lijia.service;

import com.lijia.bean.Employee;
import com.lijia.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李嘉
 * @create 2018-08-22-10:28
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAll(){
        return employeeMapper.getAll();
    }

}
