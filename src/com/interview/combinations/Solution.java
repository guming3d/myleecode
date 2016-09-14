package com.interview.combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 77. Combinations

    Total Accepted: 89597
    Total Submissions: 245032
    Difficulty: Medium

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		List<List<Integer>> resultList=mySolution.combine2(4, 3);
		System.out.println("end");
		
	}
	//TIME EXCEEDED!!!!
	//Stack<List<Integer>> roundStack=new Stack<>();
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> resultList=new ArrayList<>();
		if(k==0)
		{
			return resultList;
		}
		if(k==1)
        {
        	for (int i = 1; i <= n; i++) {
				List<Integer> tmpList=new ArrayList<>();
				tmpList.add(i);
				resultList.add(tmpList);
			}
        }else{
        	List<List<Integer>> tmpList=combine(n,k-1);
        	for (int i = 0; i < tmpList.size(); i++) {
				List<Integer> curList=tmpList.get(i);
				int largestNum=curList.get(curList.size()-1);
				if(largestNum==n)
				{
					continue;
				}
				for (int j = largestNum+1; j <= n; j++) {
					List<Integer> newList=new ArrayList<>();
					newList.addAll(curList);
					newList.add(j);
					resultList.add(newList);
				}
			}
        }
		return resultList;
    }
	
	public static List<List<Integer>> combine2(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		combine(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
	}

	public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
		if (k == 0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
		for (int i = start; i <= n; i++) {
			comb.add(i);
			combine(combs, comb, i + 1, n, k - 1);
			comb.remove(comb.size() - 1);
		}
	}
}
