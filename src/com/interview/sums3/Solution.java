package com.interview.sums3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? Find all unique triplets in the 
 * array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static List<List<Integer>> threeSum(int[] nums) {
		//Seperate the nums into three parts ,less than zero, equal to zero
		//higher than zero
		List<List<Integer>> finalList=new ArrayList<>();
//		List<Integer> lessZeroList=new ArrayList<>();
		List<Integer> equalZeroList=new ArrayList<>();
//		List<Integer> higherZeroList=new ArrayList<>();
		
		Map<Integer,Integer> higherZeroMap=new HashMap<>();
		Map<Integer,Integer> lessZeroMap=new HashMap<>();
		
		Set<Integer> lessZeroSet=new HashSet<>();

		Set<Integer> higherZeroSet=new HashSet<>();
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0)
			{
				equalZeroList.add(nums[i]);
			}else if(nums[i]<0)
			{
//				lessZeroList.add(nums[i]);
				lessZeroSet.add(nums[i]);
				if(lessZeroMap.containsKey(nums[i]))
				{
					lessZeroMap.replace(nums[i], lessZeroMap.get(nums[i])+1);
				}else{
					lessZeroMap.put(nums[i], 1);
				}
			}else{
//				higherZeroList.add(nums[i]);
				higherZeroSet.add(nums[i]);
				if(higherZeroMap.containsKey(nums[i]))
				{
					higherZeroMap.replace(nums[i], higherZeroMap.get(nums[i])+1);
				}else{
					higherZeroMap.put(nums[i], 1);
				}
			}
		}
		//first get the list include all 0
		if(equalZeroList.size()>=3)
		{
			Integer[] zeroArray=new Integer[]{0,0,0};
			List<Integer> zeroList=Arrays.asList(zeroArray);
			finalList.add(zeroList);
		}
		//get the list include one 0
		if(equalZeroList.size()>0)
		{
			Iterator<Integer> largerZeroIter=higherZeroSet.iterator();
			while(largerZeroIter.hasNext())
			{
				Iterator<Integer> lessZeroIter=lessZeroSet.iterator();
				int currNum=largerZeroIter.next();
				while(lessZeroIter.hasNext())
				{
					int currLess=lessZeroIter.next();
					if(currLess==currNum*(-1))
					{
						Integer[] currentArray=new Integer[]{0,currNum,currLess};
						finalList.add(Arrays.asList(currentArray));
					}
				}
			}
		}
		
		//Get the list which do not contains 0
		//Get the list with two higer zero number and one less zero number
		Set<Integer> location1Set=new HashSet<>();
		Set<Integer> location2Set=new HashSet<>();
		Set<Integer> location3Set=new HashSet<>();
		
		Set<Integer> higerZeroTotalSet=new HashSet<>();
		Set<Integer> lessZeroTotalSet=new HashSet<>();
		Integer[] higherZeroList=new Integer[higherZeroSet.size()];
		higherZeroSet.toArray(higherZeroList);
		Integer[] lessZeroList=new Integer[lessZeroSet.size()];
		lessZeroSet.toArray(lessZeroList);
		
		
		for (int j = 0; j < higherZeroList.length; j++) {
			for (int j2 = j+1; j2 < higherZeroList.length; j2++) {
				for (int k = 0; k < lessZeroList.length; k++) {
					if(higherZeroList[j]+higherZeroList[j2]+lessZeroList[k]==0)
					{
						//equal to zero
						List<Integer> tmpList=new ArrayList<>();
						tmpList.add(higherZeroList[j]);
						tmpList.add(higherZeroList[j2]);
						tmpList.add(lessZeroList[k]);
						finalList.add(tmpList);
					}
				}
				
			}
		}
		
		for (int j = 0; j < lessZeroList.length; j++) {
			for (int j2 = j+1; j2 < lessZeroList.length; j2++) {
				for (int k = 0; k < higherZeroList.length; k++) {
					if(lessZeroList[j]+lessZeroList[j2]+higherZeroList[k]==0)
					{
						//equal to zero
						List<Integer> tmpList=new ArrayList<>();
						tmpList.add(lessZeroList[j]);
						tmpList.add(lessZeroList[j2]);
						tmpList.add(higherZeroList[k]);
						finalList.add(tmpList);
					}
				}
				
			}
		}
		
		//find the two higher zero number with zero  
		Iterator<Map.Entry<Integer, Integer>> higherZeroIter=higherZeroMap.entrySet().iterator();
		while(higherZeroIter.hasNext())
		{
			Map.Entry<Integer, Integer> entry=higherZeroIter.next();
			if(entry.getValue()>1)
			{
				lessZeroSet.forEach(item->{
					if(entry.getKey()*2 + item == 0)
					{
						//equal to zero
						List<Integer> tmpList=new ArrayList<>();
						tmpList.add(entry.getKey());
						tmpList.add(entry.getKey());
						tmpList.add(item);
						finalList.add(tmpList);
					}
				});
			}
		}
		
		//find the two same less zero number
		Iterator<Map.Entry<Integer, Integer>> lessZeroIter=lessZeroMap.entrySet().iterator();
		while(lessZeroIter.hasNext())
		{
			Map.Entry<Integer, Integer> entry=lessZeroIter.next();
			if(entry.getValue()>1)
			{
				higherZeroSet.forEach(item->{
					if(entry.getKey()*2 + item == 0)
					{
						//equal to zero
						List<Integer> tmpList=new ArrayList<>();
						tmpList.add(entry.getKey());
						tmpList.add(entry.getKey());
						tmpList.add(item);
						finalList.add(tmpList);
					}
				});
			}
		}

		
        return finalList;
    }
}
