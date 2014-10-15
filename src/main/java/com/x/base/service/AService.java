package com.x.base.service;

import java.util.List;

import com.x.base.model.A;
import com.x.base.model.PageInfo;


/**
 * <p>Description:</p>
 * @Author Chenkangming 
 * @Date 2014-9-25
 * @version 1.0
 */
public interface AService {
	void insert();
	
	void update();
	
	List<A> list(PageInfo pageInfo);
	
	int delete();
	
	PageInfo pageInfo();
}
