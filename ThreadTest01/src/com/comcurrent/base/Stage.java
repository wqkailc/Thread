package com.comcurrent.base;

public class Stage extends Thread {
	
	public void run() {
		System.out.println("*****欢迎观看节目表演*****");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("隋唐演义即将开始表演->->->");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ArmyRunnable armyOfSui=new ArmyRunnable();
		ArmyRunnable armyOfFary=new ArmyRunnable();
		
		//使用Runnable接口创建
		Thread armyOfSuiDynasty=new Thread(armyOfSui,"隋军");
		Thread armyOfFaryHan=new Thread(armyOfFary,"农民军");
		
	    //启动线程，军队开始作战
		armyOfSuiDynasty.start();
		armyOfFaryHan.start();
		
		try {
			//设置线程休眠
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("***双方正在交战，农民英雄连连战胜***");
		Thread nongHero=new KeyPersonThread();
		nongHero.setName("农民英雄");
		
		//停止军队作战
		//停止线程的方法
	    armyOfSui.keepRunning = false;
	    armyOfFary.keepRunning = false;
	    
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    //进入农民英雄作战
	    nongHero.start();
	    try {
			nongHero.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    System.out.println("农民军队胜利，建立大唐王朝");
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    System.out.println("*****节目表演完毕，谢谢观看*****");

	}

	public static void main(String[] args) {
		new Stage().start();
	}

}
