package com.interview.factorialtrailingzeroes;

import java.util.Map;

/**
 * Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getNewTailingZero(20,500));
	}
	public static int trailingZeroes(int n) {
		if(n<0)
		{
			return 0;
		}
		
		if(n==0)
		{
			return 1;
		}
		
		if(n==1)
		{
			return 0;
		}
		
		int currNumber=n;
		long factorialNumber=1;
		int consequtiveZero=0;
		
		for (int i = 1; i <= n; i++) {
			
		}
		
		
		
	return consequtiveZero;
        
    }
	
	public static int getNewTailingZero(int num1,int num2)
	{
		int tailingZero1=0;  //number of zeros in num1
		int tailingNumber1=0; //first number of none zero
		int tailingZero2=0;
		int tailingNumber2=0;
		int finalTailingZero=0;
		int finalTailingNum=0;
		while(num1 % 10 ==0)
		{
			num1/=10;
			tailingZero1++;
		}
		tailingNumber1=num1%10;
		
		while(num2 % 10 ==0)
		{
			num2/=10;
			tailingZero2++;
		}
		tailingNumber2=num2%10;
		
		if((tailingNumber1 * tailingNumber2) % 10 ==0)
		{
			finalTailingZero=tailingZero1 + tailingZero2 +1;
			finalTailingNum=(tailingNumber1 * tailingNumber2) / 10;
		}
		else{
			finalTailingZero=tailingZero1 + tailingZero2;
			finalTailingNum=(tailingNumber1 * tailingNumber2) % 10;
		}
		
		return finalTailingZero;
	}
}
