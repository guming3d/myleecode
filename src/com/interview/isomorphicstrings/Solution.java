package com.interview.isomorphicstrings;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 * @author guming
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("ab", "aa"));
	}
public static boolean isIsomorphic(String s, String t) {
	  HashMap<Character, Character> charHash=new HashMap<>();
	  if(s.length()!=t.length())
	  {
		  return false;
	  }
	  
	  for (int i = 0; i < s.length(); i++) {
		if(!charHash.containsKey(s.charAt(i)))
		{
			charHash.put(s.charAt(i), t.charAt(i));
		}else{
			if(charHash.get(s.charAt(i))!=t.charAt(i)){
				return false;
			}
		}
	}
	  charHash.clear();
	  for (int i = 0; i < s.length(); i++) {
			if(!charHash.containsKey(t.charAt(i)))
			{
				charHash.put(t.charAt(i), s.charAt(i));
			}else{
				if(charHash.get(t.charAt(i))!=s.charAt(i)){
					return false;
				}
			}
		}
	  
        return true;
    }
}
