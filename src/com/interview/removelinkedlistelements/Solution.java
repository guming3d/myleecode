package com.interview.removelinkedlistelements;

import com.interview.reverselinkedlist.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(10);
//		head.next=new ListNode(9);
//		head.next.next=new ListNode(8);
//		head.next.next.next=new ListNode(7);
//		head.next.next.next.next=new ListNode(6);
//		head.next.next.next.next.next=new ListNode(5);
//		head.next.next.next.next.next.next=new ListNode(4);
//		head.next.next.next.next.next.next.next=new ListNode(3);
//		head.next.next.next.next.next.next.next.next=new ListNode(2);
//		head.next.next.next.next.next.next.next.next.next=new ListNode(1);
		removeElements(head,10);
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
	        	}
	        }
	        ListNode currNode=head;
	        ListNode prevNode=head;
	        while(currNode.next!=null)
	        {
	        	if(currNode.val==val)
	        	{
	        		if(prevNode==currNode)
	        		{
	        			//need to remove current node and move the head to next node
	        			head=currNode.next;
	        			prevNode=currNode.next;
	        			currNode=currNode.next;
	        		}else{
	        			prevNode.next=currNode.next;
	        			currNode=currNode.next;
	        		}
	        	}else{
	        		prevNode=currNode;
	        		currNode=currNode.next;
	        	}
	        }
	        if(currNode.val==val)
	        {
	        	if(prevNode==currNode)
	        	{
	        		return null;
	        	}else{
	        		prevNode.next=null;
	        	}
	        }
	        
	        return head;
	    }
}
