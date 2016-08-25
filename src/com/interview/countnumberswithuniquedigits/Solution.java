package com.interview.countnumberswithuniquedigits;
/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in 
the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99]) 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countNumbersWithUniqueDigits(3);
	}
	public static int countNumbersWithUniqueDigits(int n) {
		final int MAXLIMIT=(int)Math.pow(10, n);
		String curStr="";
		int total=0;
		 for (int i = 0; i < MAXLIMIT; i++) {
			 curStr=Integer.toString(i);
			if(curStr.length()!=curStr.chars().distinct().count()){
				//System.out.println(curStr);
				total++;
			}
		}
		 System.out.println("---------------------");
		 System.out.println(total);
        return total;
    }
}
