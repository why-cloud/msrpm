/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.msr.common.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class R1 extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public R1() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static R1 error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static R1 error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static R1 error(int code, String msg) {
		R1 r = new R1();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R1 ok(String msg) {
		R1 r = new R1();
		r.put("msg", msg);
		return r;
	}
	
	public static R1 ok(Map<String, Object> map) {
		R1 r = new R1();
		r.putAll(map);
		return r;
	}
	
	public static R1 ok() {
		return new R1();
	}

	public R1 put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
