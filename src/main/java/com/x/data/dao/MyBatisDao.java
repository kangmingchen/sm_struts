package com.x.data.dao;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * <p>
 * Description:MyBatisDao 的 Dao 基类
 * </p>
 * 
 * @Author Chenkangming
 * @Date 2014-9-26
 * @version 1.0
 */
public class MyBatisDao extends SqlSessionDaoSupport {
	
	public int save(String key, Object object) {
		return getSqlSession().insert(key, object);
	}
	
	public int update(String key,Object object){
		return getSqlSession().update(key, object);
	}

	public int delete(String key, Serializable id) {
		return getSqlSession().delete(key, id);
	}
	
	public void delete(String key, Object object) {
		getSqlSession().delete(key, object);
	}
	
	public <T> T get(String key, Object params) {
		return getSqlSession().selectOne(key, params);
	}
	
	public <T> T get(String key) {
		return getSqlSession().selectOne(key);
	}

	public <T> List<T> getList(String key) {
		return getSqlSession().selectList(key);
	}

	public <T> List<T> getList(String key, Object params) {
		return getSqlSession().selectList(key, params);
	}
}
