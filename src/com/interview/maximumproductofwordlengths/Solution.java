package com.interview.maximumproductofwordlengths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *  Given a string array words, find the maximum value of length(word[i]) * length(word[j]) 
 *  where the two words do not share common letters. 
 *  You may assume that each word will contain only lower case letters. 
 *  If no such two words exist, return 0.

Example 1:

Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:

Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:

Given ["a", "aa", "aaa", "aaaa"]
Return 0

TODO
No such pair of words. 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"});
	}
	public static int maxProduct(String[] words) {
         //generate the character mapping 
	        Map<Character,List<Integer>> charMap=new HashMap<>();
	        Map<String,List<Character>> uniqStrMap=new HashMap<>();
	        //Map<String,Integer> strLenMap=new HashMap<>();
	        int[] noneDupList=new int[words.length];
	        Arrays.fill(noneDupList,1);
	        
	        //Create a map to store uniq characters in each String
	        for (int i = 0; i < words.length; i++) {
	        	uniqStrMap.put(words[i], new ArrayList<Character>());
	        	
	        	for(int j=0;j<words[i].length();j++)
	            {
	        		char curChar=words[i].charAt(j);
	        		if(!uniqStrMap.get(words[i]).contains(curChar)){
	        			uniqStrMap.get(words[i]).add(curChar);
	        		}
	            }
			}
	        
	        //Create a charMap to store the String index which contains the character
	        for(int i=0;i<words.length;i++)
	        {
	            for(int j=0;j<words[i].length();j++)
	            {
	                char curChar=words[i].charAt(j);
	                if(charMap.containsKey(curChar))
	                {
	                	if(!charMap.get(curChar).contains(i))
	                	{
	                		charMap.get(curChar).add(i);
		                    charMap.replace(curChar,charMap.get(curChar));	
	                	}
	                	
	                }else{
	                    List<Integer> indexList=new ArrayList<>();
	                    indexList.add(i);
	                    charMap.put(curChar,indexList);
	                }
	            }
	        }
	        
	        int maxTotal=0;
//	        for(int i=0;i<words.length;i++)
//	        {
//	            
//	             int[] curDup=noneDupList.clone();
//	             for(int j=0;j<words[i].length();j++)
//	             {
//	            	 List<Integer> dupList=charMap.get(words[i].charAt(j));
//	                 for(Integer item: dupList)
//	                 {
//	                     curDup[item]=0;
//	                 }
//	             }
//	             
//	             for(int k=0;k<curDup.length;k++)
//	             {
//	                 if(curDup[k]==1)
//	                 {
//	                   maxTotal=Math.max(maxTotal, words[i].length() * words[k].length());  
//	                 }
//	             }
//	             
//	        }
	        
	        //walkthrough the uniqSet to calculate the maximum multiple size
	        Iterator<Map.Entry<String, List<Character>>> myIter=uniqStrMap.entrySet().iterator();
	        while(myIter.hasNext())
	        {
	        	Map.Entry<String, List<Character>> entry=myIter.next();
	        	int[] curDup=noneDupList.clone();
	        	for(int j=0;j<entry.getValue().size();j++)
	             {
	        		char curChar=entry.getValue().get(j);
	            	 List<Integer> dupList=charMap.get(curChar);
	                 for(Integer item: dupList)
	                 {
	                     curDup[item]=0;
	                 }
	             }
	        	
	        	 for(int k=0;k<curDup.length;k++)
	             {
	                 if(curDup[k]==1)
	                 {
	                   maxTotal=Math.max(maxTotal, entry.getKey().length() * words[k].length());  
	                 }
	             }
	        }
	        
	        return maxTotal;
        
        
    }
}
