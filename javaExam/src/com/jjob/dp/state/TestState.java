package com.jjob.dp.state;

import com.jjob.dp.state.Context;
import com.jjob.dp.state.State;

public class TestState {
	
	public static void main(String[] args) {  
        
        State state = new State();  
        Context context = new Context(state);  
          
        //set first state 
        state.setValue("state1");  
        context.methodBYstate();  
          
        //set second state  
        state.setValue("state2");  
        context.methodBYstate();  
    }  

}

class Context {
	
	private State state;  
	  
    public Context(State state) {  
        this.state = state;  
    }  
  
    public State getState() {  
        return state;  
    }  
  
    public void setState(State state) {  
        this.state = state;  
    }  
  
    public void methodBYstate() {  
        if (state.getValue().equals("state1")) {  
            state.method1();  
        } else if (state.getValue().equals("state2")) {  
            state.method2();  
        }  
    }  

}

class State {
	
	private String stateValue;  
    
    public String getValue() {  
        return stateValue;  
    }  
  
    public void setValue(String value) {  
        this.stateValue = value;  
    }  
  
    public void method1(){  
        System.out.println("execute the first opt!");  
    }  
      
    public void method2(){  
        System.out.println("execute the second opt!");  
    }  

}