package com.interview.nextpermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;


/**
 * 31. Next Permutation

    Total Accepted: 78568
    Total Submissions: 285740
    Difficulty: Medium

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		mySolution.nextPermutation(new int[]{1,3,2});
	}
	public void nextPermutation(int[] nums) {
		if(nums.length==0||nums.length==1)
		{
			return;
		}
		List<Integer> tmpList=new ArrayList<>();
		int lastIndex=0;
		boolean foundLarger=false;
		int max1=0;
        for (int i = nums.length-1; i >=0; i--) {
			if(tmpList.isEmpty())
			{
				tmpList.add(nums[i]);
			}else{
				if(nums[i]<tmpList.get(tmpList.size()-1))
				{
					//Need to rearange the tmpList
					max1=tmpList.get(tmpList.size()-1);
					max1=findLarger(tmpList, nums[i] );
					tmpList.remove(tmpList.indexOf(max1));
					tmpList.add(nums[i]);
					Collections.sort(tmpList);
					lastIndex=i;
					foundLarger=true;
					break;
				}else{
					lastIndex=i;
					tmpList.add(nums[i]);
				}
			}
		}
        
        
        if(foundLarger==true)
        {
        	nums[lastIndex]=max1;
        	for (int i = lastIndex+1; i < nums.length; i++) {
				nums[i]=tmpList.get(i-lastIndex-1);
			}
        }
        else{
        	Arrays.sort(nums);
        }
        
        System.out.println(Arrays.toString(nums));
        
    }
	/**
	 * Find the item which is larger than target but the smallest in the input List
	 * @param input
	 * @param target
	 * @return
	 */
	public int findLarger(List<Integer> input,int target)
	{
		String test="";
		
		for (int i = 0; i < input.size(); i++) {
			if(input.get(i)>target)
			{
				return input.get(i);
			}
		}
		return -1;
	}
	
	
}
