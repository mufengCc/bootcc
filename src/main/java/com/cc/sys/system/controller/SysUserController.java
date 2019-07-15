package com.cc.sys.system.controller;

import com.cc.sys.system.entity.SysUser;
import com.cc.sys.system.service.SysUserService;
import com.cc.sys.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/6/30 15:54
 */
@Controller
@RequestMapping("/system/user")
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
	public PageUtils list(@RequestParam Map<String,Object> params){
		Object deptId = params.get("deptId");
		System.out.println(deptId);
		Map<String,Object> paramMap = new HashMap<>();
		List<SysUser> sysUserList = sysUserService.getListUser(params);
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

	@RequestMapping("/save")
	@ResponseBody
	public Object saveUser(SysUser sysUser){
		String name = sysUser.getName();
		sysUser.setOperateIp("127.0.0.1");
		sysUser.setOperateTime(new Date());
		Object o = sysUserService.saveUser(sysUser);
		System.out.println("用户名："+name);
		Map<String,Object> cMap = new HashMap<>();
		cMap.put("code","0");
		return cMap;
	}

}
