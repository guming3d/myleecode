package com.interview.topkfrequentelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), 
    where n is the array's size.

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		topKFrequent(new int[]{1,1,1,2,2,3,3,5,5,5,5,5},2);
	}
	 public static List<Integer> topKFrequent(int[] nums, int k) {
//	     List<Integer> myList=new ArrayList<>();
		 
		 //create a map to hold the mapping of number and frequency
		 Map<Integer,Integer> freqMap=new HashMap<>();
		 for (int i = 0; i < nums.length; i++) {
			if(freqMap.containsKey(nums[i]))
			{
				freqMap.replace(nums[i], freqMap.get(nums[i])+1);
				
			}else{
				freqMap.put(nums[i], 1);
			}
		}
		 
		 Map<Integer,List<Integer>> freqListMap=new HashMap<>();
		Iterator<Map.Entry<Integer, Integer>> freqIter=freqMap.entrySet().iterator();
		List<Integer> tmp;
		while(freqIter.hasNext())
		{
			Map.Entry<Integer, Integer> entry=freqIter.next();
			if(freqListMap.containsKey(entry.getValue()))
			{
				
				tmp=freqListMap.get(entry.getValue());
				tmp.add(entry.getKey());
				freqListMap.replace(entry.getValue(),tmp );
			}else{
				tmp=new ArrayList<>();
				tmp.add(entry.getKey());
				freqListMap.put(entry.getValue(),tmp );
			}
		}
		
		int[] freqArray=new int[freqListMap.size()];
		Iterator<Map.Entry<Integer, List<Integer>>> iter=freqListMap.entrySet().iterator();
		int tmpIndex=0;
		while(iter.hasNext())
		{
			freqArray[tmpIndex]=iter.next().getKey();
			tmpIndex++;
		}
		Arrays.sort(freqArray);
		
		tmpIndex=0;
		int levelIndex=0;
		List<Integer> resultList=new ArrayList<>();
		while(tmpIndex<k)
		{
			List<Integer> curLevelList=freqListMap.get(freqArray[freqArray.length-1-levelIndex]);
			for (int i = 0; i < curLevelList.size(); i++) {
				resultList.add(curLevelList.get(i));
				tmpIndex++;
			}
			levelIndex++;
		}
		
		
		return resultList;
		 
		 

	    }
}
