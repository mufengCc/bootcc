package com.cc.sys.system.controller;

import com.cc.sys.system.entity.SysUser;
import com.cc.sys.system.service.SysUserService;
import com.cc.sys.util.PageUtils;
import lombok.extern.java.Log;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/6/30 15:54
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserController {

	private String prefix = "system/user";

	@Autowired
	private SysUserService sysUserService;

	@GetMapping
	public Object index(){
		return prefix + "/sysUser";
	}

	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(){
		Map<String,Object> paramMap = new HashMap<>();
		List<SysUser> sysUserList = sysUserService.getListUser(paramMap);
		int total = sysUserService.getCount(paramMap);
		PageUtils pageUtil = new PageUtils(sysUserList, total);
		return pageUtil;
	}

	@GetMapping("/add")
	String add(Model model) {
		//List<RoleDO> roles = roleService.list();
		//model.addAttribute("roles", roles);
		return prefix + "/add";
	}

}
