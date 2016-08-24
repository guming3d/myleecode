package com.interview.containsduplicate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 * TODO:NOT PASS
 */

@Deprecated
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] testNums={1,2,3,4,7,8,8};
		System.out.println(Arrays.toString(testNums));
		System.out.println(containsDuplicate3(testNums));
	}
	public static boolean containsDuplicate(int[] nums) {
		HashMap<Integer,Integer> result=new HashMap<>();
		for (int i : nums) {
			if(!result.containsKey(i))
			{
				result.put(i, 1);
			}else
			{
				return true;
			}
		}
        return false;
    }
	
	public static boolean containsDuplicate2(int[] nums){
		Set<Integer> set = new HashSet<Integer>();
        for(int n : nums) {
            if(set.contains(n)){
            	return true;
            }else{
            	set.add(n);
            }
        }
        //if(set.size() < nums.length) return true;
        return false;
	}
	
	public static boolean containsDuplicate3(int[] nums){
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[j]==nums[i])
				{
					return true;
				}
			}
		}
		
        return false;
	}
}
