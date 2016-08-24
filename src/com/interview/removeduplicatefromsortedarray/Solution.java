package com.interview.removeduplicatefromsortedarray;
/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testData={1};
		System.out.println(removeDuplicates(testData));
 	}
	public static int removeDuplicates(int[] nums) {
//		int currentIndex=0;
//		int nextLargeIndex=currentIndex+1;
//		int nextFillIndex=currentIndex+1;
		//using dump method
		if(nums.length==0 || nums.length==1)
			return nums.length;
		
		int finalLength=nums.length;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]==nums[i-1])
			{
				finalLength--;
			}
		}
		
		int totalLength=nums.length;
		int nextIndex=0;;
		
		for (int i = 0; i < finalLength; i++) {
			int dupNumber=0;
			
			for (int j = i+1; j < nums.length; j++) {
				nextIndex=j;
				if(nums[j]==nums[i])
				{
					dupNumber++;
					totalLength--;
				}else{
					break;
				}
			}
			
			if(dupNumber>0)
			{
				//has dup number
				//move all following number a head 
				for (int j = nextIndex; j < nums.length; j++) {
					nums[j-dupNumber]=nums[j];
				}
			}
			
		}
		return finalLength;
    }
}
