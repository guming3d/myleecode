package com.interview.combinationsum4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given an integer array with all positive numbers and no duplicates, 
 *  find the number of possible combinations that add up to a positive
 *   integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.

Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers? 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int combinationSum4(int[] nums, int target) {
	     return 0;   
	    }
	 public int numberOfListRange(int[] nums){
		 int originSize=nums.length;
		 List<int[]> finalList=new ArrayList<>();
		 //sort the array
		 Arrays.sort(nums);
		 
		 
		 return 0;
	 }
	 
	 //calculate the posibilities of the array rearange
	 public int factorial(int num)
	 {
		 int total=1;
		for(int i=num;i>=1;i--)
		{
			total*=i;
		}
		return total;
	 }
}
