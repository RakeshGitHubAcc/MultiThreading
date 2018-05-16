package com.learn.multithread;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {
	private int count = 0;
	private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

	public synchronized void produce() {
		while (true) {
			try {
				wait(100);
			} catch (InterruptedException e) {
			}
			if (queue.isEmpty()) {
				count++;
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {

				}
				queue.add(count);
				System.out.println(Thread.currentThread().getName() + " produced ..." + count);
				notifyAll();
			}
		}
	}

	public synchronized void consume() {
		while (true) {
			try {
				wait(100);
			} catch (InterruptedException e) {
			}
			if (!queue.isEmpty()) {
				Integer consumed = queue.remove();
				System.out.println(Thread.currentThread().getName() + " consumed ..." + count);
				notifyAll();
			}
		}
	}
}
