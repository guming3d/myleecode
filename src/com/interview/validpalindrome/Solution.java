package com.interview.validpalindrome;
/**
 * 125. Valid Palindrome

    Total Accepted: 117960
    Total Submissions: 478259
    Difficulty: Easy

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome. 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isPalindrome(String s) {
        if(s.length()==0)
        {
            return true;
        }
        if(s.length()==1)
        {
            return true;
        }
        StringBuilder finalStr=new StringBuilder();
        String newS=s.toLowerCase();
        
       // System.out.println(newS);
        for(int i=0;i<newS.length();i++)
        {
            if((newS.charAt(i)>='a' && newS.charAt(i)<='z') ||
            (newS.charAt(i)>='0' && newS.charAt(i)<='9'))
            {
                finalStr.append(newS.charAt(i));
            }
        }
        
        
       
        //System.out.println(finalStr.toString());
        String finalString=finalStr.toString();
         if(finalString.length()==0)
        {
            return true;
        }
        if(finalString.length()==1)
        {
            return true;
        }
        int start=0;
        int end=finalString.length()-1;
        while(start<=end)
        {
            if(finalString.charAt(start)!=finalString.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
