package com.itheima.ssm.service;

import com.itheima.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    //查询全部产品
    List<Product> findAll() throws Exception;
    //添加产品
    void save(Product product)throws Exception;
}
