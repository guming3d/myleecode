package com.interview.productofarrayexceptself;
/**
 *  Given an array of n integers where n > 1, nums, 
 *  return an array output such that output[i] is equal to the 
 *  product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: 
The output array does not count as extra space for the purpose of space complexity analysis.)
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] productExceptSelf(int[] nums) {
        int[] resultLeft=new int[nums.length];
        for (int i = 0; i < resultLeft.length; i++) {
			if(i==0)
			{
				resultLeft[i]=1;
			}else{
				resultLeft[i]=resultLeft[i-1] * nums[i-1];
			}
		}
        int[] resultRight=new int[nums.length];
        for (int i = nums.length-1; i >= 0; i--) {
			if(i==nums.length-1)
			{
				resultRight[i]=1;
			}else{
				resultRight[i]=resultRight[i+1]*nums[i+1];
			}
		}
        int[] finalResult=new int[nums.length];
        for (int i = 0; i < finalResult.length; i++) {
			finalResult[i]=resultLeft[i]*resultRight[i];
		}
        return finalResult;
        
    }
}
