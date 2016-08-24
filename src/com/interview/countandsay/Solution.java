package com.interview.countandsay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 * @author mcgu
 *
 */
public class Solution {
	static Map<Integer,String> countMap=new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 countMap.put(1, "1");
	     countMap.put(2, "11");
	     countMap.put(3,"21");
	     System.out.println(countAndSay(5));
	}
	 public static String countAndSay(int n) {
	     if(n==1)
	     {
	    	 return "1";
	     }
	     
		 //String prevStr=countMap.get(n-1);
		 String prevStr=countAndSay(n-1);
		 
	     Stack<Character> numStack=new Stack<>();
	     String finalStr="";
	     
	     for (int i = 0; i < prevStr.length(); i++) {
			if(numStack.isEmpty())
			{
				numStack.push(prevStr.charAt(i));
			}
			else{
				if(prevStr.charAt(i)==numStack.peek())
				{
					numStack.push(prevStr.charAt(i));
				}else{
					//pop up all the characters in the stack 
					int number=numStack.size();
					char item=numStack.peek();
					finalStr+=Integer.toString(number)+item;
					numStack.clear();
					numStack.push(prevStr.charAt(i));
				}
			}
		}
	     	//pop up all the characters in the stack 
			int number=numStack.size();
			char item=numStack.peek();
			finalStr+=Integer.toString(number)+item;
			
		 
	        return finalStr;
	        
	    }
	
}
