package com.interview.lengthoflastword;
/**
 * Given a string s consists of upper/lower-case alphabets and empty 
 * space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of 
non-space characters only.

For example,
Given s = "Hello World",
return 5. 
 * @author guming
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(lengthOfLastWord("    "));
	}
	public static int lengthOfLastWord(String s) {
		if(s.length()==0)
		{
			return 0;
		}
		int length=0;
		boolean startCount=false;
        for (int i = s.length()-1; i >=0; i--) {
			if(s.charAt(i)!=' ')
			{
				startCount=true;
				length++;
			}else{
				if(startCount==true)
				{
					System.out.println("stop the count");
					break;
				}
			}
		}
        return length;
        
    }
}
