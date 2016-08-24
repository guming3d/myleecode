package com.interview.palindromenumber;
/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPalindrome(22);
	}
	 public static boolean isPalindrome(int x) {
		 if(x<0)
		 {
			 return false;
		 }
		 if(x<10)
		 {
			 return true;
		 }
		 //first get the number of chars
		 int tmpNum=x;
		 int totalNumber=0;
		 while(!(tmpNum/10==0))
		 {
			 totalNumber++;
			 tmpNum/=10;
		 }
		 totalNumber++;
		 
		 //compare the corrisponding number

		 
		 for (int i = 1; i < totalNumber; i++) {
			 
			 double leftNum= (x / (Math.pow(10, totalNumber-i)))  % 10;
			 double rightNum= ( x / Math.pow(10, i-1)) % 10;
			 long left= (new   Double(leftNum)).intValue(); 
			 long right=(new   Double(rightNum)).intValue();
			 if(left != right)
			 {
				 return false;
			 }
			 
			 
		}
		 
		 
		 
		 
	        return true;
	    }
}
