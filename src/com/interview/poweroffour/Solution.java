package com.interview.poweroffour;
/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfFour(15648));

	}
	 public static boolean isPowerOfFour(int num) {
		 if(num==1)
		 {
			 return true;
		 }
		 if(num<=0)
		 {
			 return false;
		 }
		 int tmp=num;
		 while(tmp % 4 == 0)
		 {
			 tmp /=4;
		 }
		 if(tmp==1)
		 {
			 return true;
		 }else
		 {
			 return false; 
		 }
		 
	        
	    }
}
