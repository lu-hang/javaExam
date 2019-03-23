package com.jjob.dp.adapter;

public class AdapterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        ITarget target = new Adapter();  
	        target.methodINsource();  
	        target.methodINtarget();  
	    }  

	}

class Source {  
	  
    public void methodINsource() {  
        System.out.println("this is original method!");  
    }

	
}  

interface ITarget{  
	  
    /* 与 Source 中的方法相同 , not need rewrite it again*/  
    public void methodINsource();  
  
    /* 新类的方法 */  
    public void methodINtarget();  
}  

class Adapter extends Source implements ITarget{  
	  
    @Override  
    public void methodINtarget() {  
        System.out.println("this is the targetable method!");  
    }  
}  