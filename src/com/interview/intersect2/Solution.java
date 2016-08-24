package com.interview.intersect2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1={1,2,2,1,3,6,4};
		int[] nums2={2,2,3,1};
		intersect(nums1,nums2);
	}
public static  int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
			if(map1.containsKey(nums1[i]))
			{
				map1.replace(nums1[i], map1.get(nums1[i])+1);
			}else{
				map1.put(nums1[i], 1);
			}
		}
        
        for (int i = 0; i < nums2.length; i++) {
			if(map2.containsKey(nums2[i]))
			{
				map2.replace(nums2[i], map2.get(nums2[i])+1);
			}else{
				map2.put(nums2[i], 1);
			}
		}
        List<Integer> resultList=new LinkedList<>();
        if(map1.size()>map2.size())
        {
        	map2.forEach((key,number)->{
        		if(map1.containsKey(key))
        		{
        			if(number<map1.get(key))
        			{
        				for (int i = 0; i < number; i++) {
        					resultList.add(key);
						}
        			}else{
        				for (int i = 0; i < map1.get(key); i++) {
        					resultList.add(key);
						}
        			}
        		}
        	});
        }else{
        	map1.forEach((key,number)->{
        		if(map2.containsKey(key))
        		{
        			if(number<map2.get(key))
        			{
        				for (int i = 0; i < number; i++) {
        					resultList.add(key);
						}
        			}else{
        				for (int i = 0; i < map2.get(key); i++) {
        					resultList.add(key);
						}
        			}
        		}
        	});
        }
        
        int[] finalResult=new int[resultList.size()];
        for (int i = 0; i < finalResult.length; i++) {
        	finalResult[i]=resultList.get(i);
        	System.out.println(finalResult[i]);
		}
        return finalResult;
    }
}
