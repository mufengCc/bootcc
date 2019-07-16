package com.cc.sys.system.service.impl;

import com.cc.sys.system.entity.SysRole;
import com.cc.sys.system.mapper.SysRoleMapper;
import com.cc.sys.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/7/16 16:59
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Override
	public List<SysRole> getListRole(Map<String, Object> map) {
		List<SysRole> listRole = sysRoleMapper.getListRole(map);
		return listRole;
	}

	@Override
	public int getCount(Map<String, Object> map) {
		int count = sysRoleMapper.getCount(map);
		return count;
	}
}
