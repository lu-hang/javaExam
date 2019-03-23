package com.jjob.threads;

import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;
import java.util.Random;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CallableTest {
	public static void main(String[] args) throws ExecutionException,
	InterruptedException {
		System.out.println("----program start----");
		Date date1 = new Date();

		int taskSize = 5;
		// create a thread pool
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		// create mutil task with return value
		List<Future> list = new ArrayList<Future>();
		for (int i = 0; i < taskSize; i++) {
			Callable mycall = new MyCallable(i + " ");
			// execute and get Future object
			Future f = pool.submit(mycall);
			 System.out.println( "<"+ f.get().toString() +">");
			list.add(f);
		}
		// close pool
		pool.shutdown();

		// get concurrent 
		for (Future f : list) {
			// get return from Future obj，and output
			System.out.println(">>>" + f.get().toString());
		}

		Date date2 = new Date();
		System.out.println("----program run finish----，running time ["
				+ (date2.getTime() - date1.getTime()) + "mil sencond]");
	}
}

class MyCallable implements Callable<Object> 
{
	private String taskNum;
	//Random randomum;

	MyCallable(String taskNum) {
		this.taskNum = taskNum;
		//Random randomum =new Random();
	}

	public Object call() throws Exception 
	{
		System.out.println(">>>" + taskNum + "task start");
		Date dateTmp1 = new Date();
		
		Random randomum =new Random(100);
		
		Thread.sleep(1000);
		
		Date dateTmp2 = new Date();
		long time = dateTmp2.getTime() - dateTmp1.getTime();
		System.out.println(">>>" + taskNum + "task end");
		return taskNum + "task return result,currentr task time[" + time + "mil seconds]";
	}

}
