package com.interview.reverse;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseString("George");
	}
	
	public static String reverseString(String s) {
		StringBuilder tmpStr=new StringBuilder();
		for(int i=s.length()-1;i>=0;i--)
		{
			tmpStr.append(s.charAt(i));
		}
		System.out.println(tmpStr.toString());
		return tmpStr.toString();
    }
}
