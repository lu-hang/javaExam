/*
 * 
 */
package com.jjob.bridge;

public class BridgeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bridge bridge = new MyBridge();  
        
        /*调用第一个对象*/  
        Sourceable source1 = new SourceSub1();  
        bridge.setSource(source1);  
        bridge.method();  
          
        /*调用第二个对象*/  
        Sourceable source2 = new SourceSub2();  
        bridge.setSource(source2);  
        bridge.method();  
	}

}

class MyBridge extends Bridge {  
    public void method(){  
        getSource().method();  
    }  
}  

abstract class Bridge {  
    private Sourceable source;  
  
    public void method(){  
        source.method();  
    }  
      
    public Sourceable getSource() {  
        return source;  
    }  
  
    public void setSource(Sourceable source) {  
        this.source = source;  
    }  
}  

interface Sourceable {  
    public void method(); 
}

 class SourceSub1 implements Sourceable {  
	  
    @Override  
    public void method() {  
        System.out.println("this is the 1st sub!"); 
    }
}
    
  class SourceSub2 implements Sourceable {  
    	  
        @Override  
        public void method() {  
            System.out.println("this is the 2nd sub!"); 
    }
 }