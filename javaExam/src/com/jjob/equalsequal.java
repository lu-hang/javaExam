package com.jjob;

public class equalsequal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abc";
		String s2 = "abc";
		String s3= new String ("abc");
		s3=s3.intern();
		System.out.println("s1 == s2 is:" );
		System.out.println(s1 == s2);
		System.out.println("s1 equals s2 is:" + s1.equals(s2));

	}

}
