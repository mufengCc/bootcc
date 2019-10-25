package com.cc.sys.system.controller;

import com.cc.sys.system.entity.SysRole;
import com.cc.sys.system.service.SysRoleService;
import com.cc.sys.util.BaseRequestUtils;
import com.cc.sys.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/7/16 16:46
 */
@RequestMapping("/system/role")
@Controller
public class SysRoleController extends BaseRequestUtils {

	final private String preix = "system/role";

	@Autowired
	private SysRoleService sysRoleService;

	@GetMapping
	public Object index(){
		return preix + "/sysRole";
	}

	@RequestMapping("/list")
	@ResponseBody
	public Object list(@RequestParam Map<String, Object> params, HttpServletRequest request){
		Object userName = request.getSession().getAttribute("userName");
		System.out.println(userName.toString());
		List<SysRole> listRole = sysRoleService.getListRole(params);
		int count = sysRoleService.getCount(params);
		PageUtils pageUtils = new PageUtils(listRole,count);
		return pageUtils;
	}

	/**
	 * @Description 角色编辑
	 * @param:
	 * @param id
	 * @param model
	 * @return java.lang.Object
	 * @author Cc
	 * @date 2019/7/17 13:57
	 */
	@RequestMapping("/editRole/{id}")
	public Object edit(@PathVariable("id") Long id, Model model){
		SysRole sysRole = sysRoleService.getRoleById(id.toString());
		model.addAttribute("role",sysRole);
		return preix + "/edit";
	}


}
