package com.interview.intersectionoftwolinkedlists;

import com.interview.reverselinkedlist.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode headTail=new ListNode(77);
		
		ListNode head1=new ListNode(10);
		head1.next=new ListNode(9);
		head1.next.next=new ListNode(8);
		head1.next.next.next=new ListNode(7);
		head1.next.next.next.next=new ListNode(6);
		//head1.next.next.next.next.next=headTail;
		
		ListNode head2=new ListNode(1);
//		head2.next=new ListNode(1);
//		head2.next.next=new ListNode(1);
		//head2.next.next.next=headTail;
		
		headTail.next=new ListNode(78);
		headTail.next.next=new ListNode(79);
		headTail.next.next.next=new ListNode(80);
		getIntersectionNode(head1, head2);
	}
	 public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        int listlength1=0;
	        int listlength2=0;
	        if(headA==null)
	        {
	        	return null;
	        }
	        if(headB==null)
	        {
	        	return null;
	        }
	        
	        
	        
	        
	        
	        //calculate the length of two linked list
	        ListNode currNode=headA;
	        if(headA.next==null)
	        {
	        	listlength1=1;
	        }else{
	        	while(currNode.next!=null)
		        {
		        	listlength1++;
		        	currNode=currNode.next;
		        }
		        listlength1+=1;
	        }
	        
	        currNode=headB;
	        if(headB.next==null)
	        {
	        	listlength2=1;
	        }else{
	        	while(currNode.next!=null)
		        {
		        	listlength2++;
		        	currNode=currNode.next;
		        }
		        listlength2+=1;
	        }
	        
	        if(listlength1==1 && listlength2==1)
	        {
	        	if(headA==headB)
	        	{
	        		return headA;
	        	}else{
	        		return null;
	        	}
	        	
	        }
	        
	        System.out.println("length 1 is "+listlength1+", length 2 is "+listlength2);
	        
	        ListNode checkStart1=headA;
	        ListNode checkStart2=headB;
	       if(listlength1==listlength2)
	       {
	    	   checkStart1=headA;
	    	   checkStart2=headB;
	       }else{
	    	   if(listlength1>listlength2)
	    	   {
	    		   checkStart2=headB;
	    		   for (int i = 0; i < listlength1 - listlength2; i++) {
	    			   checkStart1=checkStart1.next;
	    		   }
	    	   }else{
	    		   checkStart1=headA;
	    		   for (int i = 0; i < listlength2 - listlength1; i++) {
	    			   checkStart2=checkStart2.next;
	    		   }
	    	   }
	       }
	       //now we get the start of checking point, walk through these node
	       while(checkStart1!=checkStart2)
	       {
	    	   if(checkStart1.next==null && checkStart2.next==null)
	    	   {
	    		   return null;
	    	   }
	    	   else{
	    		   checkStart1=checkStart1.next;
	    		   checkStart2=checkStart2.next;
	    	   }
	       }
	       return checkStart1;
	        
	        
	        
	    }
}
