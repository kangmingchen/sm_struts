package com.x.reload;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @Author Chenkangming
 * @Date 2014-9-26
 * @version 1.0
 */
public class ReLoadManager {
	private static final ReLoadManager manager = new ReLoadManager();

	ExecutorService service;

	public static ReLoadManager getInstance() {
		return manager;
	}

	private ReLoadManager() {
		service = Executors.newSingleThreadExecutor();
	}

	/**
	 * 执行重载命令
	 */
	public void reload() {
		service.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("lll");
				 Thread current = Thread.currentThread();
				 System.out.println(current.getId());
			}
		});
	}

	public static void main(String[] args) {
			ReLoadManager.getInstance().reload();
			System.out.println("nnnnnnnnn");
	}
}
