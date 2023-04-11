package com.changjiang.score.common;

import lombok.Data;

@Data
public class Result<T> {

	public String code;
	public String description;
	public T data;
	
	public static <T> Result<T> ok(T t) {
		Result<T> r = ok("操作成功");
		r.data = t;
		return r;
	}

	public static <T> Result<T> ok() {
		return ok("操作成功");
	}

	public static <T> Result<T> ok(String desc) {
		Result<T> r = new Result<T>();
		r.setCode("200");
		r.setDescription(desc);
		return r;
	}

}
