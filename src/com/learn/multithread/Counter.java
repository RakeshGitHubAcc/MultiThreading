package com.learn.multithread;

import java.util.concurrent.atomic.AtomicInteger;

//Creates Thread by extending java.lang.Thread class
public class Counter extends Thread {
	AtomicInteger count = new AtomicInteger();

	// method where thread execution will start
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is executing ..." + count.incrementAndGet());
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " is executing...");
		Counter counter = new Counter();
		Thread t1 = new Thread(counter);
		Thread t2 = new Thread(counter);
		t1.start();
		t2.start();
	}
}
