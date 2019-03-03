package com.yuan.mybatisday01.controller;

import com.yuan.mybatisday01.mapper.OrdersMapper;
import com.yuan.mybatisday01.mapper.UserMapper;
import com.yuan.mybatisday01.vo.Orders;
import com.yuan.mybatisday01.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Mybatis的学习
 *  `mybatis中关联关系的使用
 *      一对多: 使用collection标签
 *      一对一：使用association标签
 */
@RestController
@RequestMapping("mybatis")
@Slf4j
public class MyBatisController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrdersMapper ordersMapper;


    /**
     * 读取数据库中User表中的所有记录
      */
    @RequestMapping("findUsers")
    public List<User> findUsers()throws Exception{

        log.trace("读取数据库中user表的所有数据.......");
        List<User> users = userMapper.findUesrs();
        users.forEach(System.out::println);
        return users;
    }

    /** 根据用户id查询该用户下的所有订单**/
    @RequestMapping("findUserById/{id}")
    public User findUserById(
            @PathVariable(name = "id",required = true)Integer id)throws Exception{
        log.trace("查询id为："+id+"的用户信息和订单信息....");
        User user = userMapper.findUserById(id);


        return user;
    }

    /** 查询订单信息并查询该订单关联的用户信息**/
    @RequestMapping("findOrders")
    public List<Orders> findOrders()throws Exception{
        log.trace("查询订单信息并查询该订单关联的用户信息*");

        return ordersMapper.findOrders();
    }

    /**
     * 根据多条件查询用户信息
     */
    @RequestMapping("/findUserByParams/{name}/{min}/{max}")
    public List<User> findUserByParams(
            @PathVariable(name = "name")String name,
            @PathVariable(name="min")Integer min,
            @PathVariable(name = "max")Integer max
    )throws Exception{
        //把查询参数封装到map中
        Map<String ,Object> params = new HashMap<>();
       params.put("name",name);
       params.put("min",min);
        params.put("max",max);

        return userMapper.findUserByParams(params);
    }


}
