package com.interview.reverselinkedlist;
/**
 * Reverse a singly linked list.
 * @author mcgu
 *
 */
public class Solution {

	public static ListNode reverseHead;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(10);
		head.next=new ListNode(9);
		head.next.next=new ListNode(8);
		head.next.next.next=new ListNode(7);
		head.next.next.next.next=new ListNode(6);
		head.next.next.next.next.next=new ListNode(5);
		head.next.next.next.next.next.next=new ListNode(4);
		head.next.next.next.next.next.next.next=new ListNode(3);
		head.next.next.next.next.next.next.next.next=new ListNode(2);
		head.next.next.next.next.next.next.next.next.next=new ListNode(1);
		
		ListNode tmphead=head;
		while(tmphead.next!=null)
		{
			System.out.println(tmphead.val);
			tmphead=tmphead.next;
		}
		System.out.println(tmphead.val);
		
		System.out.println("----------------------------");
		//ListNode reverseNode=reverseLinkedList(head);
		
		ListNode reverseNode=reverseLinkedList2(head);
	
		
		ListNode tmpReverse=reverseNode;
		
		while(reverseNode.next!=null)
		{
			System.out.println(reverseNode.val);
			reverseNode=reverseNode.next;
		}
		System.out.println(reverseNode.val);
	}
	
//	public static ListNode reverseLinkedList(ListNode head)
//	{
//		if(head==null)
//		{
//			return null;
//		}
//		if(head.next==null)
//		{
//			return head;
//		}
//		
//		ListNode reverseHead=null; //pointer to new reversed head
//		while(head.next!=null){
//			ListNode tmpNode=head;
//			head=head.next;
//			tmpNode.next=reverseHead;
//			reverseHead=tmpNode;
//
//		}
//		if(head.next==null)
//		{
//			ListNode tmpNode=head;
//			tmpNode.next=reverseHead;
//			reverseHead=tmpNode;
//		}
//		
//		return reverseHead;
//	}

	public static ListNode reverseLinkedList(ListNode head)
	{
		reverseList(head).next=null;
		
		return reverseHead;
		
	}
	
	public static ListNode reverseList(ListNode head)
	{
		if(head.next==null)
		{
			reverseHead=head;
			return head;
		}
		else
		{
			ListNode next=head.next;
//			head.next=null;
			ListNode tmpTail=reverseList(next);
			tmpTail.next=head;
			return head;
		
		}
	}
	
	public static ListNode reverseLinkedList2(ListNode head)
	{
		ListNode prev=null;
		ListNode currNode=head;
		while(currNode!=null)
		{
			ListNode tmpNode=currNode.next;
			currNode.next=prev;
			prev=currNode;
			currNode=tmpNode;
		}
		return prev;
	}
	
}
