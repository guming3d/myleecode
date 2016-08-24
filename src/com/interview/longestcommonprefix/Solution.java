package com.interview.longestcommonprefix;
/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] testStr=new String[]{"",""};
		longestCommonPrefix(testStr);
	}
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length==0)
		{
			return null;
		}
		if(strs.length==1)
		{
			return strs[0];
		}
		
		for (int i = 0; i < strs.length; i++) {
			if(strs[i].length()==0)
			{
				return "";
			}
		}
        char currChar=strs[0].charAt(0);
        int strLength=strs[0].length();
        String prefixStr="";
        for (int i = 0; i < strLength; i++) {
        	currChar=strs[0].charAt(i);
			for (int j = 0; j < strs.length; j++) {
				//if the current str is shorter than i, no need to check ,just return
				if(strs[j].length()<=i)
				{
					return prefixStr;
				}
				else{
					if(currChar!=strs[j].charAt(i))
					{
						return prefixStr;
					}
				}
			}
			prefixStr+=currChar;
			
		}
        return prefixStr;
    }
}
