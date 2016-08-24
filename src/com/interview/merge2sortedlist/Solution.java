package com.interview.merge2sortedlist;
/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author mcgu
 *
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root1=new ListNode(0);
		ListNode root2=new ListNode(1);
		root2.next=new ListNode(3);
		printList(mergeTwoLists(root1,root2));
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode finalHead = new ListNode(0);
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		while (l1.next != null || l2.next != null) {
			if (l1.val <= l2.val) {
				if (head == null) {
					finalHead = l1;
					head = l1;
					System.out.println("head list1 ->" + l1.val);

				} else {
					System.out.println("list1 ->" + l1.val);
					head.next = l1;
					head = head.next;

				}
				if (l1.next == null) {
					head.next=l2;
					break;
				}else
				{
					l1 = l1.next;	
				}
				
			} else {
				if (head == null) {
					finalHead = l2;
					head = l2;
					System.out.println("head list2 ->" + l2.val);

				} else {
					head.next = l2;
					head = head.next;
					System.out.println("list2 ->" + l2.val);
				}
				if(l2.next==null)
				{
					head.next=l1;
					break;
				}else
				{
					l2 = l2.next;	
				}
				
			}
		}

		if (l1.val <= l2.val) {
			if(head==null)
			{
				head=l1;
				finalHead = l1;
				head.next=l2;
			}else
			{
				head.next = l1;
				head.next.next = l2;
			}
			
		} else {
			if(head == null)
			{
				head=l2;
				finalHead = l2;
				head.next=l1;
			}else
			{
				head.next = l2;
				head.next.next = l1;
			}
			
		}
		return finalHead;
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
