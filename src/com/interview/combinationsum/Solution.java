package com.interview.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum

    Total Accepted: 112810
    Total Submissions: 335729
    Difficulty: Medium

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:

[
  [7],
  [2, 2, 3]
]

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		mySolution.combinationSum(new int[]{2, 3, 6, 7}, 34);
		System.out.println("End");
	}
public List<List<Integer>> combinationSum(int[] candidates, int target) {
	Arrays.sort(candidates);
    List<List<Integer>> coms=new ArrayList<>();
    if(target<candidates[0])
    {
    	//no candidate possible, just return a null List
    	return coms;
    }
    
    
    for (int i = 0; i < candidates.length; i++) {
    	List<Integer> com=new ArrayList<>();
    	com.add(candidates[i]);
    	combination(coms,com,candidates,target);
	}
	return coms;
    }

public void combination(List<List<Integer>> coms,List<Integer> com,int[] source, int target)
{
	int sum=sums(com);
	if(sum==target)
	{
		
		List<Integer> newCom=new ArrayList<>(com);
		coms.add(newCom);
	}else if(sum>target)
	{
		return;
	}else{
		for (int i = 0; i < source.length; i++) {
			//Using this if statement is critical to reduce no need comparation
			if(source[i]>=com.get(com.size()-1))
			{
				com.add(source[i]);
				combination(coms,com,source,target);
				if(sums(com)>=target)
				{
					com.remove(com.size()-1);
					break;
				}
				com.remove(com.size()-1);
			}else{
				//Using continue is critical
				continue;
			}
			
		}
	}
}

public int sums(List<Integer> com)
{
	int total=0;
	for (int i = 0; i < com.size(); i++) {
		total+=com.get(i);
	}
	return total;
	}
}
