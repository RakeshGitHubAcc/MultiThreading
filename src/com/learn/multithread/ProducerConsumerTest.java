package com.learn.multithread;

public class ProducerConsumerTest {

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumer pc = new ProducerConsumer();

		// spawn a new producer thread and start
		Thread producer = new Thread(new ProducerThread(pc));
		producer.start();

		Thread.sleep(10); // main thread sleeps for 1 second

		// spawn a new consumer thread and start
		Thread consumer = new Thread(new ConsumerThread(pc));
		consumer.start();
	}

}
