package cn.hwd.controller;

import cn.hwd.domain.Orders;
import cn.hwd.service.OrdersService;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

//    @RequestMapping("/findAll")
//    public ModelAndView findAll(){
//        ModelAndView mv=new ModelAndView();
//        List<Orders> ordersList=ordersService.findAll();
//        mv.addObject("ordersList",ordersList);
//        mv.setViewName("orders-list");
//        return mv;
//    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "4")Integer size){

        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page, size);
        PageInfo ordersPageInfo=new PageInfo(ordersList);
        mv.addObject("ordersPageInfo",ordersPageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)Integer ordersId){

        ModelAndView mv =new ModelAndView();
        Orders orders=ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("redirect:findAll");
        return mv;
    }
}
