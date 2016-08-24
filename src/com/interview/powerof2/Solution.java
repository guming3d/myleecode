package com.interview.powerof2;
/**
 * Given an integer, write a function to determine if it is a power of two
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfTwo(6));
	}
	public static boolean isPowerOfTwo(int n)
	{
		if(n==1)
		{
			return true;
		}
		if(n==0)
		{
			return false;
		}
		int tmpNumber=n;
		while(tmpNumber >0)
		{
			if(tmpNumber % 2 == 0){
				tmpNumber /=2;
			}
			else if(tmpNumber==1)
			{
				return true;
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPowerOfTwo2(int n)
	{
		String finalStr=Integer.toString(n, 2);
		if(finalStr.matches("^10+")){
			return true;
		}
		return false;
	}
}
