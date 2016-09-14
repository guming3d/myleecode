package com.interview.reversevowelsofastring;
/**
 * Write a function that takes a string as input and 
 * reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
 * @author mcgu
 * TODO
 * A, E, I, O, U
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseVowels("hellio"));
	}
	public static String reverseVowels(String s) {
		String lowerS=s.toLowerCase();
		StringBuilder vowels=new StringBuilder();
		for (int i = 0; i < lowerS.length(); i++) {
			char currChar=lowerS.charAt(i);
			if(currChar=='a' ||
			   currChar=='e' ||
			   currChar=='i' ||
			   currChar=='o' ||
			   currChar=='u' )
			{
				vowels.append(lowerS.charAt(i));
			}
		}
		vowels.reverse();
		StringBuilder finalStr=new StringBuilder();
		int index=0;
		for (int i = 0; i < lowerS.length(); i++) {
			char currChar=lowerS.charAt(i);
			if(currChar=='a' ||
			   currChar=='e' ||
			   currChar=='i' ||
			   currChar=='o' ||
			   currChar=='u' )
			{
				finalStr.append(vowels.charAt(index));
				index++;
				//vowels.append(lowerS.charAt(i));
			}else{
				finalStr.append(currChar);
			}
		}
		
		
        return finalStr.toString();
    }
}
