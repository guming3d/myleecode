package com.interview.kthlargestelementinanarray;

import java.util.Arrays;

/**
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findKthLargest(new int[]{2,5,9,3,2,1},4));
	}
	public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k-1];
    }
}
