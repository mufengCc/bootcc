package com.cc.sys.system.service.impl;

import com.cc.sys.Base.Tree;
import com.cc.sys.system.entity.SysUser;
import com.cc.sys.system.mapper.SysUserMapper;
import com.cc.sys.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/6/27 15:16
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public List<SysUser> getListUser(Map<String, Object> map) {
		List<SysUser> listUser = sysUserMapper.getListUser(map);

		return listUser;
	}

	@Override
	public int getCount(Map<String, Object> map) {
		int userCount = sysUserMapper.getCount(map);
		return userCount;
	}
}
