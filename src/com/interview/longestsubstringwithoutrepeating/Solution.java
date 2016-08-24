package com.interview.longestsubstringwithoutrepeating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @author guming
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lengthOfLongestSubstring3("pwwkew");
	}
	
	public static int lengthOfLongestSubstring(String s) {
        char[] charList=s.toCharArray();
        Map<Character,Integer> charMap=new HashMap<>();
        Set<Character> dupList=new HashSet<>();
        for (int i = 0; i < charList.length; i++) {
			if(charMap.containsKey(charList[i]))
			{
				charMap.replace(charList[i], charMap.get(charList[i])+1);
				dupList.add(charList[i]);
			}else{
				charMap.put(charList[i], 1);
			}
		}
        List<String> subStrList=new ArrayList<>();
        for(char item:dupList)
        {
        	String[] subStr=s.split(Character.toString(item));
        	for (int i = 0; i < subStr.length; i++) {
        		if(subStr[i].length()==0)
        		{
        			continue;
        		}else{
//        			Arrays. subStr[i]
        		}
				subStrList.add(subStr[i]);
			}
        }
        return 0;
        
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
        int endIndex=0;
        int submaxLength=1;
        int maxLength=1;
        while(startIndex<=s.length()-2)
        {
        	Map<Character,Integer> subCharMap=new HashMap<>();
        	
        	subCharMap.put(charList[startIndex], startIndex);
        	submaxLength=1;
        	for (int i = startIndex+1; i < charList.length; i++) {
        		if(!subCharMap.containsKey(charList[i]))
        		{
        			subCharMap.put(charList[i], i);
        	     	submaxLength++;
        		}else{
        			startIndex=subCharMap.get(charList[i]) +1;
        			//startIndex=i;
        			endIndex=i;
        			break;
        		}
        		endIndex=i;
			}
        	if(submaxLength>maxLength)
			{
				maxLength=submaxLength;
			}
        	
        	if(endIndex==charList.length-1)
        	{
        		break;
        	}
        	
        	//startIndex++;
        	
        }
        
        if(startIndex==s.length()-1)
        {
        	//now the last word
        	System.out.println(maxLength);
        	return Math.max(maxLength, 1);
        }
        System.out.println(maxLength);
        return maxLength;
        
    }
	public static int lengthOfLongestSubstring3(String s) {
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
    	
    	subCharMap.put(charList[startIndex], startIndex);
    	endIndex=startIndex+1;
        while(startIndex<=s.length()-2)
        {
        	
        	//subCharMap.put(charList[startIndex], startIndex);
        	for (int i = endIndex; i < charList.length; i++) {
        		if(!subCharMap.containsKey(charList[i]))
        		{
        			subCharMap.put(charList[i], i);
        		}else{
        			
        			if(subCharMap.size()>maxLength)
        			{
        				maxLength=subCharMap.size();
        			}
        			
        			startIndex=subCharMap.get(charList[i]) +1;
        			final int index=i;
        			 Set<Character> keySet=subCharMap.keySet();
        			 //Iterator<Character> myIterator=keySet.iterator();
        			 Iterator myIterator = subCharMap.entrySet().iterator();
        			 int rmIndex=subCharMap.get(charList[i]);
        			    while (myIterator.hasNext()) {
        			        Map.Entry pair = (Map.Entry)myIterator.next();
        			       
        			        if((int)pair.getValue()<=rmIndex)
        			        {
        			        	myIterator.remove(); // avoids a ConcurrentModificationException
        			        }
        			    }
        			
        			endIndex=i;
        			break;
        		}
        		endIndex=i;
			}
        	
        	
        	if(subCharMap.size()>maxLength)
			{
				maxLength=subCharMap.size();
			}
        	
        	if(endIndex==charList.length-1)
        	{
        		break;
        	}
        	
        	
        }
        
        if(startIndex==s.length()-1)
        {
        	//now the last word
        	System.out.println(maxLength);
        	return Math.max(maxLength, 1);
        }
        System.out.println(maxLength);
        return maxLength;
        
    }
}
