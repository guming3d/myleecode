package com.interview.differentwaystoaddparentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. Different Ways to Add Parentheses

    Total Accepted: 29251
    Total Submissions: 75686
    Difficulty: Medium

Given a string of numbers and operators, return all possible results 
from computing all the different possible ways to group numbers and operators. 
The valid operators are +, - and *.

Example 1

Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2

Output: [0, 2]

Example 2

Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10

Output: [-34, -14, -10, -10, 10]
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		//mySolution.diffWaysToCompute("22+1");
		//mySolution.getNumberFromString("023");	
		CalTreeNode root=new CalTreeNode(new Item('+'));
		root.left=new CalTreeNode(new Item(15));
		root.right=new CalTreeNode(new Item('-'));
		root.right.left=new CalTreeNode(new Item(3));
		root.right.right=new CalTreeNode(new Item('*'));
		root.right.right.left=new CalTreeNode(new Item(2));
		root.right.right.right=new CalTreeNode(new Item(5));
		System.out.println(mySolution.calculateTreeTotal(root));
		
	}

	
	public List<Integer> diffWaysToCompute(String input) {
		List<Item> numberList=new ArrayList<>();
		//List<Character> operationList=new ArrayList<>();
		StringBuilder number=new StringBuilder("");
		for(int i=0;i<input.length();i++)
		{
			char item=input.charAt(i);
			if(item>='0' && item <= '9')
			{
				number.append(item);
				if(i==input.length()-1)
				{
					numberList.add(new Item(getNumberFromString(number.toString())));
					number=new StringBuilder("");
				}
			}else if(item=='+' ||
					 item=='-' ||
					 item=='*'){
				numberList.add(new Item(getNumberFromString(number.toString())));
				number=new StringBuilder("");
				numberList.add(new Item(item));
			}
		}
        
		return null;
    }
	public int getNumberFromString(String input)
	{
		if(input.length()==0)
		{
			return 0;
		}
		int total=0;
		for (int i = 0; i < input.length(); i++) {
			total=(input.charAt(i)-'0') * ((int)Math.pow(10, input.length()-i-1)) + total;
		}
		System.out.println(total);
		return total;
	}
	/**
	 * Calculate the total value of the calculate tree
	 * @param root
	 * @return
	 */
	public int calculateTreeTotal(CalTreeNode root)
	{
		if(root.left==null && root.right==null)
		{
			return root.val.getNumber();
		}
		int leftTotal=0;
		if(root.left!=null)
		{
			leftTotal=calculateTreeTotal(root.left);
		}
		
		int rightTotal=0;
		if(root.right!=null)
		{
			rightTotal=calculateTreeTotal(root.right);
		}
		
		char operation=root.val.getOperation();
		if(operation=='+')
		{
			return leftTotal + rightTotal;
		}else if(operation=='-')
		{
			return leftTotal - rightTotal;
		}else if(operation=='*')
		{
			return leftTotal * rightTotal;
		}else{
			return 0;
		}
		
	}
	
	public List<CalTreeNode> generateCalTree(List<Item> operation)
	{
		
		return null;
	}
	
	
}
