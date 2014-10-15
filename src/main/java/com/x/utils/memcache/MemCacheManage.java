package com.x.utils.memcache;

import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import com.x.utils.SpringContextHolder;

public class MemCacheManage {

	private static Logger log = Logger.getLogger("memcached");

	private static MemcachedClient client = (MemcachedClient) SpringContextHolder.getBean("memcachedCilent");

	public MemCacheManage() {

	}

	/**
	 * 删除
	 * 
	 * @param key
	 * @return
	 */
	public static boolean delete(String key) {
		boolean flag = false;
		try {
			flag = client.delete(key);
		} catch (TimeoutException e) {
			log.error(e);
		} catch (InterruptedException e) {
			log.error(e);
		} catch (MemcachedException e) {
			log.error(e);
		}
		return flag;
	}

	// 获取缓存内容
	public static Object get(String key) {
		try {
			return client.get(key);
		} catch (TimeoutException e) {
			log.error(e);
		} catch (InterruptedException e) {
			log.error(e);
		} catch (MemcachedException e) {
			log.error(e);
		}
		return null;
	}

	// 设置缓存内容
	public static boolean add(String name, Object value) {
		boolean ret = false;
		try {
			ret = client.add(name, 0, value);
			if (!ret) {
				ret = client.replace(name, 0, value);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return ret;
	}

	/**
	 * 设置缓存内容
	 * 
	 * @param name
	 *            key值
	 * @param value
	 * @param time
	 *            缓存有效时长,以毫秒计算
	 * @return boolean
	 */
	public static boolean add(String name, Object value, long time) {
		boolean ret = false;
		try {
			time = time / 1000;
			ret = client.add(name, 0, value, time);
			if (!ret) {
				ret = client.replace(name, 0, value, time);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return ret;
	}
}
