package com.cc.sys.system.controller;

import com.cc.sys.system.entity.SysMenu;
import com.cc.sys.system.service.SysMenuService;
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
@RequestMapping("/system/menu")
@Controller
public class SysMenuController {

	final private String preix = "system/menu";
	@Autowired
	private SysMenuService sysMenuService;

	@GetMapping
	public Object index(){
		return preix + "/sysMenu";
	}

	@RequestMapping("/list")
	@ResponseBody
	public Object list(@RequestParam Map<String, Object> params){
		List<SysMenu> listMenu = sysMenuService.getListMenu(params);
		return listMenu;
	}


}
