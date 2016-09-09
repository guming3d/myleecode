package com.interview.findtheduplicatenumber;
/**
 * 287. Find the Duplicate Number

    Total Accepted: 39120
    Total Submissions: 96287
    Difficulty: Hard

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:

    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.

 * @author mcgu
 *
 */
/**
 * NOT GOOD SOLUTION!!!!!
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if(nums[j]==nums[i])
				{
					return nums[i];
				}
			}
		}
        return 0;
    }
}
