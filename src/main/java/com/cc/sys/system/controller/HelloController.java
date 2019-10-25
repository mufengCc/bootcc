package com.cc.sys.system.controller;

import com.cc.sys.Base.Tree;
import com.cc.sys.system.entity.SysMenu;
import com.cc.sys.system.entity.SysUser;
import com.cc.sys.system.service.SysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
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



	/*@RequestMapping("/login")
	public Object login(HttpServletRequest request,Model model){
		SysUser sysUser = new SysUser();
		HttpSession session = request.getSession();
		String userName1 = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		//TODO 1.检查登录的用户名是否正确

		if (StringUtils.isNoneBlank(userName1)) {
			session.setAttribute("userName",userName1);
			Map<String,Object> cMap = new HashMap<>();
			Tree<SysMenu> menuTree = sysMenuService.getMenuTree(cMap);
			model.addAttribute("AA","占山");
			model.addAttribute("menus",menuTree);
			return "/index_v2";
		}
		return "login";
	}*/

	/**
	 *  用户登录
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request){
		SysUser sysUser = new SysUser();
		HttpSession session = request.getSession();
		ModelAndView modelAndView = new ModelAndView();
		String userName1 = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		//TODO 1.检查登录的用户名是否正确

		if (StringUtils.isNoneBlank(userName1)) {
			session.setAttribute("userName",userName1);
			modelAndView.setViewName("forward:/index");
			return modelAndView;
		}
		return modelAndView;
	}

	@RequestMapping("/index")
	public Object index(Model model){
		//List<Tree<SysMenu>> menuTreeList = sysMenuService.getMenuTreeList(cMap);
		//model.addAttribute("menus",menuTreeList);
		Map<String,Object> cMap = new HashMap<>();
		Tree<SysMenu> menuTree = sysMenuService.getMenuTree(cMap);
		model.addAttribute("AA","占山");
		model.addAttribute("menus",menuTree);
		return "/index_v2";
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

