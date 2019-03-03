package com.yuan.mybatisday01.mapper;

import com.yuan.mybatisday01.vo.Orders;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单表的持久层
 */
@Mapper
public interface OrdersMapper {

    /** 查询订单和该订单关联的用户信息**/
    List<Orders> findOrders()throws Exception;

}
