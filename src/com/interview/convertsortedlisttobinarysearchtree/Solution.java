package com.interview.convertsortedlisttobinarysearchtree;

import java.util.Arrays;


/*
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		ListNode head=new ListNode(1);
		head.next=new ListNode(3);
		TreeNode root=mySolution.sortedListToBST(head);
	}
	public  TreeNode sortedListToBST(ListNode head) {
		if(head==null )
        {
            return null;
        }
        if(head.next==null)
        {
            return new TreeNode(head.val);
        }
		   ListNode tmpIter=head;
		   int size=1;
		   while(tmpIter.next!=null)
		   {
			   size++;
			   tmpIter=tmpIter.next;
		   }
		   int[] nums=new int[size];
		   int index=0;
		   tmpIter=head;
		   while(tmpIter.next!=null)
		   {
			  nums[index]=tmpIter.val;
			   tmpIter=tmpIter.next;
			   index++;
		   }
		   nums[index]=tmpIter.val;
		   
		   sortedArrayToBST(nums);
		  	        
	        return sortedArrayToBST(nums);
    }
	
	public  TreeNode sortedArrayToBST(int[] nums) {
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
