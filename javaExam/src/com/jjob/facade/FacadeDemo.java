package com.jjob.facade;

public class FacadeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeFacade facade= new ShapeFacade();
	     
	      facade.drawRectangle();
	      facade.drawSquare();
	}
}

class ShapeFacade {
	 
	   private Shape rectangle;
	   private Shape square;

	   public ShapeFacade (){
	      
	      rectangle = new Rectangle();
	      square = new Square();
	   }
	   

	  

	   public void drawRectangle(){
	      rectangle.draw();
	   }
	   public void drawSquare(){
	      square.draw();
	   }
	}

interface Shape
{
	void draw();
}

class Rectangle implements Shape {

	   @Override
	   public void draw() {
	      System.out.println("Rectangle::draw()");
	   }
	}


class Square implements Shape {

	   @Override
	   public void draw() {
	      System.out.println("Square::draw()");
	   }
	}



