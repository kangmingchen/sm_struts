package com.x.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.x.base.model.A;
import com.x.base.model.PageInfo;
import com.x.base.service.AService;
import com.x.data.dao.MyBatisDao;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @Author Chenkangming
 * @Date 2014-9-25
 * @version 1.0
 */
@Service
public class AServiceImpl implements AService {

	@Autowired
	private MyBatisDao mydao;

	@Override
	public void insert() {
		mydao.save("a_dao.insert", "fdfdfdfdfdfd");
		// mydao.insert("dfdfdfdf");
	}

	@Override
	public void update() {
		Map<Object,Object> map=new HashMap<Object, Object>();
		map.put("id", 1);
		map.put("a", "ccccccccccc");
		mydao.update("a_dao.update", map);
		// mydao.update(1, "bbbbbbbbbb");
	}

	@Override
	public List<A> list(PageInfo pageInfo) {
		return mydao.getList("a_dao.select",pageInfo);
	}

	@Override
	public int delete() {
		return mydao.delete("a_dao.delete", 1);
	}

	@Override
	public PageInfo pageInfo() {
		int rows=mydao.get("a_dao.count");
		return new PageInfo(rows);
	}

}
