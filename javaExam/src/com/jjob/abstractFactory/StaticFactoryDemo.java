package com.jjob.abstractFactory;

public class StaticFactoryDemo {
	
	public static void main(String[] args) {  
        //SendFactory factory = new SendFactory();  
        Sender sender = SendFactory.produceMail( );  
        sender.Send();  
	}
}

class SendFactory {  
    
    public static Sender produceMail(){  
        return new MailSender();  
    }  
      
    public static Sender produceSms(){  
        return new SmsSender();  
    }  
}  

interface Sender {  
    public void Send();  
}  

class MailSender implements Sender {  
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





