package com.jjob.reflect;

import java.lang.reflect.Constructor;  
import java.lang.reflect.Field;  
import java.lang.reflect.InvocationTargetException;  
import java.lang.reflect.Method;  
import java.util.ArrayList;  
import java.util.List; 

public class MyReflect {
	/** 
        
     * Description: Use reflect method to access the fields and methods of DataTypebean  
     */  
    public static void main(String[] args) throws ClassNotFoundException,  
            SecurityException, NoSuchMethodException, InstantiationException,  
            IllegalAccessException, IllegalArgumentException,  
            InvocationTargetException  
    {  
        int iInt = 2012;  
        String sStr = "This a string!";  
        String[] saStr = new String[] { "First item of the string array",  
                "Second item of the string array",  
                "Third item of the string array" };  
        List<Integer> oList = new ArrayList<Integer>();  
  
        // Initialize the oList  
        int i = 0;  
        while (i < 3)  
        {  
            oList.add(i);  
            i++;  
        }  
        // get class  
        Class oClass = Class.forName("com.jjob.reflect.DataTypeBean");  
        // get the toString method, a method without parameters  
        Method oToStringMethod = oClass.getMethod("toString");  
        // get the addDataToList method, a method with parameters  
        Method oAddDataToListMethod = oClass.getMethod("addDataToList",  
                int.class, int.class);  
  
        // used default constructor to initialize a object  
        Object oDefalutObject = oClass.newInstance();  
  
        // access fields process, getDeclaredFields can access private and  
        // protected fields  
        Field[] oFields = oClass.getDeclaredFields();  
        for (int j = 0; j < oFields.length; j++)  
        {  
            // to access the private  
            oFields[j].setAccessible(true);  
  
            // getSimpleName method can get the type of the field, according the  
            // field type set the data to the field  
            if ("int".equals(oFields[j].getType().getSimpleName()))  
            {  
                oFields[j].setInt(oDefalutObject, iInt);  
            }  
            else if ("String[]".equals(oFields[j].getType().getSimpleName()))  
            {  
                oFields[j].set(oDefalutObject, saStr);  
            }  
            else if ("String".equals(oFields[j].getType().getSimpleName()))  
            {  
                oFields[j].set(oDefalutObject, sStr);  
            }  
            else if ("List".equals(oFields[j].getType().getSimpleName()))  
            {  
                oFields[j].set(oDefalutObject, oList);  
            }  
        }  
  
        // print the object  
        String sBeanString = (String) oToStringMethod.invoke(oDefalutObject);  
        System.out  
                .println("the string of the object created by defaut constructor: "  
                        + sBeanString);  
  
        // initialize the parameters for customized constructor, the oList will  
        // be initialized by the method with parameters  
        iInt = 2013;  
        sStr = "This another string!";  
        saStr = new String[] { "1st item of the string array",  
                "2nd item of the string array", "3rd item of the string array" };  
        oList = new ArrayList<Integer>();  
  
        // used customized constructor to initialize a object: DataTypeBean(int  
        // iInt, String sStr, String[] saStr, List<Integer> oList)  
        Constructor oCon = oClass.getConstructor(int.class, String.class,  
                String[].class, List.class);  
        Object oCustomizedObject = oCon.newInstance(iInt, sStr, saStr, oList);  
        //Use the method with parameters initialize the List Object  
        oAddDataToListMethod.invoke(oCustomizedObject,2013,2015);  
          
        // print the object  
        sBeanString = (String) oToStringMethod.invoke(oCustomizedObject);  
        System.out  
                .println("the string of the object created by customized constructor: "  
                        + sBeanString);  
    }  
}  


