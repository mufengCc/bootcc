package com.cc.sys.system.controller;

import com.cc.sys.Base.Tree;
import com.cc.sys.system.entity.SysMenu;
import com.cc.sys.system.service.SysMenuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/6/20 10:12
 */
@Controller
public class HelloController {
	Logger log= Logger.getLogger(HelloController.class);

	@Autowired
	private SysMenuService sysMenuService;

	@RequestMapping("/login")
	public Object login(){
		return "login";
	}

	@RequestMapping("/index")
	public Object index(Model model){
		//List<Tree<SysMenu>> menuTreeList = sysMenuService.getMenuTreeList(cMap);
		//model.addAttribute("menus",menuTreeList);
		Map<String,Object> cMap = new HashMap<>();
		Tree<SysMenu> menuTree = sysMenuService.getMenuTree(cMap);
		model.addAttribute("AA","占山");
		model.addAttribute("menus",menuTree);
		return "/index";
	}


	@RequestMapping("/redircetIndex")
	public Object redircetTest(){
		return "redirect:/index";
	}

	@RequestMapping("/redircetIndex2")
	public Object redircetIndex2(){
		return "redirect:index";
	}

	@RequestMapping("/redircet404")
	public Object redircet404(){
		return "redirect:404";
	}


}

