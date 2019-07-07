package com.cc.sys;

import com.cc.sys.Base.Tree;
import com.cc.sys.system.entity.SysDept;
import com.cc.sys.system.entity.SysUser;
import com.cc.sys.system.mapper.SysDeptMapper;
import com.cc.sys.system.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysApplicationTests {

	@Autowired
	private SysDeptMapper sysDeptMapper;

	@Test
	public void contextLoads() {
	}

	//参考 bootdo
	@Test
	public void test(){
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

		Tree<SysDept> tree = buildTree(trees);
		System.out.println(tree.toString());
	}

	//开始处理树
	public static  <T> Tree<T> buildTree(List<Tree<T>> nodes){
		if (nodes == null) {
			return null;
		}
		//顶级节点  0
		List<Tree<T>> topNodes = new ArrayList<>();

		//遍历子节点
		for (Tree<T> children : nodes) {
			String pid = children.getParentId();    //获取父级ID
			if (pid == null || "0".equals(pid)) {   //父节节点
				topNodes.add(children);
				continue;
			}

			for (Tree<T> parent : nodes) {
				String id = parent.getId();
				//如果该循环的数据的ID 等于 上级循环的父类ID，那么该ID 就是父级别
				if (id != null && id.equals(pid)) {
					parent.getChildren().add(children);
					children.setHasParent(true);
					parent.setChildren(true);
					continue;
				}
			}
		}
		Tree<T> root = new Tree<T>();
		if (topNodes.size() == 1) {
			root = topNodes.get(0);
		}else{
			root.setId("-1");
			root.setParentId("");
			root.setHasParent(false);
			root.setChildren(true);
			root.setChecked(true);
			root.setChildren(topNodes);
			root.setText("顶级节点");
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			root.setState(state);
		}
		return  root;
	}

	@Autowired
	private SysUserService sysUserService;

	@Test
	public void list(){
		Map<String,Object> paramMap = new HashMap<>();
		List<SysUser> listUser = sysUserService.getListUser(paramMap);
		int count = sysUserService.getCount(paramMap);
	}
}
