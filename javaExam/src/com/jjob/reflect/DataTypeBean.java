package com.jjob.reflect;

import java.util.*;

public class DataTypeBean {
	private int iInt;  
    private String sStr;  
    private String[] saStr;  
    List<Integer> oList;  
  
    // default constructor  
    public DataTypeBean()  
    {  
    	System.out.println("public DataTypeBean() is called");
    }  
  
    // constructor with parameters  
    public DataTypeBean(int iInt, String sStr, String[] saStr,  
            List<Integer> oList)  
    {  
        this.iInt = iInt;  
        this.saStr = saStr;  
        this.sStr = sStr;  
        this.oList = oList;  
        System.out.println("public DataTypeBean(,,,) is called");
    }  
  
    // method with parameter, it will set value of the list field  
    public void addDataToList(int iStart, int iEnd)  
    {  
        if (iStart < iEnd)  
        {  
            oList = new ArrayList<Integer>();  
            while (iStart <= iEnd)  
            {  
                oList.add(iStart);  
                iStart++;  
            }  
        }  
    }  
  
    // method without parameter  
    public String toString()  
    {  
        StringBuffer sbStr = new StringBuffer();  
        sbStr.append("Values of the fields of DataTypeBean: iInt = ");  
        sbStr.append(this.iInt).append(" ; ");  
        for (int i = 0; i < this.saStr.length; i++)  
        {  
            sbStr.append("saStr").append("[").append(i).append("]").append(  
                    " = ").append(saStr[i]).append(" ; ");  
        }  
  
        for (int j = 0; j < this.oList.size(); j++)  
        {  
            sbStr.append("oList.get").append("(").append(j).append(")").append(  
                    " = ").append(oList.get(j)).append(" ; ");  
        }  
        return sbStr.toString();  
    }  

}
