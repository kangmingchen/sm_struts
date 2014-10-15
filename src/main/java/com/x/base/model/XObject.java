package com.x.base.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * <p>Description:序列化</p>
 * @Author Chenkangming @Date 2014-09-26
 * @version 1.0
 */
public abstract class XObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
