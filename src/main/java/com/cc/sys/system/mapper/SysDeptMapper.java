package com.cc.sys.system.mapper;

import com.cc.sys.system.entity.SysDept;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysDeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);

    List<SysDept> getListOrderBySeq();

    List<SysDept> getListDept(Map<String,Object> map);

    int getCount(Map<String,Object> map);
}