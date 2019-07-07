package com.cc.sys.system.service;

import com.cc.sys.Base.Tree;
import com.cc.sys.system.entity.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/6/27 15:16
 */
@Service
public interface SysUserService {

	List<SysUser> getListUser(Map<String,Object> map);

	int getCount(Map<String,Object> map);
}
