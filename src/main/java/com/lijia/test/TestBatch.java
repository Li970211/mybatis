package com.lijia.test;

import com.lijia.bean.Department;
import com.lijia.bean.Employee;
import com.lijia.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author 李嘉
 * @create 2018-08-23-10:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestBatch {
    //批量插入测试
    @Autowired
    private SqlSession sqlSession;

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void testInsert(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50;i++){
            employeeMapper.addBatch(new Employee(null, UUID.randomUUID().toString().substring(0,3),"123@qq.com","1",new Department(1)));
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间:"+(end-start)+"毫秒");
    }
}
