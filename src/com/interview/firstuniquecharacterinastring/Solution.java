package com.interview.firstuniquecharacterinastring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *  Given a string, find the first non-repeating character 
 *  in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters. 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		firstUniqChar("leetcode");
	}
	 public static int firstUniqChar(String s) {
		 if(s.length()==0)
		 {
			 return -1;
		 }
		 if(s.length()==1)
		 {
			 return 0;
		 }
	        Map<Character,Integer> noDupSet=new HashMap<>();
	        Set<Character> numSet=new HashSet<>();
	       
	        char tmp;
	        for (int i = 0; i < s.length(); i++) {
	        	tmp=s.charAt(i);
	        	if(numSet.contains(tmp))
	        	{
	        		if(noDupSet.containsKey(tmp))
	        		{
	        			noDupSet.remove(tmp);
	        			
	        		}
	        	}else{
	        		numSet.add(tmp);
	        		noDupSet.put(tmp,i);
	        	}
			}
	        if(noDupSet.size()==0)
	        {
	        	return -1;
	        }else{
	        	Integer[] result=new Integer[noDupSet.size()];
		        noDupSet.values().toArray(result);
		        Arrays.sort(result);
		        return result[0];
	        }
	        
	      
	    }
}
