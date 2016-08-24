package com.interview.powerofthree;
/**
 *  Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion? 
 * @author guming
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfThree(81));
	}
	 public static boolean isPowerOfThree(int n) {
		 
		 int number=0;
		 if(n==1)
		 {
			 return true;
		 }
		 
		 if (n % 3 == 0)
		 {
			 n= n / 3;
			 return isPowerOfThree(n);
		 }
		 else{
			 return false;
		 }

	    }
}
