package com.cc.sys.system.mapper;

import com.cc.sys.system.entity.sysAcl;

public interface sysAclMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(sysAcl record);

    int insertSelective(sysAcl record);

    sysAcl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(sysAcl record);

    int updateByPrimaryKey(sysAcl record);
}