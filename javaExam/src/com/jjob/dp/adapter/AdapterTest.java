package com.jjob.dp.adapter;

//import com.jjob.dp.adapter.ITarget;
/*
 * Adapter class has a  member of source class
 */
public class AdapterTest {
	public static void main(String[] args) {  
		Original source = new Original();  
		Targetable target = new Wrapper(source);  
		target.methodINsource();  
		target.methodINtarget(); 
	}
}

class Wrapper implements Targetable {  

	private Original source;  

	public Wrapper(Original source){  
		super();  
		this.source = source;  
	}  

	//@Override
	public void methodINtarget() {  
		System.out.println("this is the targetable method!");  
	}  


	public void methodINsource() {  
		source.methodINsource();
	}
}

interface Targetable{  
	  
    /* 与 Source 中的方法相同 , not need rewrite it again*/  
    public void methodINsource();  
  
    /* 新类的方法 */  
    public void methodINtarget();  
}  
    
class Original {  
	  
    public void methodINsource() {  
        System.out.println("this is original method!");  
    }

}  
    

   