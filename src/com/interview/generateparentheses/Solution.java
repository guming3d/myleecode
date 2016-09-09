package com.interview.generateparentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *  Given n pairs of parentheses, write a function to generate all
 *   combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(calculateQuot("#(#)#"));
		generateParenthesis(3);
		//System.out.println(replaceChar(2,"123456789","abc"));

	}
	public static List<String> generateParenthesis(int n) {
		
        Set<String> finalStrSet=new HashSet<>();
        Set<String> tmpSet=new HashSet<>();
        Stack<String> tmpStack=new Stack<>();
        String initStr="#(#)#";
        tmpStack.push(initStr);
//        tmpSet.add(initStr);
        
        while(!tmpStack.isEmpty())
        {
        	String curStr=tmpStack.pop();
        	if(calculateQuot(curStr)==n*2)
        	{
        		//curStr is full length, need to insert it to final Set
        		if(!finalStrSet.contains(curStr))
        		{
        			finalStrSet.add(curStr);
        		}
        	}else{
        		 if(tmpSet.contains(curStr)) 
        		 {
        			 continue;
        		 }
        		 tmpSet.add(curStr);
				for (int i = 0; i < curStr.length(); i=i+2) {
					if (curStr.charAt(i) == '#') {
						String newStr = replaceChar(i, curStr, "#(#)#");

						if (calculateQuot(newStr) == n * 2) {
							if (finalStrSet.contains(newStr)) {
								continue;
							} else {
								finalStrSet.add(newStr);
							}
						} else {
							
							if(!tmpStack.contains(newStr))
							{
								tmpStack.push(newStr);
							}
						}
					}
				}

			}
		}
        
        List<String> result=new ArrayList<>();
        finalStrSet.stream().forEach(item->{
        	result.add(item.replaceAll("#", ""));
        });
        return result;
    }
	
public static List<String> generateParenthesis2(int n) {
		
        Set<String> finalStrSet=new HashSet<>();
        Set<String> tmpSet=new HashSet<>();
        Stack<String> tmpStack=new Stack<>();
        String initStr="()";
        tmpStack.push(initStr);
//        tmpSet.add(initStr);
        
        while(!tmpStack.isEmpty())
        {
        	String curStr=tmpStack.pop();
        	if(curStr.length()==n*2)
        	{
        		//curStr is full length, need to insert it to final Set
        		if(!finalStrSet.contains(curStr))
        		{
        			finalStrSet.add(curStr);
        		}
        	}else{
        		 if(tmpSet.contains(curStr)) 
        		 {
        			 continue;
        		 }
        		 tmpSet.add(curStr);
				for (int i = 0; i < curStr.length(); i++) {
						String newStr = insertLeftChar2(i, curStr, "()");
						if (newStr.length() == n * 2) {
							if (finalStrSet.contains(newStr)) {
								continue;
							} else {
								finalStrSet.add(newStr);
							}
						} else {
							
							if(!tmpStack.contains(newStr))
							{
								tmpStack.push(newStr);
							}
						}

				}

			}
		}
        
        List<String> result=new ArrayList<>();
        finalStrSet.stream().forEach(item->{
        	result.add(item);
        });
        return result;
    }
	public static String replaceChar(int index,String originStr,String replacedStr)
	{
		StringBuilder strBuilder=new StringBuilder();
		String tailPart=originStr.substring(index+1,originStr.length());
		strBuilder.append(originStr.substring(0, index));
		strBuilder.append(replacedStr);
		strBuilder.append(tailPart);
		return strBuilder.toString();
	}
	
	public static String insertLeftChar2(int index,String originStr,String replacedStr)
	{
		StringBuilder strBuilder=new StringBuilder();
		String tailPart=originStr.substring(index,originStr.length());
		strBuilder.append(originStr.substring(0, index));
		strBuilder.append(replacedStr);
		strBuilder.append(tailPart);
		return strBuilder.toString();
		
	}
	
	public static int calculateQuot(String inputStr)
	{
		int size=0;
		return inputStr.replaceAll("#", "").length();
	}
}
