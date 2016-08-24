package com.interview.ransomnote;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *   Given  an  arbitrary  ransom  note  string  and  another  string  containing  
 *  letters from  all  the  magazines,  write  a  function  that  will  return  true
 *    if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise, 
 *    it  will  return  false.   

Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note. 
Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

 * @author guming
 *
 */
public class Solution {
	static boolean finalresult=true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canConstruct("aa","aab"));
	}
	 public static boolean canConstruct(String ransomNote, String magazine) {
		 
		 	if(ransomNote.length()==0)
		 	{
		 		return true;
		 	}
		 	if(magazine.length()==0)
		 	{
		 		return false;
		 	}
	        Map<Character,Integer> map1=new HashMap<>();
	        Map<Character,Integer> map2=new HashMap<>();
	        String ransomNote1=ransomNote.toLowerCase();
	        String magazine1=magazine.toLowerCase();
	        for (int i = 0; i < ransomNote1.length(); i++) {
				if(!map1.containsKey(ransomNote1.charAt(i)))
				{
					map1.put(ransomNote1.charAt(i), 1);
				}else
				{
					map1.replace(ransomNote1.charAt(i), map1.get(ransomNote1.charAt(i))+1);
				}
			}
	        
	        for (int i = 0; i < magazine.length(); i++) {
				if(!map2.containsKey(magazine.charAt(i)))
				{
					map2.put(magazine.charAt(i), 1);
				}else
				{
					map2.replace(magazine.charAt(i), map2.get(magazine.charAt(i))+1);
				}
			}
	        
	        Set<Character> mySet=new HashSet<>();
	        mySet=map1.keySet();
	        boolean result=true;
	        mySet.stream().forEach(item->{
	        	if(map2.containsKey(item))
	        	{
	        		if(!(map1.get(item)<=map2.get(item)))
	        		{
	        			finalresult=false;
	        		}
	        	}else{
	        		finalresult=false;
	        	}
	        	
	        });
	        return finalresult;
	    }
}
