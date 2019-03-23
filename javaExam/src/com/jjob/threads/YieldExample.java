package com.jjob.threads;

public class YieldExample {
	   public static void main(String[] args)
	   {
	      Thread producer = new Producer_num();
	      Thread consumer = new Consumer_num();
	       
	      producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
	      consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority
	      System.out.println("main thread:  "+ Thread.currentThread().getName());
	      producer.start();
	      consumer.start();
	   }
	}
	 
	class Producer_num extends Thread
	{
	   public void run()
	   {
		   System.out.println("producer run() "+ Thread.currentThread().getName());
	      for (int i = 0; i < 5; i++)
	      {
	         System.out.println("I am Producer : Produced Item " + i);
	         
	         Thread.yield();
	      }
	   }
	}
	 
	class Consumer_num extends Thread
	{
	   public void run()
	   {
	      for (int i = 0; i < 5; i++)
	      {
	         System.out.println("I am Consumer : Consumed Item " + i);
	         Thread.yield();
	         try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("I am Consumer and get error");
				e.printStackTrace();
			}
	      }
	   }
	}
