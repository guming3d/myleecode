package com.interview.convertsortedarraytobinarysearchtree;

import java.util.Arrays;

/**
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sortedArrayToBST(new int[]{1,2,3,4});
	}
	public static TreeNode sortedArrayToBST(int[] nums) {
	        if(nums.length==1 )
	        {
	        	return new TreeNode(nums[0]);
	        }
	        if(nums.length==0 )
	        {
	        	return null;
	        }
	        int middle=0;
	        if(nums.length % 2==0)
	        {
	        	middle=nums.length/2 -1; //set the middle to the middle left of the array
	        }else{
	        	middle=nums.length/2;
	        }
	        TreeNode root=new TreeNode(nums[middle]);
	        root.left=sortedArrayToBST(Arrays.copyOfRange(nums, 0, middle));
	        
	        root.right=sortedArrayToBST(Arrays.copyOfRange(nums, middle+1, nums.length));
	        
	        return root;
	        
	    }
}
