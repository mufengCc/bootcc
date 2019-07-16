package com.cc.sys.system.controller;

import com.cc.sys.system.entity.SysRole;
import com.cc.sys.system.service.SysRoleService;
import com.cc.sys.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/7/16 16:46
 */
@RequestMapping("/system/role")
@Controller
public class SysRoleController {

	final private String preix = "system/role";

	@Autowired
	private SysRoleService sysRoleService;

	@GetMapping
	public Object index(){
		return preix + "/sysRole";
	}

	@RequestMapping("/list")
	@ResponseBody
	public Object list(@RequestParam Map<String, Object> params){
		List<SysRole> listRole = sysRoleService.getListRole(params);
		int count = sysRoleService.getCount(params);
		PageUtils pageUtils = new PageUtils(listRole,count);
		return pageUtils;
	}


}
