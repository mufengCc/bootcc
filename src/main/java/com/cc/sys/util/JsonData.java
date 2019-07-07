package com.cc.sys.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cc
 * @data 2019/6/22 14:16
 */
@Data
public class JsonData {
	 private boolean ret;

	 private String msg;

	 private Object data;


	 public JsonData(boolean ret){
	 	this.ret = ret;
	 }

	 public static JsonData success(Object object,String msg){
		JsonData jsonData = new JsonData(true);
		jsonData.data = object;
		jsonData.msg = msg;
		return  jsonData;
	}

	public static JsonData success(Object object){
		JsonData jsonData = new JsonData(true);
		jsonData.data = object;
		return  jsonData;
	}

	public static JsonData success(){
		return  new JsonData(true);
	}

	public static JsonData fail(String msg){
		JsonData jsonData = new JsonData(false);
		jsonData.msg = msg;
		return  jsonData;
	}

	public Map<String,Object> toMap(){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("ret",ret);
		result.put("msg",msg);
		result.put("data",data);
		return result;
	}
}
