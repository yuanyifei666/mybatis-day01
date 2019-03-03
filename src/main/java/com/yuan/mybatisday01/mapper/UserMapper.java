package com.yuan.mybatisday01.mapper;

import com.yuan.mybatisday01.vo.User;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 操作user表的持久层
 */
@Mapper
public interface UserMapper {

    /** 查询user表的所有信息**/
    List<User> findUesrs()throws Exception;

    /** mybatis的一对多的使用**/
    User findUserById(Integer id)throws Exception;

    /** 使用parameterMaper来接多个参数**/
    List<User> findUserByParams(Map<String ,Object> params)throws Exception;

}
