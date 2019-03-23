package com.jjob.builder;

import java.util.ArrayList;
import java.util.List;

import com.jjob.builder.BuilderTest.Sender;

public class BuilderTest {
	public static void main(String[] args) {  
        Builder builder = new Builder();  
        builder.produceMailSender(1);
        builder.produceSmsSender(1);
        builder.showList();

}

    interface Sender {  
	    public void Send();  
	}  
}

class SmsSender implements Sender {  
	  
    @Override  
    public void Send() {  
        System.out.println("this is sms sender!");  
    }  
}  

class MailSender implements Sender {  
    @Override  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}  

class Builder {  
    
    private List<Sender> list = new ArrayList<Sender>();  
      
    public void produceMailSender(int count){  
        for(int i=0; i<count; i++){  
            list.add(new MailSender());  
        }  
    }  
      
    public void produceSmsSender(int count){  
        for(int i=0; i<count; i++){  
            list.add(new SmsSender());  
        }  
    }  
    
    public void showList(){
    	int j= list.size();
    	for(int i=0;i<j;i++){
    	System.out.println(list.get(i).toString());
    	}
    }
}  