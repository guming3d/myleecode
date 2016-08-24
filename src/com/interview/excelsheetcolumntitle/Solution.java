package com.interview.excelsheetcolumntitle;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convertToTitle2(17576);
	}
	 public static String convertToTitle(int n) {
	        Map<Integer,Character> columnMap=new HashMap<>();
	        char startChar='A';
	        for (int i = 1; i <= 26; i++) {
				columnMap.put(i, (char)(startChar+i-1));
			}
	        
	        if(n<=26)
	        {
	        	return columnMap.get(n).toString();
	        }
	        
	        int leftOver=n;
	        String finalResult="";
	        int rightMost;
	        char rightMostChar;
	        while(leftOver/26 > 0)
	        {
	        	rightMost=leftOver % 26;
	        	if(rightMost==0)
	        	{
	        		rightMost=26;
	        	}
	        	rightMostChar=columnMap.get(rightMost);
	        	finalResult=rightMostChar+finalResult;
	        	leftOver/=26;
	        }
	        rightMost=leftOver % 26;
        	rightMostChar=columnMap.get(rightMost);
        	finalResult=rightMostChar+finalResult;
        	System.out.println(finalResult);
	        return finalResult;
	    }
	 
	 public static String convertToTitle2(int n) {
	        Map<Integer,Character> columnMap=new HashMap<>();
	        char startChar='A';
	        for (int i = 1; i <= 26; i++) {
				columnMap.put(i, (char)(startChar+i-1));
			}
	        
	        if(n<=26)
	        {
	        	return columnMap.get(n).toString();
	        }
	        int leftOver=n;
	        String finalResult="";
	        int rightMost;
	        char rightMostChar;
	        boolean isRightMost=false;
	        while(leftOver/26 > 0)
	        {
	        	isRightMost=false;
	        	rightMost=leftOver % 26;
	        	if(rightMost==0)
	        	{
	        		rightMost=26;
	        		isRightMost=true;
	        	}
	        	rightMostChar=columnMap.get(rightMost);
	        	finalResult=rightMostChar+finalResult;
	        	leftOver/=26;
	        	if(isRightMost)
	        	{
	        		leftOver--;
	        	}
	        }
	        if(leftOver!=0)
	        {
	        rightMost=leftOver % 26;
	        if(rightMost==0)
        	{
        		rightMost=26;
        		isRightMost=true;
        	}
        	rightMostChar=columnMap.get(rightMost);
        	finalResult=rightMostChar+finalResult;
        	
	        }
	        
	        
     	System.out.println(finalResult);
	        return finalResult;
	    }
}
