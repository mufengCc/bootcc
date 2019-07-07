package com.cc.sys.Base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/6/23 16:54
 */
public class BuildTree {

	/**
	 * @Description 处理树节点
	 * @param:
	 * @param nodes 树节点
	 * @return com.cc.sys.Base.Tree<T>
	 * @author Cc
	 * @date 2019/6/23 16:55
	 */

	public static <T> Tree<T> buildTree(List<Tree<T>> nodes){
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

	public static <T> List<Tree<T>> buildList(List<Tree<T>> nodes, String idParam) {
		if (nodes == null) {
			return null;
		}
		List<Tree<T>> topNodes = new ArrayList<Tree<T>>();
		for (Tree<T> children : nodes) {
			String pid = children.getParentId();
			if (pid == null || idParam.equals(pid)) {
				topNodes.add(children);
				continue;
			}

			for (Tree<T> parent : nodes) {
				String id = parent.getId();
				if (id != null && id.equals(pid)) {
					parent.getChildren().add(children);
					children.setHasParent(true);
					parent.setChildren(true);
					continue;
				}
			}

		}
		return topNodes;
	}
}
