package com.learn.multithread;

import java.util.concurrent.atomic.AtomicInteger;
//create Thread implementing Runnable
public class Counter2 implements Runnable {

	AtomicInteger count = new AtomicInteger();

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is executing ..." + count.incrementAndGet());

	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " is executing ...");
		Counter2 counter = new Counter2();
		Thread t1 = new Thread(counter);
		Thread t2 = new Thread(counter);
		t1.start();
		t2.start();
	}

}
