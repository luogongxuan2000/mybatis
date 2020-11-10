package com.qf.dao;

import com.qf.pojo.Classes;
import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassesDao {

    List<Classes> findAll();

    User findById(@Param("uuid") int id);

    User findByName(@Param("uuname") String name);
}
