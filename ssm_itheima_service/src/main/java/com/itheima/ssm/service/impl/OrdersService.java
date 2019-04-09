package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.Orders;
import com.itheima.ssm.dao.OrdersDao;
import com.itheima.ssm.service.IordersSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class OrdersService implements IordersSerice {
    @Autowired
    private OrdersDao ordersDao;
//查询订单所有
    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        // 1 是页码值  5是代表每页显示的条数
        PageHelper.startPage(page,size);

        return ordersDao.fingAll();
    }
//根据id查询订单详情
    @Override
    public Orders findByID(String ordersid) throws Exception {
        return ordersDao.findByID(ordersid);
    }
}
