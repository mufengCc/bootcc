package com.cc.sys.system.service.impl;

import com.cc.sys.Base.BuildTree;
import com.cc.sys.Base.Tree;
import com.cc.sys.system.entity.SysMenu;
import com.cc.sys.system.mapper.SysMenuMapper;
import com.cc.sys.system.service.SysMenuService;
import javafx.util.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/6/27 13:47
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuMapper sysMenuMapper;

	//获取 菜单 树
	@Override
	public Tree<SysMenu> getMenuTree(Map<String,Object> map) {
		List<Tree<SysMenu>> trees = new ArrayList<>();
		List<SysMenu> list = sysMenuMapper.getListMenu(map);
		for (SysMenu menu : list){
			Tree<SysMenu> tree = new Tree<>();
			tree.setId(menu.getMenuId().toString());
			tree.setParentId(menu.getParentId().toString());
			tree.setText(menu.getName());
			Map<String, Object> attributes = new HashMap<>(16);
			attributes.put("url", menu.getUrl());
			attributes.put("icon", menu.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		Tree<SysMenu> tree = BuildTree.buildTree(trees);
		System.out.println(tree.toString());
		return tree;
	}
	//获取 菜单 树
	@Override
	public List<Tree<SysMenu>> getMenuTreeList(Map<String, Object> map) {
		List<Tree<SysMenu>> trees = new ArrayList<>();
		List<SysMenu> list = sysMenuMapper.getListMenu(map);
		for (SysMenu menu : list){
			Tree<SysMenu> tree = new Tree<>();
			tree.setId(menu.getMenuId().toString());
			tree.setParentId(menu.getParentId().toString());
			tree.setText(menu.getName());
			Map<String, Object> attributes = new HashMap<>(16);
			attributes.put("url", menu.getUrl());
			attributes.put("icon", menu.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		//// 默认顶级菜单为０，根据数据库实际情况调整
		List<Tree<SysMenu>> treeList = BuildTree.buildList(trees, "0");
		System.out.println(treeList.toString());
		return treeList;
	}

	@Override
	public List<SysMenu> getListMenu(Map<String, Object> map) {
		List<SysMenu> listMenu = sysMenuMapper.getListMenu(map);
		return listMenu;
	}

	@Override
	public int getCount(Map<String, Object> map) {
		int count = sysMenuMapper.getCount(map);
		return count;
	}
}
