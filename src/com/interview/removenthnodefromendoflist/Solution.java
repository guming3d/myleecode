package com.interview.removenthnodefromendoflist;
/**
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		ListNode root=new ListNode(1);
		root.next=new ListNode(2);
//		root.next.next=new ListNode(3);
//		root.next.next.next=new ListNode(4);
//		root.next.next.next.next=new ListNode(5);
		mySolution.removeNthFromEnd(root,1);
		

	}
	 public ListNode removeNthFromEnd(ListNode head, int n) {
		 if(head==null)
		 {
			 return null;
		 }
		 if(head.next==null && n==1)
		 {
			 return null;
		 }
		 //first use two pointers 
		 ListNode myHead=head;
		 ListNode currNode=head;
		 ListNode frontNode=head;
		 //first move the frontNode to the nth node
		 if(n>1)
		 {
		 for (int i = 1; i < n; i++) {
			 if(frontNode.next!=null)
			 {
				 frontNode=frontNode.next;
			 }else{
				 System.out.println("n is not valid");
			 }
		}
		 while(frontNode.next!=null)
		 {
			 currNode=currNode.next;
			 frontNode=frontNode.next;
		 }
		 //now currNode point to the node before the node to be removed

		 currNode.val=currNode.next.val;
		 currNode.next=currNode.next.next;
		 
		 }else{
			 while(!(frontNode.next.next==null))
			 {
				 frontNode=frontNode.next;
			 }
			 frontNode.next=null;
		 }
		 
	        return myHead;
	    }
}
