package com.zaizi.mapper;


import com.zaizi.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    // 1.根据id删除数据
    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);
    //public int delete(Integer id);     // 有返回值的话返回影响的记录数  一般不需要


    // 2.新增员工操作
    @Options(keyProperty = "id",useGeneratedKeys = true)   // 获取返回的主键  才能操作
    @Insert("INSERT into emp(username, name, gender, image, job, entrydate,dept_id, create_time, update_time)" +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{depId},#{createTime},#{updateTime});")
    public void insert(Emp emp);

    // 3.更新员工
    @Update("update emp set username = #{username},name=#{name},gender=#{gender},image=#{image},job=#{job}," +
            "entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id=#{id}")
    public void update(Emp emp);

    // 4. 根据id查询员工  在applic-ation.properties中添加mybatis.camel  --- a cloumn  -----> aColumn
    @Select("select * from emp where id = #{id}")
    public Emp GetById(Integer id);


    // 5. 根据条件查询(动态查询)员工    得加上 @Param(字段)
//    @Select("select * from emp where name like concat('%',#{name},'%') and gender =#{gender} " +
//            "and entrydate between #{begin} and #{end} order by update_time desc")
    public List<Emp> list(@Param("name")String name, @Param("gender")Short gender, @Param("begin")LocalDate begin,@Param("end")LocalDate end);


    // 6.动态更新员工

    public void update2(Emp emp);


    // 7. 批量删除操作
    public void deleteByIds(List<Integer> ids);



}
