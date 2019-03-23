package com.jjob.decorator;

public class DecorateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        Sourceable source = new Source();  
	        Sourceable dec_obj = new Decorator(source);  
	        dec_obj.method();  
	    }  
}

class Decorator implements Sourceable {  
	  
    private Sourceable source;  
      
    public Decorator(Sourceable source){  
        super();  
        this.source = source;  
    }  
    @Override  
    public void method() {  
        System.out.println("before decorator!");  
        source.method();  
        System.out.println("after decorator!");  
    }  
}  

class Source implements Sourceable {  
	  
    @Override  
    public void method() {  
        System.out.println("the original method!");  
    }  
}  

interface Sourceable {  
    public void method();  
}  
