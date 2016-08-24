package com.interview.uglynumber;
/**
 * Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
 * Ugly number
 * TODO
 * 
 * @author mcgu
 *
 */
@Deprecated
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly2(7));
	}
	
	public static boolean isUgly(int num) {
		if((num == 2)||(num ==3)||(num==5)||(num ==1))
		{
			return true;
		}
		else
		{
			if(num % 2 ==0)
			{
				return isUgly(num / 2);
			}else if(num % 3 ==0)
			{
				return isUgly(num / 3);
			}
			else if(num % 5 ==0)
			{
				return isUgly(num / 5);
			}else
			{
				return false;
			}
			
		}
    }
	
	public static boolean isUgly2(int num) {
		int tmpNumber=num;
		while((tmpNumber % 5)==0)
		{
			tmpNumber/=5;
		}
		while((tmpNumber % 3)==0)
		{
			tmpNumber/=3;
		}
		while((tmpNumber % 2)==0)
		{
			tmpNumber/=2;
		}
		
		
		
		
		if(tmpNumber == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
    }
}
