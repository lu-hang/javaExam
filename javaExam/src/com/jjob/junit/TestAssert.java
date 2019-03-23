package com.jjob.junit;




import org.junit.Assert;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;



import org.junit.Test;



public class TestAssert{
   @Test
   public void testAdd() {
      //test data
      int num= 5;
      String temp= null;
      String str= "Junit is working fine";

      //check for equality
      Assert.assertEquals("Junit is working fine", str);

      //check for false condition
      Assert.assertFalse(num > 6);

      //check for not null value
      Assert.assertNotNull(str);
   }
}

