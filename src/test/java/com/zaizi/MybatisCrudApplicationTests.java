package com.zaizi;

import com.zaizi.mapper.EmpMapper;
import com.zaizi.pojo.Emp;
import org.apache.ibatis.annotations.Options;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisCrudApplicationTests {

    @Autowired
    private EmpMapper empMapper;


    // 1.根据id删除数据
    @Test
    public void testDelete() {
        empMapper.delete(1);
        // System.out.println(del);   // 一般还是不需要返回值
    }


    // 2.新增员工操作

    @Test
    public void testInsert() {
        Emp emp = new Emp();
        emp.setUsername("tom6");
        emp.setName("汤姆6");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(66);
        empMapper.insert(emp);
        System.out.printf(String.valueOf(emp.getId()));

    }

    // 3.根据id更新员工
    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(22);
        emp.setUsername("Tom77");   //此处获取id
        emp.setName("汤姆7");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.update(emp);
    }


    // 4. 根据id查询员工

    @Test
    public void testGetById() {
        Emp emp = empMapper.GetById(22);
        System.out.println(emp);
    }



    // 5. 根据条件查询(动态查询)员工
    @Test
    public void TestList() {
        //List<Emp> empList = empMapper.list("张",(short)1,LocalDate.of(1010,01,01),LocalDate.of(2040,1,1));
//        List<Emp> empList = empMapper.list(null,(short)1,null,null);
        List<Emp> empList = empMapper.list(null,null,null,null);
        System.out.println(empList);
    }


    // 6.根据id动态更新员工
    @Test
    public void testUpdate2() {
        Emp emp = new Emp();
        emp.setId(22);
        emp.setUsername("Tom777777");   //此处获取id
        emp.setName("汤姆77777");
        emp.setGender((short)2);
        emp.setUpdateTime(LocalDateTime.now());


        empMapper.update2(emp);
    }


    // 7. 批量删除操作
    @Test
    public void testDeleteByIds() {
        List<Integer> ids = Arrays.asList(12,13,14);
        empMapper.deleteByIds(ids);
    }







}
