package com.interview.combinationsum3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 216. Combination Sum III

    Total Accepted: 44616
    Total Submissions: 112667
    Difficulty: Medium

Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]


Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		mySolution.combinationSum3(4, 30);
	}
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> resultList=new ArrayList<>();
        int minumum=0;
        for (int i = 1; i <= k; i++) {
			minumum+=i;
		}
        int maximum=0;
        for (int i = 0; i < k; i++) {
        	maximum+=9-i;
		}
        if(n<minumum||n>maximum)
        {
        	return resultList;
        }
        int[] sourceArr=new int[9];
        for (int i = 0; i < sourceArr.length; i++) {
			sourceArr[i]=i+1;
		}
        
        for (int i = 0; i < 9-k+2; i++) {
			List<Integer> com=new ArrayList<>();
			com.add(sourceArr[i]);
			combination(resultList,com,Arrays.copyOfRange(sourceArr, i+1, sourceArr.length),n,k);
		}
        System.out.println("Final");
        return resultList;
    }
	public void combination(List<List<Integer>> coms,List<Integer> com,int[] source,int n,int k)
	{
		if(totalComs(com)==n && com.size()==k)
		{
			List<Integer> newCom=new ArrayList<>(com);
			coms.add(newCom);
		}else if(totalComs(com) > n || com.size()>=k)
		{
			return;
		}
		else{
			for (int i = 0; i < source.length; i++) {
				com.add(source[i]);
				combination(coms,com,Arrays.copyOfRange(source, i+1, source.length),n,k);
				if(totalComs(com)>=n)
				{
					com.remove(com.size()-1);
					break;
				}
				com.remove(com.size()-1);
			}
		}
	}
	
	public int totalComs(List<Integer> com){
		int total=0;
		for (int i = 0; i < com.size(); i++) {
			total+=com.get(i);
		}
		return total;
	}
	
}
