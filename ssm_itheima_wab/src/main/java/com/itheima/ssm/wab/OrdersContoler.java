package com.itheima.ssm.wab;

import com.github.pagehelper.PageInfo;
import com.itheima.Orders;
import com.itheima.ssm.service.IordersSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
//订单


@Controller
@RequestMapping("/orders")
public class OrdersContoler {
    @Autowired
    private IordersSerice ordersSerice;

    // 未加分页的
   /* @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView ma = new ModelAndView();
        List<Orders> list = ordersSerice.findAll();
        ma.addObject("ordersList", list);
        ma.setViewName("orders-list");
        return ma;
    }*/
    //加了分页查询的查询所有
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {
        ModelAndView ma = new ModelAndView();
        List<Orders> list = ordersSerice.findAll(page, size);
        PageInfo<Orders> info = new PageInfo<>(list);


        ma.addObject("pageinfo", info);
        ma.setViewName("orders-page-list");
        return ma;

    }

    @RequestMapping("/findByID.do")
    public ModelAndView findByID(@RequestParam(name = "id", required = true) String ordersid) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = ordersSerice.findByID(ordersid);
        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }


}
