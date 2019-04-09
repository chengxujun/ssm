package com.itheima.ssm.wab;


import com.itheima.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    //添加产品
    //添加完成后要从新查询
    @RequestMapping("/save.dao")
    public void save(Product product) throws Exception {
        productService.save(product);
    }


    //查询全部产品
    @RequestMapping("/findAll.dao")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> all = productService.findAll();
        modelAndView.addObject("productList", all);
        modelAndView.setViewName("product-list1");
        return modelAndView;
    }

}
