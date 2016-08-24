package com.interview.removeduplicatefromsortedlist;

import com.interview.removeduplicatefromsortedlist.ListNode;;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(1);
		head.next=new ListNode(1);
		head.next.next=new ListNode(1);
		head.next.next.next=new ListNode(1);
		
		printList(head);
		System.out.println("---------------");
		printList(deleteDuplicates(head));
		//printList(head);
		
//		head.next.next.next=new ListNode(7);
//		head.next.next.next.next=new ListNode(6);
//		head.next.next.next.next.next=new ListNode(5);
//		head.next.next.next.next.next.next=new ListNode(4);
//		head.next.next.next.next.next.next.next=new ListNode(3);
		
	}
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next==null)
		{
			return head;
		}
		ListNode tmpNode=head;
		while(tmpNode!=null)
		{
			if(tmpNode.next==null)
			{
				break;
			}
			while(tmpNode.next!=null && tmpNode.val==tmpNode.next.val  )
			{
				tmpNode.next=tmpNode.next.next;
			}
			
			tmpNode=tmpNode.next;
		}
		
        return head;
    }
	
	public static void printList(ListNode head)
	{
		ListNode tmpHead=head;
		while(tmpHead!=null)
		{
			System.out.println(tmpHead.val);
			if(tmpHead.next!=null)
			{
				ListNode next=tmpHead.next;
				tmpHead=next;
			}else{
				
				break;
			}
		}
	}
}
