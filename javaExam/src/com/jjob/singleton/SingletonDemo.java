package com.jjob.singleton;

public class SingletonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//illegal construct
	      //Compile Time Error: The constructor SingleObject() is not visible
	      //SingleObject object = new SingleObject();

	      //Get the only object available
	      SingleObject object = SingleObject.getInstance();

	      //show the message
	      object.showMessage();

	}

}

class SingleObject {

	   //create an object of SingleObject
	   private static class LazyHolder{
		   private static final SingleObject  INSTANCE = new SingleObject();
	   }

	   //make the constructor private so that this class cannot be
	   //instantiated
	   private SingleObject(){}

	   //Get the only object available
	   public static  synchronized SingleObject getInstance(){
	      return LazyHolder.INSTANCE;
	   }

	   public void showMessage(){
	      System.out.println("Hello World!");
	   }
	   
	}
/*
class SingleObject {

	   //create an object of SingleObject
	   private static SingleObject instance = new SingleObject();

	   //make the constructor private so that this class cannot be
	   //instantiated
	   private SingleObject(){}

	   //Get the only object available
	   public static  SingleObject getInstance(){
	      return instance;
	   }

	   public void showMessage(){
	      System.out.println("Hello World!");
	   }
	   
	}

*/
