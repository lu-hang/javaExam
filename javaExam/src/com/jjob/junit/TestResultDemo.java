package com.jjob.junit;

import junit.framework.TestResult;

import org.junit.Test;

import com.jjob.Console;

import junit.framework.AssertionFailedError;
import junit.framework.TestResult;

public class TestResultDemo extends TestResult {
	
	public synchronized void addError(Test test, Throwable t) {
	      super.addError((junit.framework.Test) test, t);
	      Console.log("addError(Test test, Throwable t) is called");
	   }

	   // add the failure
	   public synchronized void addFailure(Test test, AssertionFailedError t) {
	      super.addFailure((junit.framework.Test) test, t);
	      Console.log("addFailure(Test test, AssertionFailedError t) is called");
	   }
	   
	   @Test
	   public void testAdd() {
	   // add any test
	   }

	   // Marks that the test run should stop.
	   public synchronized void stop() {
	   //stop the test here
	   }

}
