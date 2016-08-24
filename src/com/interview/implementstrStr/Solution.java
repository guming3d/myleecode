package com.interview.implementstrStr;
/**
 * Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("",""));
	}
	 public static int strStr(String haystack, String needle) {
		 if(haystack.length()==0)
		 {
		     if(needle.length()==0)
		     {
		         return 0;
		     }else{
		        return -1;    
		     }
			 
		 }
		 
		 if(needle.length()==0)
		 {
		     return 0;
		 }
		 int index=0;
		 
		 
		 for (int i = 0; i < haystack.length(); i++) {
			if(haystack.charAt(i)==needle.charAt(0))
			{
				boolean currentOK=true;
				//got the first same char, go on checking following chars
				for (int j = 1; j < needle.length(); j++) {
					if(i+j >haystack.length()-1)
					{
						return -1;
					}else{
						if(!(haystack.charAt(i+j)==needle.charAt(j)))
						{
							currentOK=false;
							break;
						}
					}
				}
				if(currentOK==true)
				{
					return i;
				}else{
					continue;
				}
				
			}
		}
		 return -1;
	 }
}
