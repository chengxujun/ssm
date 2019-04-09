package com.itheima.ssm.wab;


import com.itheima.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserContoler {
    @Autowired
    private IUserService userService;

    @RequestMapping("findByID.do")
    public  ModelAndView findByID( String id ) throws Exception{
       UserInfo userInfo= userService.findByID( id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping("save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "/redrect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView view = new ModelAndView();
        List<UserInfo> all = userService.findAll();
        view.addObject("userList", all);
        view.setViewName("user-list");
        return view;
    }

}
