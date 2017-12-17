package com.comcurrent.base;

//军队线程
//模拟作战双方的行为
public class ArmyRunnable implements Runnable {

	//volatile保证了线程可以正确的读取其他线程写入的值
    //可见性 ref JMM， happens-before原则
	volatile boolean keepRunning=true;
	
	@Override
	public void run() {
		while(keepRunning) {
			//发动五次攻击
			for(int i=0;i<5;i++) {
				System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]");
				//让出处理器的时间，使选择攻击方使随机性的
				Thread.yield();
			}
		}
		
		System.out.println(Thread.currentThread().getName()+"结束了战斗！");

	}

}
