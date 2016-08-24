package com.interview.happynumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy2(12158));
	}
	public static boolean isHappy(int n) {
		if(n==1)
		{
			return true;
		}else
		{
			int tmp=n;
			int totalNumber=0;
			while(tmp/10 > 0)
			{
				totalNumber+=Math.pow(tmp % 10, 2);
				tmp/=10;
			}
			return isHappy(totalNumber);
		}
        
    }
	public static boolean isHappy2(int n) {
		int tmpNumber=n;
		int tmp;
		int totalNumber;
		Set<Integer> existingNumber=new HashSet<>();
		
		while(tmpNumber!=1	)
		{
			if(existingNumber.contains(tmpNumber))
			{
				System.out.println("find cycle "+tmpNumber);
				return false;
			}
			existingNumber.add(tmpNumber);
			tmp=tmpNumber;
			totalNumber=0;
			while(tmp/10 > 0)
			{
				totalNumber+=Math.pow(tmp % 10, 2);
				tmp/=10;
			}
			totalNumber+=Math.pow(tmp % 10, 2);
			tmpNumber=totalNumber;
		}
		
		return true;
        
    }
}
