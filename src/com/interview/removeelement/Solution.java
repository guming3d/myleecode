package com.interview.removeelement;
/**
 * Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] testNum={7,7,7,6,7};
		System.out.println(removeElement(testNum,7));
	}
	
	 public static int removeElement(int[] nums, int val) {

		 if(nums.length==0)
		 {
			 return 0;
		 }
		 
		 if(nums.length==1)
		 {
			 if(nums[0]==val)
			 {
				 return 0;
			 }else{
				 return 1;
			 }
		 }
		 
		 int totalLength=nums.length;
			for (int i = 0; i < nums.length; i++) {
				if(nums[i]==val)
				{
					totalLength--;
				}
			}
		 	for (int i = 0; i < nums.length; i++) {
				if(nums[i]==val)
				{
					boolean rightchange=false;
					for (int j = i; j < nums.length; j++) {
						if(nums[j]!=val)
						{
							nums[i]=nums[j];
							nums[j]=val;
							rightchange=true;
							break;
						}
					}
					if(rightchange==false)
					{
						break;
					}
						
				}
				
			}
		 	
		 	
	        return totalLength;
	    }
}
