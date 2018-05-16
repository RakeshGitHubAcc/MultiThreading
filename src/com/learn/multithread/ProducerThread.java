package com.learn.multithread;

public class ProducerThread implements Runnable {
	private ProducerConsumer pc;

	public ProducerThread(ProducerConsumer pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		pc.produce();
	}

}
