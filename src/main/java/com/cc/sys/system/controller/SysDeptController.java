package com.cc.sys.system.controller;

import com.cc.sys.Base.BuildTree;
import com.cc.sys.Base.Tree;
import com.cc.sys.system.entity.SysDept;
import com.cc.sys.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cc
 * @data 2019/6/23 16:33
 */
@Controller
@RequestMapping("/sys/dept")
public class SysDeptController {

	private String prefix = "system/dept";
	@Autowired
	private SysDeptMapper sysDeptMapper;

	@GetMapping
	public String index(){
		return prefix + "/sysDept";
	}

	@RequestMapping("/tree")
	@ResponseBody
	public Object tree(){
		List<Tree<SysDept>> trees = new ArrayList<>();
		List<SysDept> listOrderBySeq = sysDeptMapper.getListOrderBySeq();
		for (SysDept sysDept : listOrderBySeq) {
			System.out.println(sysDept.getName());

			Tree<SysDept> tree = new Tree<SysDept>();
			tree.setId(sysDept.getId().toString());
			tree.setParentId(sysDept.getParentId().toString());
			tree.setText(sysDept.getName());
			trees.add(tree);
		}

		Tree<SysDept> tree = BuildTree.buildTree(trees);
		System.out.println(tree.toString());
		return tree;
	}

}
