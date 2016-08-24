package com.interview.regularexpressionmatching;
/**
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 * @author mcgu
 * @Hard
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public boolean isMatch(String s, String p) {
	//if p do not contains the regular meta char
	if(!p.contains(".") && !p.contains("*"))
	{
		//two String must be same
		if(s.length()!=p.length())
		{
			return false;
		}else{
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)!=p.charAt(i))
				{
					return false;
				}
			}
			return true;
		}
	}
	//p contains only .
	if(!p.contains("*") && p.contains("."))
	{
		if(s.length()!=p.length())
		{
			return false;
		}else{
			for (int i = 0; i < s.length(); i++) {
				if((s.charAt(i)!=p.charAt(i)) && (p.charAt(i)!='.'))
				{
					return false;
				}
				
			}
			return true;
		}
	}
	
	//do not contains ".*"
	if(!p.contains(".*"))
	{
		//first seperate the 
	}
	
	
        return false;
    }
}
