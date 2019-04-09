package com.itheima.ssm.service.impl;

import com.itheima.ssm.service.IProductService;
import com.itheima.ssm.dao.IProductdao;
import com.itheima.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional//开启事务

public class ProductService implements IProductService {
    @Autowired
    private IProductdao iProductdao;
    //查询全部产品
    @Override
    public List<Product> findAll() throws Exception {
        return iProductdao.findAll();
    }
    //添加产品
    @Override
    public void save(Product product) throws Exception {
        iProductdao.save(product);
    }


}
