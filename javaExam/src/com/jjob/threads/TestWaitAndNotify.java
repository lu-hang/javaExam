package com.jjob.threads;

import java.util.ArrayList;
import java.util.List;

public class TestWaitAndNotify {
	
	public static void main(String[] args)
	   {
	      List<Integer> taskQueue = new ArrayList<Integer>();
	      int MAX_CAPACITY = 10;
	      Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
	      Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer1");
	      Thread tConsumer2 = new Thread(new Consumer2(taskQueue), "Consumer2");
	      tProducer.start();
	      tConsumer.start();
	      tConsumer2.start();
	      
	      //System.out.println("Main process+ " Thread.currentThread().getName() );
	   }

}


class Producer implements Runnable {
	
	private final List<Integer> taskQueue;
	   private final int           MAX_CAPACITY;
	 
	   public Producer(List<Integer> sharedQueue, int size)
	   {
	      this.taskQueue = sharedQueue;
	      this.MAX_CAPACITY = size;
	   }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int counter = 0;
	      while (true)
	      {
	         try
	         {
	            produce(counter++);
	         }
	         catch (InterruptedException ex)
	         {
	            ex.printStackTrace();
	         }
	      }

	}
	
	 private void produce(int i) throws InterruptedException
	   {
	      synchronized (this.taskQueue)
	      {
	         while (taskQueue.size() == MAX_CAPACITY)
	         {
	            System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
	            taskQueue.wait();
	         }
	           
	         Thread.sleep(1000);
	         taskQueue.add(i);
	         System.out.println("Produced: " + i);
	         taskQueue.notifyAll();
	      }//end of synchronized
	   }

}

class Consumer implements Runnable
{
   private final List<Integer> taskQueue;
 
   public Consumer(List<Integer> sharedQueue)
   {
      this.taskQueue = sharedQueue;
   }
 
   @Override
   public void run()
   {
      while (true)
      {
         try
         {
            consume();
         } catch (InterruptedException ex)
         {
            ex.printStackTrace();
         }
      }
   }
 
   private void consume() throws InterruptedException
   {
      synchronized (this.taskQueue)
      {
         while (taskQueue.isEmpty())
         {
            System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
            taskQueue.wait();
         }
         Thread.sleep(2000);
         int i = (Integer) taskQueue.remove(0);
         System.out.println("consumer1 Consumed: " + i);
         taskQueue.notifyAll();
      }//end of sync
   }
}

class Consumer2 implements Runnable
{
   private final List<Integer> taskQueue;
 
   public Consumer2(List<Integer> sharedQueue)
   {
      this.taskQueue = sharedQueue;
   }
 
   @Override
   public void run()
   {
      while (true)
      {
         try
         {
            consume();
         } catch (InterruptedException ex)
         {
            ex.printStackTrace();
         }
      }
   }
 
   private void consume() throws InterruptedException
   {
      synchronized (this.taskQueue)
      {
         while (taskQueue.isEmpty())
         {
            System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
            taskQueue.wait();
         }
         Thread.sleep(2000);
         int i = (Integer) taskQueue.remove(0);
         System.out.println("comsumer2 Consumed: " + i);
         taskQueue.notifyAll();
      }//end of sync
   }
}



