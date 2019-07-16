package com.cc.sys.system.service;

import com.cc.sys.system.entity.SysDept;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/7/16 15:02
 */
@Service
public interface SysDeptService {

	List<SysDept> getListDept(Map<String,Object> map);

	public int getCount(Map<String,Object> map);

}
