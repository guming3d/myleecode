package com.interview.longestincreasingsubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.HashSet;
import java.util.List;

/**
 * 300. Longest Increasing Subsequence
 * 
 * Total Accepted: 43895 Total Submissions: 121512 Difficulty: Medium
 * 
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
 * subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may
 * be more than one LIS combination, it is only necessary for you to return the
 * length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution = new Solution();
		mySolution.lengthOfLIS3(new int[] { 3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12 });
	}

	/**
	 * Wrong answer!!!!
	 * 
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		int startIndex = 0;
		int endIndex = 0;
		int totalLength = 0;
		int maxLength = 0;
		while (startIndex < nums.length && endIndex < nums.length) {

			if (nums[endIndex] >= nums[startIndex]) {
				totalLength++;
				endIndex++;
			} else {
				startIndex = endIndex;
				if (totalLength > maxLength) {
					maxLength = totalLength;
				}
				totalLength = 0;
			}
		}

		return Math.max(totalLength, maxLength);
	}

	/**
	 * Wrong answer!!!! 创建一个排序的对应数组，从当前数组的第一个元素开始往后遍历，查找当前这个数之前有几个大于等于自己的数，
	 * 然后在排序数组中查找当前数后面有几个数，相减得到当前这个数后面的最大增序大小
	 * 
	 * @param nums
	 * @return
	 */
	public static int lengthOfLIS2(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return 0;
		}
		if (nums.length == 2) {
			if (nums[0] <= nums[1]) {
				return 2;
			} else {
				return 1;
			}
		}
		int[] sortedNums = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sortedNums);

		int maxSubSequence = 0;
		int currentSmallest = sortedNums[0];
		for (int i = 0; i < nums.length; i++) {
			// search the number larger than current item in the array before
			if (nums[i] >= currentSmallest) {
				if (i != 0) {
					continue;
				}

			}
			int numberLargerBefore = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] >= nums[i]) {
					numberLargerBefore++;
				}
			}
			int currentMaxSequence = nums.length - Arrays.binarySearch(sortedNums, nums[i]) - numberLargerBefore;
			if (currentMaxSequence > maxSubSequence) {
				maxSubSequence = currentMaxSequence;
			}
			currentSmallest = nums[i];
		}

		System.out.println(maxSubSequence);
		return maxSubSequence;
	}

	/**
	 * Time exceeded !!!!!
	 * @param nums
	 * @return
	 */
	public static int lengthOfLIS3(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		if (nums.length == 2) {
			if (nums[0] < nums[1]) {
				return 2;
			} else {
				return 1;
			}
		}

		int maxSubSequence = 1;
		Set<Integer> noneedCheckList = new HashSet<>();
		List<Stack<Integer>> subSeqList = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			subSeqList.clear();
			if (noneedCheckList.contains(nums[i])) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					noneedCheckList.add(nums[j]);
					if (subSeqList.isEmpty()) {
						Stack<Integer> subStack = new Stack<Integer>();
						subStack.push(nums[i]);
						subStack.push(nums[j]);

						Stack<Integer> subStack1 = new Stack<>();
						subStack1.addAll(subStack);
						subSeqList.add(subStack);
						subSeqList.add(subStack1);
					} else {
						boolean foundLarger = false;
						List<Stack<Integer>> copyStack = new ArrayList<>();
						for (Stack<Integer> subStack : subSeqList) {
							if (subStack.peek() < nums[j]) {
								Stack<Integer> prevStack = new Stack<>();
								prevStack.addAll(subStack);
								copyStack.add(prevStack);
								subStack.push(nums[j]);
								foundLarger = true;
							}
						}
						if (foundLarger == false) {
							Stack<Integer> subStack = new Stack<Integer>();
							subStack.push(nums[i]);
							subStack.push(nums[j]);
							Stack<Integer> subStack1 = new Stack<>();

							subStack1.push(nums[i]);
							subSeqList.add(subStack);
							subSeqList.add(subStack1);
						}
						subSeqList.addAll(copyStack);

					}

				}

			}
			// Calculate the max sub Length
			int maxSub = 0;
			for (int j2 = 0; j2 < subSeqList.size(); j2++) {
				maxSub = Math.max(maxSub, subSeqList.get(j2).size());
			}
			maxSubSequence = Math.max(maxSub, maxSubSequence);
			noneedCheckList.add(nums[i]);
		}
		System.out.println(maxSubSequence);
		return maxSubSequence;
	}

	public static int lengthOfLIS4(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		if (nums.length == 2) {
			if (nums[0] < nums[1]) {
				return 2;
			} else {
				return 1;
			}
		}

		int maxSubSequence = 1;
		Set<Integer> noneedCheckList = new HashSet<>();
		List<List<Integer>> subSeqList = new ArrayList<>();
		
		int index=1;
		List<Integer> firstList=new ArrayList<>();
		firstList.add(nums[0]);
		subSeqList.add(firstList);
		while(index<nums.length)
		{
			if(!noneedCheckList.contains(nums[index]))
			{
				List<List<Integer>> addingList=new ArrayList<>();
				for(List<Integer> subList:subSeqList)
				{
					if()
				}
			}
		}
		
		System.out.println(maxSubSequence);
		return maxSubSequence;
	}
}
