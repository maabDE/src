package com.tulun.tuluntest.controller;

import javax.servlet.http.HttpSession;

import com.tulun.tuluntest.entity.User;
//import com.tulun.tuluntest.service.IRedisService;
//import com.tulun.tuluntest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户管理模块
 *
 * @author shilei
 */
@Controller
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private IUserService userService;
//    @Autowired
//    private IRedisService rsi;
//
//    @RequestMapping("/login")
//    public String login(Model model) {
//        model.addAttribute(new User());
//        return "login";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@Validated User user, BindingResult result, HttpSession session) {
//        if (result.hasErrors()) {
//            return "login";
//        }
//        //插入新用户
//        userService.insertUser(user);
//        int id = userService.getLastInsertId();
//        session.setAttribute("userid", id);
//        session.setAttribute("role", "user");
//
//        return "redirect:/user/start";
//    }
//
//    @RequestMapping(value = "/start")
//    public String start(Model model, HttpSession session) {
//        //如果答题已经开始，那么提示用户本场答题不能再进行了
//        if (rsi.isExameRunning()) {
//            return "error";
//        } else {
//            session.setAttribute("userstate", "yes");
//            return "start";
//        }
//
//		/*//用户初始答题状态都设置为过关状态，如果用户是通过刷新来到这里重新答题，那么保持原来的状态
//		if(rsi.isPushOver()){
//			if(session.getAttribute("userstate") == null){
//				session.setAttribute("userstate", "yes");
//			}
//			return "start";
//		}
//		//用户再来一场答题，那么状态重置
//		if(rsi.isExameDone()){
//			session.setAttribute("userstate", "yes");
//			return "start";
//		}
//		return "";*/
//    }
}