package com.interview.anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
 * @author guming
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="aacccccc";
		String str2="ccccccaa";
		System.out.println(isAnagram(str1, str2));
	}
	public static boolean isAnagram(String s, String t) {
		String str1=s.toLowerCase();
		String str2=t.toLowerCase();
		if(s.length()!=t.length())
		{
			return false;
		}
		
		HashMap<Character, Integer> charMap1=new HashMap<>();
		HashMap<Character, Integer> charMap2=new HashMap<>();
		
		for(int i=0;i<str1.length();i++)
		{
			
			if(charMap1.get(str1.charAt(i))!=null)
			{
				int oldvalue=charMap1.get(str1.charAt(i));
				charMap1.put(str1.charAt(i), ++oldvalue);
			}else
			{
				charMap1.put(str1.charAt(i), 1);
			}
		}
		
		charMap1.forEach((i,j)->{
			System.out.println(String.format("[%c] --> %d", i,j));
		});
		
		for(int i=0;i<str2.length();i++)
		{
			
			if(charMap2.get(str2.charAt(i))!=null)
			{
				int oldvalue=charMap2.get(str2.charAt(i));
				charMap2.put(str2.charAt(i), ++oldvalue);
			}else{
				charMap2.put(str2.charAt(i), 1);
			}
		}
		System.out.println("------------------");
		charMap2.forEach((i,j)->{
			System.out.println(String.format("[%c] --> %d", i,j));
		});
		
		if(charMap1.size()!=charMap2.size())
		{
			System.out.println("size is different");
			return false;
		}
		
		for (HashMap.Entry<Character, Integer> entry : charMap1.entrySet()) {
			if(!charMap2.containsKey(entry.getKey()))
			{
				System.out.println("second string do not contains "+entry.getKey());
				return false;
			}
			int tmp1=entry.getValue();
			int tmp2=charMap2.get(entry.getKey());
			
			if(tmp1!=tmp2)
			{
				System.out.println(String.format("entry %c --> %d \nentry %c --> %d",entry.getKey(),entry.getValue(),entry.getKey(),charMap2.get(entry.getKey()) ));
				return false;
			}
//			if(entry.getValue()!=charMap2.get(entry.getKey()))
//			{
//
//				System.out.println(String.format("entry %c --> %d \nentry %c --> %d",entry.getKey(),entry.getValue(),entry.getKey(),charMap2.get(entry.getKey()) ));
//				return false;
//			}
		}
		

        return true;
    }
}
