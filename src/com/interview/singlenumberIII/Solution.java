package com.interview.singlenumberIII;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *  Given an array of numbers nums, in which exactly two elements appear only once 
 *  and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:

    The order of the result is not important. So in the above example, [5, 3] is also correct.
    Your algorithm should run in linear runtime complexity. Could you implement 
    it using only constant space complexity?

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public int[] singleNumber(int[] nums) {
        Map<Integer,Integer> myMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
			if(myMap.containsKey(nums[i]))
			{
				myMap.replace(nums[i], 0);
			}else{
				myMap.put(nums[i], nums[i]);
			}
		}
        
        int[] result=new int[2];
        int tmp=0;
        Iterator<Map.Entry<Integer, Integer>> mapIter=myMap.entrySet().iterator();
        while(mapIter.hasNext())
        {
        	Map.Entry<Integer, Integer> cur=mapIter.next();
        	if(cur.getValue()!=0)
        	{
        		result[tmp]=cur.getKey();
        		tmp++;
        	}
        }
        return result;
    }
}
