package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //查询
    List<User> findAll();
    //@Param注解（）中的内容就是 #{}中的内容
    User findById(@Param("uid") Integer id);
    User findByIdAndUserName(Map map);
    //模糊
    List<User> findByNameLike(@Param("username") String name);
    //修改
    int updateById(User user);
    //删除
    int delById(@Param("uid") int id);
    //增加
    int insertNew(User user);
    //查新增后的主键值
    int insertUserGetId(User user);
}
