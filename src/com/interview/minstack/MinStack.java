package com.interview.minstack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 * @author mcgu
 *
 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class MinStack {
	Stack<Integer> myStack=new Stack<>();
	Stack<Integer> minStack=new Stack<>();
	//int currMin=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  MinStack obj = new MinStack();
		  obj.push(25);
		  obj.pop();
		  int param_3 = obj.top();
		  int param_4 = obj.getMin();
	}
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
    	if (minStack.isEmpty())
    	{
    		myStack.push(x);
    		minStack.push(x);
    	}else{
    		if(x<minStack.peek())
            {
    			myStack.push(x);
    			minStack.push(x);
            }else{
            	myStack.push(x);
            	minStack.push(minStack.peek());
            }
    	}
        
    }
    
    public void pop() {
        if(myStack.isEmpty())
        {
        	return;
        }else{
        	myStack.pop();
        	minStack.pop();
        }
    }
    
    public int top() {
        return myStack.peek();
    }
    
    public int getMin() {
    	return minStack.peek();
    }
}
