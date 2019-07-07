package com.cc.sys.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Cc
 * @data 2019/6/30 17:05
 */
@Data
public class PageUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	private int total;
	private List<?> rows;

	public PageUtils(List<?> list, int total) {
		this.rows = list;
		this.total = total;
	}
}
