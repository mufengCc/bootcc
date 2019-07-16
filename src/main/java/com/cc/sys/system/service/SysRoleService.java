package com.cc.sys.system.service;

import com.cc.sys.system.entity.SysRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/7/16 16:57
 */
@Service
public interface SysRoleService {

	List<SysRole> getListRole(Map<String,Object> map);

	int getCount(Map<String,Object> map);

}
