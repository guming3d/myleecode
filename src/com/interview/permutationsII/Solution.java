package com.interview.permutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.interview.permutations.Solution;

/**
 * 47. Permutations II

    Total Accepted: 85105
    Total Submissions: 287963
    Difficulty: Medium

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:

[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Solution mySolution=new Solution();
				mySolution.permuteUnique(new int[]{1,1,2,2});
	}
public List<List<Integer>> permuteUnique(int[] nums) {
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
				if(j>0 && (curList.get(j-1)==nums[i]))
				{
					continue;
				}
				curList.add(j,nums[i]);
				if(!containList(nextRoundList,curList))
				{
					nextRoundList.add(curList);
				}
				
			}
			//adding to tail of the pre list
			LinkedList<Integer> curList=new LinkedList<>();
			curList.clear();
			curList.addAll(tmpList);
			if(curList.getLast()==nums[i])
			{
				continue;
			}
			curList.addLast(nums[i]);
			if(!containList(nextRoundList,curList))
			{
				nextRoundList.add(curList);
			}
			
		}
    	resultList.addAll(nextRoundList);
	}
    return resultList;  
    }

public boolean containList(List<List<Integer>> sourceList,List<Integer> targetList)
{
	boolean result=false;
	
	for(List<Integer> item:sourceList)
	{
		if(item.size()==targetList.size())
		{
			int lastIndex=0;
			for (int i = 0; i < item.size(); i++) {
				if(item.get(i)!=targetList.get(i))
				{
					lastIndex=i;
					break;
				}else{
					lastIndex=i;
					continue;
				}
				
			}
			if(lastIndex==item.size()-1)
			{
				return true;
			}
		}
	}
	return result;
}
}
