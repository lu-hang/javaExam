package com.jjob.threads;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentList {
	
	public static void main(String[] args)
    {
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<String>();
        Thread threads[] = new Thread[100];
 
        for (int i = 0; i < threads.length; i++) {
            AddTask task = new AddTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d AddTask threads have been launched\n", threads.length);
 
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: Size of the List: %d\n", list.size());
 
        for (int i = 0; i < threads.length; i++) {
            RemoveTask task = new RemoveTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d RemoveTask threads have been launched\n", threads.length);
 
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: Size of the List: %d\n", list.size());
    }
}


class AddTask implements Runnable {
	
	ConcurrentLinkedDeque<String> taskList;

	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000; i++) {
        	taskList.add(name + ": Element " + i);
        }
	} 
	
	public AddTask(ConcurrentLinkedDeque<String>   aList)
	{
		this.taskList= aList;
	}

}

class RemoveTask implements Runnable {
	 
    private ConcurrentLinkedDeque<String> list;
 
    public RemoveTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }
 
    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            list.pollFirst();
            list.pollLast();
        }
    }
}


