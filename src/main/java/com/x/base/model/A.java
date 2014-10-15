package com.x.base.model;

import java.io.Serializable;


/**
 * <p>Description:</p>
 * @Author Chenkangming 
 * @Date 2014-9-25
 * @version 1.0
 */
public class A implements Serializable{

	private static final long serialVersionUID = -1856985273751823563L;

	/**
	 * 自增长编号
	 */
	private Long id;
	/**
	 * 测试值
	 */
	private String value1;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	
	
}
