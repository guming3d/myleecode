package com.interview.addtwonumbers;

import java.util.ArrayList;
import java.util.List;


/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 *  Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * @author guming
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root1=new ListNode(5);
		root1.next=new ListNode(2);
		root1.next.next=new ListNode(8);
		root1.next.next.next=new ListNode(4);
//		root1.next.next.next.next=new ListNode(5);
//		root1.next.next.next.next.next=new ListNode(9);
		
		ListNode root2=new ListNode(7);
		root2.next=new ListNode(3);
		root2.next.next=new ListNode(7);
		addTwoNumbers2(root1,root2);
		
	}
	
public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        ListNode tmpHead=l1;
        while(tmpHead!=null)
        {
        	list1.add(tmpHead.val);
        	tmpHead=tmpHead.next;
        }
        tmpHead=l2;
        while(tmpHead!=null)
        {
        	list2.add(tmpHead.val);
        	tmpHead=tmpHead.next;
        }
        if(list1.size()==0)
        {
        	return l2;
        }
        if(list2.size()==0)
        {
        	return l2;
        }
        int num1Value=0;
        int num2Value=0;
        
        for (int i = 0; i <= list1.size()-1 ; i++) {
        	num1Value=num1Value * 10 + list1.get(i);
		}
        
        for (int i = 0; i <= list2.size()-1; i++) {
        	num2Value=num2Value * 10 + list2.get(i);
		}
        System.out.println(num1Value+"---"+num2Value);
        int tatalNumber=num1Value+num2Value;
        int tmpValue=tatalNumber;
        ListNode head=null;
        while(tmpValue/10>0)
        {
        	ListNode myNode=new ListNode(tmpValue % 10);
        	if(head==null)
        	{
        		head=myNode;
        	}else{
        		myNode.next=head;
        		head=myNode;
        	}
        	tmpValue/=10;
        }
        ListNode lastNode=new ListNode(tmpValue % 10);
        if(head==null)
    	{
    		head=lastNode;
    	}else{
    		lastNode.next=head;
    		head=lastNode;
    	}
        
        return head;
    }

public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    boolean needIncrease=false;
    ListNode curr1=l1;
    ListNode curr2=l2;
    ListNode newHead=null;
    ListNode newTail=null;
    int increase=0;
    while(curr1!=null && curr2!=null)
    {
    	increase=needIncrease?1:0;
    	if(curr1.val+curr2.val+increase>9)
    	{
    		ListNode newNode=new ListNode((curr1.val+curr2.val+increase) % 10);
    		if(newHead==null){
    			newHead=newNode;
    			newTail=newNode;
    		}else{
    			newTail.next=newNode;
    			newTail=newNode;
    		}
    		needIncrease=true;
    	}else{
    		ListNode newNode=new ListNode(curr1.val+curr2.val+increase);
    		if(newHead==null){
    			newHead=newNode;
    			newTail=newNode;
    		}else{
    			newTail.next=newNode;
    			newTail=newNode;
    		}
    		needIncrease=false;
    	}
    	
    	curr1=curr1.next;
    	curr2=curr2.next;
    	
    }
    
    if(curr1==null)
    {
    	//move the remain node in list2
    	while(curr2!=null)
    	{
    		increase=needIncrease?1:0;
        	if(curr2.val+increase>9)
        	{
        		ListNode newNode=new ListNode((curr2.val+increase) % 10);
        		if(newHead==null){
        			newHead=newNode;
        			newTail=newNode;
        		}else{
        			newTail.next=newNode;
        			newTail=newNode;
        		}
        		needIncrease=true;
        	}else{
        		ListNode newNode=new ListNode(curr2.val+increase);
        		if(newHead==null){
        			newHead=newNode;
        			newTail=newNode;
        		}else{
        			newTail.next=newNode;
        			newTail=newNode;
        		}
        		needIncrease=false;
        	}
        	
        	
        	curr2=curr2.next;
    	}
    }else{
    	//move the remain node in list2
    	while(curr1!=null)
    	{
    		increase=needIncrease?1:0;
        	if(curr1.val+increase>9)
        	{
        		ListNode newNode=new ListNode((curr1.val+increase) % 10);
        		if(newHead==null){
        			newHead=newNode;
        			newTail=newNode;
        		}else{
        			newTail.next=newNode;
        			newTail=newNode;
        		}
        		needIncrease=true;
        	}else{
        		ListNode newNode=new ListNode(curr1.val+increase);
        		if(newHead==null){
        			newHead=newNode;
        			newTail=newNode;
        		}else{
        			newTail.next=newNode;
        			newTail=newNode;
        		}
        		needIncrease=false;
        	}
        	
        	
        	curr1=curr1.next;
    	}
    }
    if(needIncrease==true)
    {
    	ListNode newNode=new ListNode(1);
    	newNode.next=null;
		if(newHead==null){
			newHead=newNode;
			newTail=newNode;
		}else{
			newTail.next=newNode;
		}
    }
    
    
    return newHead;
}
}
