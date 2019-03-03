package com.yuan.mybatisday01.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户的订单实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Orders implements Serializable {
    private Integer oid;
    private Integer userId;
    private String number;
    private Date createTime;
    private String note;
    private User user;

}
