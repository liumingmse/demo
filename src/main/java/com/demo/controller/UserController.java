package com.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.demo.entity.AcctUser;
import com.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/showInfo/{userId}")
	public String showUserInfo(ModelMap modelMap, @PathVariable String userId){
		LOGGER.info("查询用户：" + userId);
		AcctUser userInfo = userService.load(userId);
		modelMap.addAttribute("userInfo", userInfo);
		return "/user/showInfo";
	}
	
	@RequestMapping("/showInfos")
	@ResponseBody
	public  List<AcctUser> showUserInfos(){
		LOGGER.info("查询用户全部用户");
		List<AcctUser> userInfos = userService.findAll();
		return userInfos;
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		AcctUser acctUser = new AcctUser();
		acctUser.setNickName("andy");
		acctUser.setRegisterTime(new Date());
		acctUser.setTelephone("13022221111");
		String id = userService.save(acctUser);
		userService.flush();
		LOGGER.info(JSON.toJSONString(id));
		return id;
	}
}
