package com.interview.longestpalindromicsubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * @author mcgu
 * @MIDDLE
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestPalindrome("abcdefdf");
		//isPalindromic("abcdba",0,5);
	}
	/**
	 * 找重复字符，每次比较两个重复字符中间部分是否是回文
	 * @param s
	 * @return
	 */
public static String longestPalindrome(String s) {
	//first get all the char with duplicate
	if(s.length()==1||s.length()==0)
	{
		return s;
	}
	if(s.length()==2)
	{
		if(s.charAt(0)==s.charAt(1))
		{
			return s;
		}else{
			return null;
		}
	}
	
	boolean isAllSame=true;
	for (int i = 1; i < s.length(); i++) {
		if(s.charAt(0)!=s.charAt(i))
		{
			isAllSame=false;
			break;
		}
	}
	if(isAllSame)
	{
		return s;
	}
	
	if(isPalindromic(s, 0, s.length()-1))
	{
		return s;
	}
	
	Map<Character,List<Integer>> dupMap=new HashMap<>();
	
	char tmp;
	int maxPalinLength=0;
	int finalStart=0;
	int finalEnd=0;
	int tmpMax=0;
	for (int i = 0; i < s.length(); i++) {
		tmp=s.charAt(i);
		if(dupMap.containsKey(tmp))
		{
				dupMap.get(tmp).add(i);
				//calculate current Max length
				for (int j = 0; j <dupMap.get(tmp).size(); j++) {
					if(isPalindromic(s, dupMap.get(tmp).get(j), i))
					{
						tmpMax=i-dupMap.get(tmp).get(j)+1;
						if(tmpMax>maxPalinLength)
						{
							maxPalinLength=tmpMax;
							finalStart=dupMap.get(tmp).get(j);
							finalEnd=i;
							break;
						}
					}
					
				}

		}else{
			List<Integer> subIndex=new ArrayList<>();
			subIndex.add(i);
			dupMap.put(tmp, subIndex);
		}
	}
	
		
		String result=s.substring(finalStart, finalEnd+1);
		//System.out.println(result);
        return result;
    }

public static String longestPalindrome2(String s)
{
	StringBuilder reverse=new StringBuilder();
	for (int i = s.length()-1; i >= 0; i--) {
		reverse.append(s.charAt(i));
	}
	//find the max subString of s and reverse
	

		return "";
}
public static boolean isPalindromic(String str,int startIndex,int endIndex)
{
	int tmpStart=startIndex;
	int tmpEnd=endIndex;
	while(tmpEnd>tmpStart)
	{
		if(!(str.charAt(tmpStart)==str.charAt(tmpEnd)))
		{
			//System.out.println("false");
			return false;
		}
		tmpStart++;
		tmpEnd--;
	}
	//System.out.println("true");
	return true;
}
}
