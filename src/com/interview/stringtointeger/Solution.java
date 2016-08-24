package com.interview.stringtointeger;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, 
please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. 
If you still see your function signature accepts a const char * argument,
 please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("-9223372036854775809"));
	}
	public static int myAtoi(String str) {
        char[] numberCharList=new char[str.length()];
        boolean largerZero=true;
        
        if(str.length()==0)
        {
        	return 0;
        }
        
       
        for (int i = 0; i < str.length(); i++) {
        	numberCharList[i]=str.charAt(i);
		}
        
        
        boolean startSecond=false;
        int leftIndex=0;
        for (int i = 0; i < str.length(); i++) {
        	if(!((str.charAt(i)=='+')||
        	   (str.charAt(i)=='-')||
        	   (str.charAt(i)>='0' && str.charAt(i) <='9')))
        	{  
        		if(str.charAt(i)==' ')
        		{
        			continue;
        		}else{
        			return 0;
        		}
        	}else{
        		leftIndex=i;
        		break;
        	}
		}
        
        
        if(numberCharList[leftIndex]=='-')
        {
        	largerZero=false;
        	startSecond=true;
        }else if(numberCharList[leftIndex]=='+'){
        	largerZero=true;
        	startSecond=true;
        }
        
        List<Integer> numberList=new ArrayList<>();
        boolean leftStart=false;
        for (int i = startSecond?leftIndex+1:leftIndex+0; i < numberCharList.length; i++) {
        	if(numberCharList[i]<'0' || numberCharList[i]>'9' )
        	{
        		//no need to walk through the following number
        		break;
        	}
        	
        	int currNumber=numberCharList[i]-'0';
        	if(currNumber==0)
        	{
        		if(leftStart!=true)
            	{
            		continue;
            	}
        	}else{
        		leftStart=true;
        	}
        	numberList.add(currNumber);
		}
        
        //try to change this Number to int
        long totalNumber=0;
        for (int i = 0; i < numberList.size(); i++) {
        	if(totalNumber>=Integer.MAX_VALUE)
        	{
        		if(largerZero)
        		{
        			return Integer.MAX_VALUE;
        		}else{
        			return Integer.MIN_VALUE;
        		}
        	}else{
        		totalNumber=totalNumber*10+numberList.get(i);
        	}
			
		}
        
       
        
        if(!largerZero)
		{
        	totalNumber=totalNumber * -1;
		}
        
        if(totalNumber>=Integer.MAX_VALUE)
    	{
    		
    		return Integer.MAX_VALUE;
    	}
        
        if(totalNumber<=Integer.MIN_VALUE)
    	{
    		return Integer.MIN_VALUE;
    	}
        return (int) totalNumber;
    }
}
