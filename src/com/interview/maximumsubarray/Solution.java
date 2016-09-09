package com.interview.maximumsubarray;

public class Solution {
	public static void main(String args[])
	{
		maxSubArray(new int[]{-3,1,-2,2});
	}
    public static int maxSubArray(int[] nums) {
        if(nums.length==0)
	        {
	            return 0;
	        }
	        if(nums.length==1)
	        {
	            return nums[0];
	        }
	        
	        //first find the number larger or equal than zero
	        int index=-1;
	        int largestNumber=nums[0];
	        for (int i = 0; i < nums.length; i++) {
				if(nums[i]>=0)
				{
					index=i;
					break;
				}
				if(nums[i]>largestNumber)
				{
					largestNumber=nums[i];
				}
			}
	        if(index==-1)
	        {
	        	//all the number is less than zero
	        	return largestNumber;
	        }
	        
	        int maxSum=0;
	        int startIndex=index;
	        int currentIndex=index;
	        int currentMax=nums[startIndex];
	        
	        while(startIndex<=nums.length-1)
	        {
	            currentMax=nums[startIndex];
	            currentIndex=startIndex+1;//set the currentIndex to next number
	            if(startIndex==nums.length-1)
	            {
	            		return Math.max(currentMax, maxSum);
	            }
	           
//	           if(currentIndex==nums.length-1)
//	           {
//	               if(nums[currentIndex]<0)
//	               {
//	                   if(currentMax>maxSum)
//	                   {
//	                       maxSum=currentMax;
//	                   }
//	                   
//	               }else{
//	                  currentMax+=nums[currentIndex];
//	                  if(currentMax>maxSum)
//	                   {
//	                       maxSum=currentMax;
//	                   }
//	               }
//	               break;
//	           }
	           
		        insideLoop:
				while (currentIndex <= nums.length - 1) {
					if (nums[currentIndex] >= 0) {
						currentMax += nums[currentIndex];
	
						currentIndex++;
						continue;
					} else {
						if (currentMax > maxSum) {
							maxSum = currentMax;
						}
						currentMax += nums[currentIndex];
						if (currentMax > 0) {
							currentIndex++;
							continue;
						} else {
							// find the next larger zero start
	
							int nextLargerNumber = currentIndex + 1;
							while (nextLargerNumber <= nums.length - 1) {
								if (nums[nextLargerNumber] > 0) {
									currentIndex = nextLargerNumber;
									
									break insideLoop;
								} else {
									nextLargerNumber++;
								}
							}
							//all the following number is less than zero
							return Math.max(currentMax, maxSum);
						}
	
					}
				}

	        
			startIndex = currentIndex;


		}
//	        if(nums[startIndex]>0)
//	        {
//	        	currentMax=Math.max(nums[startIndex], currentMax);
//	        }
	        
	        return Math.max(currentMax, maxSum);
    }
}
