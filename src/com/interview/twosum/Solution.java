package com.interview.twosum;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testArray=new int[]{2,7,11,0};
		twoSum(testArray,9);
	}
	 public static int[] twoSum(int[] nums, int target) {
		 int otherPart=0;
		 for (int i = 0; i < nums.length; i++) {
			otherPart=target - nums[i];
			for (int j = i+1; j < nums.length; j++) {
				if(nums[j]==otherPart)
				{
					int [] finalIndex=new int[]{i,j};
					return finalIndex;
				}
				
			}
		}
	        return null;
	    }
}
