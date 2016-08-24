package com.interview.linkedlistcycle;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.interview.reverselinkedlist.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 * @author mcgu
 *
 */
public class Solution {

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
		//head.next.next.next.next.next.next.next.next.next.next=head.next.next;
		System.out.println(hasCycle(head));
	}
	
public static boolean hasCycle(ListNode head) {
	if(head==null || head.next==null)
	{
		return false;
	}
		Set<ListNode> listSet=new HashSet<>();
		
		ListNode tmpHead=head;
		
	    while(tmpHead.next!=null)
	    {
	    	if(listSet.contains(tmpHead))
	    	{
	    		return true;
	    	}else{
	    		listSet.add(tmpHead);
	    	}
	    	tmpHead=tmpHead.next;
	    }
	    
        return false;
    }
}
