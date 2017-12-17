package com.comcurrent.base;

//人物线程

public class KeyPersonThread extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName()+"开始战斗!");
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"攻击隋军"+"["+i+"]");
			
		}
		System.out.println(Thread.currentThread().getName()+"结束了战争！");
	}

}
