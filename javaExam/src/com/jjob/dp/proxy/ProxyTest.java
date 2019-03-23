package com.jjob.dp.proxy;

/*
 * Proxy pattern : the original class must has a interface already. so the proxy class can proxy it.
 */

public class ProxyTest {
	public static void main(String[] args) 
	{  
        Isource source= new SourceProxy();  
        source.method();  
	}

}

class Source implements Isource 
{

	@Override
	public void method() 
	{
		// TODO Auto-generated method stub
		System.out.println("the original method implement!");  
	}
}


class SourceProxy implements Isource{
	
	private Source source;  
    public SourceProxy(){  
        super();  
        this.source = new Source();  
    }  														
    
    @Override  
    public void method() {  
        before();  
        source.method();  
        atfer();  
    }  
    
    private void atfer() {  
        System.out.println("after proxy!");  
    }  
    
    private void before() {  
        System.out.println("before proxy!");  
    }  

}

interface Isource {
	public void method();

}

