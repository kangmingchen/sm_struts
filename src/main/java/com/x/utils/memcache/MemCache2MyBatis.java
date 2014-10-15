package com.x.utils.memcache;

import java.util.LinkedList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @Author Chenkangming
 * @Date 2014-9-26
 * @version 1.0
 */
public class MemCache2MyBatis implements Cache {

	/** The ReadWriteLock. */
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private String id;
	private LinkedList<String> cacheKeys = new LinkedList<String>();

	public MemCache2MyBatis(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public int getSize() {
		return cacheKeys.size();
	}

	@Override
	public void putObject(Object key, Object value) {
		String cacheKey = String.valueOf(key.hashCode());
		if (!cacheKeys.contains(cacheKey)) {
			cacheKeys.add(cacheKey);
		}
		MemCacheManage.add(cacheKey, value);
	}

	@Override
	public Object getObject(Object key) {
		String cacheKey = String.valueOf(key.hashCode());
		Object value = MemCacheManage.get(cacheKey);
		if (!cacheKeys.contains(cacheKey)) {
			cacheKeys.add(cacheKey);
		}
		return value;
	}

	@Override
	public Object removeObject(Object key) {
		String cacheKey = String.valueOf(key.hashCode());
		cacheKeys.remove(cacheKey);
		return MemCacheManage.delete(cacheKey);
	}

	@Override
	public void clear() {
		for (int i = 0; i < cacheKeys.size(); i++) {
			String cacheKey = cacheKeys.get(i);
			MemCacheManage.delete(cacheKey);
		}
		cacheKeys.clear();
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return this.readWriteLock;
	}

}
