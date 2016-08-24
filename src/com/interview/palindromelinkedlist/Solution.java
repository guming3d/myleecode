package com.interview.palindromelinkedlist;

import java.util.Stack;

/**
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 * @author guming
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public boolean isPalindrome(ListNode head) {
        if(head==null)
        {
        	return false;
        }
        if(head.next==null)
        {
        	return true;
        }
        
		Stack<Integer> myStack=new Stack<>();
		ListNode currHead=head;
        while(currHead.next!=null)
        {
        	myStack.push(currHead.val);
        	currHead=currHead.next;
        }
        myStack.push(currHead.val);
        
        currHead=head;
        while(currHead.next!=null)
        {
        	if(currHead.val!=myStack.peek())
        	{
        		return false;
        	}else{
        		myStack.pop();
        	}
        	currHead=currHead.next;
        }
        if(currHead.val!=myStack.peek())
    	{
    		return false;
    	}
        return true;
    }
}
