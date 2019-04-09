package com.itheima.ssm.service;

import com.itheima.Orders;

import java.util.List;

public interface IordersSerice {
    List<Orders> findAll(int page, int size) throws Exception;

    Orders findByID(String ordersid) throws Exception;

}
