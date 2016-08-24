package com.interview.swapnodesinpairs;

import com.interview.reverselinkedlist.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(10);
		head.next=new ListNode(9);
//		head.next.next=new ListNode(8);
//		head.next.next.next=new ListNode(7);
//		head.next.next.next.next=new ListNode(6);
//		head.next.next.next.next.next=new ListNode(5);
//		head.next.next.next.next.next.next=new ListNode(4);
//		head.next.next.next.next.next.next.next=new ListNode(3);
//		head.next.next.next.next.next.next.next.next=new ListNode(2);
//		head.next.next.next.next.next.next.next.next.next=new ListNode(1);
		swapPairs(head);
	}
	public static ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null)
		{
			return head;
		}
		ListNode nextRound = head.next.next;
		ListNode finalHead=head.next;
		ListNode tailLast=head;
		while(nextRound!=null)
		{
			tailLast.next=head.next;
			
			tailLast=head;
			head.next.next=head;
			head.next=nextRound;
			head=nextRound;
			
			if(head.next==null)
			{
				break;
			}else
			{
				nextRound=head.next.next;
			}
		}
		if(head.next!=null)
		{
			tailLast.next=head.next;
			tailLast=head;
			head.next.next=head;
			head.next=nextRound;
		}else
		{
			tailLast.next=head;
		}
		

		
		
        return finalHead;
    }
}
