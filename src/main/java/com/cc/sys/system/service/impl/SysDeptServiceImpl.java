package com.cc.sys.system.service.impl;

import com.cc.sys.system.entity.SysDept;
import com.cc.sys.system.mapper.SysDeptMapper;
import com.cc.sys.system.service.SysDeptService;
import com.cc.sys.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/7/16 15:04
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {

	@Autowired
	private SysDeptMapper sysDeptMapper;

	@Override
	public List<SysDept> getListDept(Map<String, Object> map) {
		return sysDeptMapper.getListDept(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return sysDeptMapper.getCount(map);
	}
}
