package com.jjob.abstractFactory;

public class abstractFactoryDemo
{
	public static void main(String[ ] args) 
	{  
		FactoryProvider  provider = new SendMailFactory();  
		Sender sender = provider.produce();  
		sender.Send();  
	}
}

interface FactoryProvider {  
    public Sender produce();  
}  

class SendSmsFactory implements FactoryProvider{  
	  
    @Override  
    public Sender produce() {  
        return new SmsSender();  
    }  
}  

class SendMailFactory implements FactoryProvider{  
    
    @Override  
    public Sender produce(){  
        return new MailSender();  
    }  
}  

/*class MailSender implements Sender {  
    @Override  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}  

class SmsSender implements Sender {  
    @Override  
    public void Send() {  
        System.out.println("this is sms sender!");  
    }  
}  
 
 interface Sender {  
	    public void Send();  
	}  */