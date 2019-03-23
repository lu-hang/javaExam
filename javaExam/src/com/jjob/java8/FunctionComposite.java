package com.jjob.java8;

import java.util.function.Predicate;

public class FunctionComposite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Predicate<String>  startWith = (_text) -> _text.startsWith("A");
		Predicate<String>  endWith = (_text) -> _text.endsWith("x");
		
		Predicate<String> composed = startWith.and(endWith);
		
		boolean result1 = startWith.test("A hardworking person must relax sometimes");
		
		System.out.println("result1="+result1);
		
		String input = "A hardworking person must relax sometimes";
		boolean result = composed.test(input);
		System.out.println("result="+result);

	}

}
