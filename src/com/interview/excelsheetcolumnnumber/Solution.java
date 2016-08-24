package com.interview.excelsheetcolumnnumber;
/**
 * Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 * @author guming
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		titleToNumber("CA");
	}
	
	public static int titleToNumber(String s) {
		int totalNumber=0;
		if(s.length()==0 )
		{
			return 0;
		}
		
		for(int i=0;i<=s.length()-1;i++)
		{
			if('A'<=s.charAt(i) && s.charAt(i)<='Z')
			{
				int tmpNumber= s.charAt(i) - 'A' + 1;
			
				totalNumber += tmpNumber * Math.pow(26, s.length()-1-i);
				System.out.println(totalNumber);
			}else
			{
				return 0;
			}
		}
        return totalNumber;
    }
}
