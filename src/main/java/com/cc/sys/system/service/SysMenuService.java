package com.cc.sys.system.service;

import com.cc.sys.Base.Tree;
import com.cc.sys.system.entity.SysMenu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/6/27 13:44
 */
@Service
public interface SysMenuService {

	public Tree<SysMenu> getMenuTree(Map<String,Object> map);

	public List<Tree<SysMenu>> getMenuTreeList(Map<String,Object> map);
}
