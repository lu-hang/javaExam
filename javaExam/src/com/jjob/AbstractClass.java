package com.jjob;

public abstract class AbstractClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("show a abstract class");
		String s3 = "JournalDev";
		int start = 1;
		char end = 5;
		System.out.println(start + end);
		System.out.println(s3.substring(start, end));

	}
	
	public AbstractClass()
	{}
	
	abstract void amethod();

}
