package com.interview.leetcode.RotateArray;

import java.util.Arrays;

/**
 * 
 * Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * @author mcgu
 *
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] testNum={12,3,5,8,1,0,45,33};
		//new Solution().rotate(testNum,50);
		new Solution().rotate2(testNum,3);
	}
	/**
	 * Roate using another tmp array
	 * @param nums
	 * @param k
	 */
    public void rotate(int[] nums, int k) {
        int[] tmp=new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length;i++)
        {
        	tmp[i]=nums[i];
        }
        int finalChange;
        
        if(k> nums.length){
        	finalChange= k % nums.length;	
        }else{
        	finalChange=k;
        }
        
        if(finalChange > 0)
        {
        	 for(int i=(nums.length - finalChange);i<nums.length;i++){
             	tmp[j]=nums[i];
             	j++;
             }
        	 
        	for(int i=0;i<(nums.length - finalChange);i++)
        	{
        		tmp[j]=nums[i];
        		j++;
        	}
        }
        
        for(int i=0;i<nums.length;i++)
        {
        	nums[i]=tmp[i];
        	System.out.print(nums[i]+",");
        }
        
    }
    
    /**
     * Rotate do not using another array
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
    	int finalChange=0;
    	if(k>nums.length)
    	{
    		finalChange=k % nums.length;
    	}else{
    		finalChange= k;
    	}
    	int tmpNumber;
    	for(int i=0;i<finalChange;i++)
    	{
    		tmpNumber=nums[nums.length-1];
    		for(int j=nums.length-1;j>0;j--)
    		{
    			nums[j]=nums[j-1];
    		}
    		nums[0]=tmpNumber;
    		
    	}
    	
    	System.out.println(Arrays.toString(nums));
    	
    }
    
    

}
