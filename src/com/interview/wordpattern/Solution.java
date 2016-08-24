package com.interview.wordpattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(wordPattern("abba","dog cat cat fish"));
	}
	public static boolean wordPattern(String pattern, String str) {
		Map<Character, String> first2SecondHash=new HashMap<>();
		Map<String, Character> second2FirstHash=new HashMap<>();
		String [] secondList=str.split(" ");
		//if size is different, just return false
		if(pattern.length()!=secondList.length)
		{
			return false;
		}
		//first check weather str can map to str2
		for (int i = 0; i < pattern.length(); i++) {
			if(first2SecondHash.containsKey(pattern.charAt(i)))
			{
				if(!first2SecondHash.get(pattern.charAt(i)).equalsIgnoreCase(secondList[i]))
				{
					return false;
				}
			}else{
				first2SecondHash.put(pattern.charAt(i), secondList[i]);
			}
		}
		//then check weather str2 can map to str
		for (int i = 0; i < pattern.length(); i++) {
			if(second2FirstHash.containsKey(secondList[i]))
			{
				if(!(second2FirstHash.get(secondList[i])==pattern.charAt(i)))
				{
					return false;
				}
			}else{
				second2FirstHash.put(secondList[i], pattern.charAt(i));
			}
		}
		
        return true;
    }
}
