package com.interview.mergetwosortedlists;
import com.interview.mergetwosortedlists.ListNode;
/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author guming
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root1=new ListNode(1);
		root1.next=new ListNode(1);
		root1.next.next=new ListNode(1);
		root1.next.next.next=new ListNode(4);
		root1.next.next.next.next=new ListNode(5);
		root1.next.next.next.next.next=new ListNode(9);
		
		ListNode root2=new ListNode(1);
		root2.next=new ListNode(1);
		root2.next.next=new ListNode(1);
		root2.next.next.next=new ListNode(4);
		root2.next.next.next.next=new ListNode(5);
		root2.next.next.next.next.next=new ListNode(9);
		
		ListNode resultHead=mergeTwoLists(root1,root2);
		ListNode walkhead=resultHead;
		while(walkhead!=null)
		{
			System.out.println(walkhead.val);
			walkhead=walkhead.next;
		}
		
		
	}
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	
    	ListNode head=null;
    	ListNode finalHead=new ListNode(0);
//    	if(l1.val<=l2.val)
//    	{
//    		head=l1;
//    	}
//    	else
//    	{
//    		head=l2;
//    	}
    	boolean l1done=false;
    	boolean l2done=false;
    	while(l1.next!=null || l2.next!=null)
    	{
    		if(l1.val <= l2.val)
    		{
    			if(head==null)
    			{
    				finalHead=l1;
    				head=l1;
    				System.out.println("head list1 ->"+l1.val);
    				
    			}else
    			{
    				System.out.println("list1 ->"+l1.val);
    				head.next=l1;
    				head=head.next;

    				
    			}
    			if(l1.next==null)
    			{
    				
    			}
    			l1=l1.next;
    		}
    		else
    		{
    			if(head==null)
    			{
    				finalHead=l2;
    				head=l2;
    				System.out.println("head list2 ->"+l2.val);
    				
    			}else
    			{
    				head.next=l2;
    				head=head.next;
    				System.out.println("list2 ->"+l2.val);
    			}
    			l2=l2.next;
    		}
    	}

    	if(l1.val<=l2.val)
    	{
    		head.next=l1;
    		head.next.next=l2;
    	}else{
    		head.next=l2;
    		head.next.next=l1;
    	}
        return finalHead;
    }
}
