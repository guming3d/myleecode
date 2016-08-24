package com.interview.removelinkedlistelement;
/**
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5 
 * @author guming
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root=new ListNode(1);
		root.next=new ListNode(2);
		root.next.next=new ListNode(3);
		root.next.next.next=new ListNode(3);
		removeElements(root,3);
	}
public static ListNode removeElements(ListNode head, int val) {
        if(head==null)
        {
        	return null;
        }
        if(head.next==null)
        {
        	if(head.val==val)
        	{
        		return null;
        	}else{
        		return head;
        	}
        }
        
        ListNode currHead=head;
        while(currHead.next!=null)
        {
        	if(currHead.val==val)
        	{
        		//need to remove currHead
        		currHead.val=currHead.next.val;
        		if(currHead.next.next!=null)
        		{
        			currHead.next=currHead.next.next;
        		}else{
        			currHead.next=null;
        		}
        	}
        	currHead=currHead.next;
        }
        return head;
       }
        
    
}
