package com.interview.validparentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("["));
	}
public static boolean isValid(String s) {
	Stack<Character> bracketStack=new Stack<>();
	for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '{':
				bracketStack.push('{');
				break;
			case '(':
				bracketStack.push('(');
				break;
			case '[':
				bracketStack.push('[');
				break;
			case '}':
				if(bracketStack.isEmpty())
				{
					return false;
				}
				if(bracketStack.peek()!='{')
				{
					return false;
				}else{
					bracketStack.pop();
				}
				break;
			case ')':
				if(bracketStack.isEmpty())
				{
					return false;
				}
				if(bracketStack.peek()!='(')
				{
					return false;
				}else{
					bracketStack.pop();
				}
				break;
			case ']':
				if(bracketStack.isEmpty())
				{
					return false;
				}
				if(bracketStack.peek()!='[')
				{
					return false;
				}else{
					bracketStack.pop();
				}
				break;
			default:
				break;
			}
	}
	if(bracketStack.isEmpty())
	{
		return true;
	}else{
		return false;
	}
        
	
    }
}
