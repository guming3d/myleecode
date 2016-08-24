package com.interview.majorelement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

	You may assume that the array is non-empty and the majority element always exist in the array.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] testNums={1,1,3,4,4,5,5,5,5,5,5,5};
		System.out.println(Arrays.toString(testNums));
		System.out.println(majorityElement(testNums));

	}
	public static int majorityElement(int[] nums) {
		HashMap<Integer,Integer> result=new HashMap<>();
		for (int i : nums) {
			if(!result.containsKey(i))
			{
				result.put(i, 1);
			}else
			{
				int tmp=result.get(i);
				//result.replace(i, tmp+1);
				result.merge(i, 1, Integer::sum);
			}
		}
		
		for (Map.Entry<Integer, Integer> entry: result.entrySet()) {
			if(entry.getValue()> nums.length/2)
			{
				return entry.getKey();
			}
		}
		
        return 0;
    }
}
