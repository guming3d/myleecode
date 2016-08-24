package com.interview.longestsubstringwithoutrepeatingcharacters;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters

    Total Accepted: 175973
    Total Submissions: 766609
    Difficulty: Medium

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lengthOfLongestSubstring2("aaaaaaaaaaaaaaaaabcdeaaaaaaaaaaaaaaaaaaaaa");
		//System.out.println("aaaa".substring(1, 2));
	}
	  public static int lengthOfLongestSubstring(String s) {
	       char[] charList=s.toCharArray();
	        if(s.length()==0 || s.length()==1)
	        {
	        	return s.length();
	        }
	        if(s.length()==2)
	        {
	            if(charList[0]==charList[1])
	            {
	                return 1;
	            }else{
	                return 2;
	            }
	        }
	        
	        int startIndex=0;
	        int endIndex=0;
	        int submaxLength=1;
	        int maxLength=1;
	        Map<Character,Integer> subCharMap=new HashMap<>();
	        
	        while(startIndex<s.length())
	        {
	        	for (int i = startIndex; i < s.length(); i++) {
					if(subCharMap.containsKey(s.charAt(i)))
					{
						//calculate the current max length and remove the char in map
						int dupIndex=subCharMap.get(s.charAt(i));
						if(subCharMap.size()>maxLength)
						{
							maxLength=subCharMap.size();
						}
						Iterator myIterator=subCharMap.entrySet().iterator();
						while(myIterator.hasNext())
						{
							//remove all item befor dup char
							Map.Entry<Character, Integer> currEntry=(Map.Entry<Character, Integer>)myIterator.next();
							if(currEntry.getValue()<=dupIndex)
							{
								myIterator.remove();
							}
						}
						startIndex=i;
						break;
					}else{
						subCharMap.put(s.charAt(i), i);
					}
					startIndex=i;
				}
	        	if(startIndex==s.length()-1)
	        	{
	        		if(subCharMap.size()>maxLength)
					{
						maxLength=subCharMap.size();
					}
	        		break;
	        	}
	        }
	        
	    
//	        maxLength=subCharMap.size();
	        System.out.println(maxLength);
	        return maxLength;
	    }
	  
	  public static int lengthOfLongestSubstring2(String s) {
	       char[] charList=s.toCharArray();
	        if(s.length()==0 || s.length()==1)
	        {
	        	return s.length();
	        }
	        if(s.length()==2)
	        {
	            if(charList[0]==charList[1])
	            {
	                return 1;
	            }else{
	                return 2;
	            }
	        }
	        
	        int startIndex=0;
	        int maxLength=1;
	        Map<Character,Integer> subCharMap=new HashMap<>();
	        StringBuilder sb=new StringBuilder();
	        while(startIndex<s.length())
	        {
	        	for (int i = startIndex; i < s.length(); i++) {
					if(sb.indexOf(s.substring(i, i+1))!=-1)
					{
						//calculate the current max length and remove the char in map
						if(sb.length()>maxLength)
						{
							maxLength=sb.length();
						}
						sb.delete(0,sb.indexOf(s.substring(i, i+1))+1);
						startIndex=i;
						break;
					}else{
						//subCharMap.put(s.charAt(i), i);
						sb.append(s.substring(i, i+1));
					}
					startIndex=i;
				}
	        	if(startIndex==s.length()-1)
	        	{
	        		if(sb.length()>maxLength)
					{
						maxLength=sb.length();
					}
	        		break;
	        	}
	        }
	        
	    
//	        maxLength=subCharMap.size();
	        System.out.println(maxLength);
	        return maxLength;
	    }
}
