package com.interview.containsduplicateII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
 * and the difference between i and j is at most k.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j <= k; j++) {
				if(i+j<nums.length)
				{
				if(nums[i]==nums[i+j])
				{
					return true;
				}
				}else{
					return false;
				}
			}
		}
        return false;
    }
	
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		Map<Integer,Integer> myHash=new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(myHash.containsKey(nums[i]))
			{
				if((i-myHash.get(nums[i]))<=k)
				{
					return true;
				}else{
					myHash.replace(nums[i], i);
				}
			}else{
				myHash.put(nums[i], i);
			}
		}
		
        return false;
    }
}
