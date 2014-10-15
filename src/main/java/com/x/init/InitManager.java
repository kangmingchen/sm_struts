package com.x.init;



/**
 * <p>Description:Spring 容器启动时自动初始化</p>
 * @Author Chenkangming 
 * @Date 2014-9-26
 * @version 1.0
 */
public class InitManager {
	
	/**
	 * 启动执行
	 */
	public void init(){
		System.out.println("Spring Init Start ...");
	}
	
	/**
	 * 关闭执行
	 */
	public void clear(){
		System.out.println("Spring Init Close ....");
	}
	
}
