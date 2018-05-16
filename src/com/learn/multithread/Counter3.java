package com.learn.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter3 implements Callable<String> {
	private static final int THREAD_POOL_SIZE = 2;
	private AtomicInteger count = new AtomicInteger();

	@Override
	public String call() throws Exception {
		return Thread.currentThread().getName() + " is executing..." + count.incrementAndGet();
	}

	public void main(String[] args) throws InterruptedException, ExecutionException {
		// create a pool of two threads
		ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		Counter counter = new Counter();
		Future<String> f1 = (Future<String>) executor.submit(counter); // producer
		Future<String> f2 = (Future<String>) executor.submit(counter); // producer
		System.out.println(Thread.currentThread().getName() + " is executing...");
		// asynchronously get from worker thread
		System.out.println(f1.get());
		System.out.println(f2.get());

	}

}
