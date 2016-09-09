package com.interview.permutationsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 60. Permutation Sequence

    Total Accepted: 63705
    Total Submissions: 243693
    Difficulty: Medium

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		mySolution.getPermutation2(4, 2);
		//System.out.println(mySolution.getPermutation(9, 54494));
	}
public String getPermutation(int n, int k) {
        int[] myArray=new int[n];
        for (int i = 0; i < myArray.length; i++) {
			myArray[i]=i+1;
		}
        List<List<Integer>> myFinalList=new ArrayList<>();
        myFinalList=permute(myArray);
        List<Integer> finalIntList=new ArrayList<>();
        int[] finalArray=new int[myFinalList.size()];
        for(int i=0;i<myFinalList.size();i++)
        {
        	int total=0;
        	for (int j = 0; j < myFinalList.get(i).size(); j++) {
				total=total*10+myFinalList.get(i).get(j);
			}
        	finalArray[i]=total;
        }
        Arrays.sort(finalArray);
        //System.out.println(Arrays.toString(finalArray));
        return Integer.toString(finalArray[k-1]);
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

public String getPermutation2(int n, int k) {
	List<Integer> numberList=new ArrayList<>();
	for (int i = 0; i < n; i++) {
		numberList.add(i+1);
	}
	
	long[] dupNumberList=new long[n];
	for (int i = 0; i < n; i++) {
		dupNumberList[i]=getFactorial(n-i)/(n-i);
	}
	System.out.println(numberList.toString());
	System.out.println(Arrays.toString(dupNumberList));
	
	for (int i = 1; i < n; i++) {
		
	}
	
	return "";
	
}
public  long getFactorial(int n)
{
	if(n<0)
	{
		throw new IllegalArgumentException("n must be larger than 0");
	}
	if(n==1)
	{
		return 1;
	}
	int total=1;
	for (int i = 1; i <= n; i++) {
		total*=i;
	}
//	System.out.println(total);
	return total;
	
}
}
