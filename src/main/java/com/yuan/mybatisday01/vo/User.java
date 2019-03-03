package com.yuan.mybatisday01.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * 数据库的映射实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private List<Order> orders;

}
