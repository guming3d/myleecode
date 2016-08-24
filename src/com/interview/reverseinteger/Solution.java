package com.interview.reverseinteger;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321 
 * @author guming
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverse(1534236469);
//		int aa=-15;
//		System.out.println(aa % 10);
	}
	  public static int reverse(int x) {
		  boolean lessZero=false;
		  if(x < 0)
		  {
			  lessZero=true;
			  x*=-1;
		  }
		  //now x is large zero
		  int charNumber=0;
		  List<Integer> myList=new ArrayList<>();
		  boolean rightStart=false;
		  while(x/10 != 0)
		  {
			  if(x % 10 ==0)
			  {
				  if(rightStart ==false)
				  {
					  x/=10;
					  continue;	  
				  }else{
					  myList.add(x % 10);
				  }
				  
			  }else{
				  rightStart=true;
				  myList.add(x % 10);
			  }
			  x/=10;
		  }
		  myList.add(x);
myList.forEach(item->{
	System.out.println(item);
});
System.out.println("---------------");
		String newNumber="";
		for (int i = 0; i < myList.size(); i++) {
			newNumber+=myList.get(i);
		}
		System.out.println(newNumber);
		int finalNumber;
		try{
			finalNumber=Integer.parseInt(newNumber);
		}catch(Exception e)
		{
			//e.printStackTrace();
			return 0;
		}
		if(lessZero==true)
		{
			finalNumber*=-1;
		}
		System.out.println(finalNumber);
	        return finalNumber;
	    }
}
