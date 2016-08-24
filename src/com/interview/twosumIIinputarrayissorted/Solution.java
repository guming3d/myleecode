package com.interview.twosumIIinputarrayissorted;
/**
 * Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers 
(both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		twoSum2(new int[]{2,3,4,7,8,},12);
	}
	 public static int[] twoSum(int[] numbers, int target) {
		 
		  for (int i = 0; i < numbers.length; i++) {
			
			  for (int j = i+1; j < numbers.length; j++) {
				if(numbers[i]+numbers[j]==target)
				{
					return new int[]{i+1,j+1};
				}
				else if(numbers[i]+numbers[j]<target)
				{
					continue;
				}else if(numbers[i]+numbers[j]>target)
				{
					break;
				}
			}
		}
	        return new int[]{};
	    }
	 //使用二叉查找剩下的那个值
	 public static int[] twoSum2(int[] numbers, int target) {
		 
		  for (int i = 0; i < numbers.length; i++) {
			  int index=binaryFindNum(numbers,i+1,numbers.length-1,target-numbers[i]);
			if(index!=-1)
			{
				System.out.println("found the number");
				return new int[]{i+1,index+1};
			}
			
		  }
	        return new int[]{};
	    }
	 
	 public static int binaryFindNum(int[] numbers,int startIndex,int endIndex,int target)
	 {
		 int middle=startIndex+ (endIndex-startIndex)/2;
		 if(numbers[middle]==target)
		 {
			 return middle;
		 }else if(startIndex==endIndex)
		 {
			 if(numbers[startIndex]==target)
			 {
				 return startIndex;
			 }
				 return -1;
	
		 }else if(startIndex > endIndex)
		 {
			 return -1;
		 }else if(numbers[middle]<target){
			// startIndex=middle+1;
			 return binaryFindNum(numbers,middle+1,endIndex,target);
		 }else if(numbers[middle]>target){
			// startIndex=middle+1;
			 return binaryFindNum(numbers,startIndex,middle-1,target);
		 }
		 return -1;
	 }
}
