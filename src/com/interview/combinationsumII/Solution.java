package com.interview.combinationsumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 40. Combination Sum II

    Total Accepted: 83199
    Total Submissions: 280903
    Difficulty: Medium

Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is:

[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		mySolution.combinationSum2(new int[]{2,5,2,1,2}, 5);
		System.out.println("End");
	}
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        List<List<Integer>> resultList=new ArrayList<>();
	        Arrays.sort(candidates);
	        int total=0;
	        for (int i = 0; i < candidates.length; i++) {
				total+=candidates[i];
			}
	        if(target>total)
	        {
	        	return resultList;
	        }else if(target==total)
	        {
	        	List<Integer> com=new ArrayList<>();
	        	for (int i = 0; i < candidates.length; i++) {
					com.add(candidates[i]);
				}
	        	resultList.add(com);
	        	return resultList;
	        }
	        if(target < candidates[0])
	        {
	        	return resultList;
	        }else if(target == candidates[0])
	        {
	        	List<Integer> com=new ArrayList<>();
	        	com.add(candidates[0]);
	        	resultList.add(com);
	        	return resultList;
	        }
	        Set<Integer> prevSet=new HashSet<>();
	        for (int i = 0; i < candidates.length; i++) {
				if(prevSet.contains(candidates[i]))
				{
					continue;
				}
	        	List<Integer> com=new ArrayList<Integer>();
				com.add(candidates[i]);
				combination(resultList, com, Arrays.copyOfRange(candidates, i+1, candidates.length), target);
				prevSet.add(candidates[i]);
			}
	        return resultList;
	    }
	 public void combination(List<List<Integer>> coms,List<Integer> com,int[] candidates,int target)
	 {
		if(sums(com)==target)
		{
			List<Integer> newCom=new ArrayList<>(com);
			coms.add(newCom);
			return;
		}else if(sums(com)>target){
			return;
		}else{
			 Set<Integer> prevSet=new HashSet<>();
			for (int i = 0; i < candidates.length; i++) {
				if(prevSet.contains(candidates[i]))
				{
					continue;
				}
				com.add(candidates[i]);
				combination(coms, com, Arrays.copyOfRange(candidates, i+1, candidates.length), target);
				if(sums(com)>=target)
				{
					com.remove(com.size()-1);
					break;
				}
				com.remove(com.size()-1);
				prevSet.add(candidates[i]);
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
