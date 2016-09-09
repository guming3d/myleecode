package com.interview.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. Permutations

    Total Accepted: 118125
    Total Submissions: 309960
    Difficulty: Medium

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		mySolution.permute(new int[]{1,2,3});
	}
	public List<List<Integer>> permute(int[] nums) {
		if(nums.length==0)
		{
			
			return new ArrayList<List<Integer>>();
		}
		if(nums.length==1){
			List<Integer> myList=new LinkedList<>(Arrays.asList(nums[0]));
			List<List<Integer>> finalList=new ArrayList<>();
			finalList.add(myList);
			return finalList;
		}
		
        List<List<Integer>> resultList=new ArrayList<>();
        List<Integer> currentList=new LinkedList<>();
        currentList.add(nums[0]);
        resultList.add(currentList);
        for (int i = 1; i < nums.length; i++) {
        	int index=0;
        	List<List<Integer>> nextRoundList=new ArrayList<>();
        	while(!resultList.isEmpty())
			{
        		//first get one List
				List<Integer> tmpList=resultList.get(index);
				resultList.remove(index);
				//index++;
				//using loop to add current number to different locations
				//set the newly added list to nextRoundList
				
				for (int j = 0; j < tmpList.size(); j++) {
					LinkedList<Integer> curList=new LinkedList<>();
					curList.clear();
					curList.addAll(tmpList);
					curList.add(j,nums[i]);
					nextRoundList.add(curList);
				}
				//adding to tail of the pre list
				LinkedList<Integer> curList=new LinkedList<>();
				curList.clear();
				curList.addAll(tmpList);
				curList.addLast(nums[i]);
				nextRoundList.add(curList);
				
			}
        	resultList.addAll(nextRoundList);
		}
        return resultList;
    }
}
