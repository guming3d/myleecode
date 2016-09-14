package com.interview.increasingtripletsubsequence;

import java.util.Stack;

/**
 * 334. Increasing Triplet Subsequence

    Total Accepted: 23229
    Total Submissions: 63555
    Difficulty: Medium

Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

    Return true if there exists i, j, k
    such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false. 

Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false. 
 * @author mcgu
 *
 */
//Not finished!!!!!TODO
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		System.out.println(mySolution.increasingTriplet(new int[]{3,1,5,4}));
	}
	static Stack<Integer> prevStack=new Stack<>();

	public boolean increasingTriplet(int[] nums) {
		if (nums.length <= 2) {
			return false;
		}
		prevStack.clear();
		int nextRound = 0;
		while (nextRound < nums.length) {

			for (int i = nextRound; i < nums.length; i++) {
				if (prevStack.isEmpty()) {
					prevStack.push(nums[i]);
				} else if (nums[i] > prevStack.peek()) {
					prevStack.push(nums[i]);
					if (prevStack.size() == 3) {
						return true;
					}
				} else if (prevStack.size() == 1 && nums[i] < prevStack.peek()) {
					prevStack.pop();
					prevStack.push(nums[i]);
					
				} else {
					nextRound = i;
					continue;
				}
			}
			nextRound++;
		}
		return false;
	  }
}
