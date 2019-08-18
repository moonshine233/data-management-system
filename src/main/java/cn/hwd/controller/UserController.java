package cn.hwd.controller;


import cn.hwd.domain.Role;
import cn.hwd.domain.UserInfo;
import cn.hwd.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
@RolesAllowed("ADMIN")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "4")Integer size){
        ModelAndView mv=new ModelAndView();
        List<UserInfo> userInfoList=userService.findAll(page,size);
        PageInfo userPageInfo=new PageInfo(userInfoList);
        mv.addObject("userPageInfo",userPageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userService.save(userInfo);

        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)Integer userId){

        ModelAndView mv=new ModelAndView();
        UserInfo user=userService.findById(userId);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true)Integer userId){
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo = userService.findById(userId);
        List<Role> roleList=userService.findOtherRole(userId);

        mv.addObject("userInfo",userInfo);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) Integer userId, @RequestParam(name = "ids",required = true) Integer[] ids){

        userService.addRoleToUser(userId,ids);

        return "redirect:findAll";
    }
}
