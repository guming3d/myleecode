package com.interview.pascaltriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author mcgu
 *
 */
public class Solution {
	List<List<Integer>> finalList=new ArrayList<List<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(getNumber(3,3));
		Solution mySolution=new Solution();
		mySolution.generate(3);
	}
	 public   List<List<Integer>> generate(int numRows) {
		 	finalList.clear();
	        for (int i = 0; i < numRows; i++) {
	        	List<Integer> rowList=new ArrayList<>();
				for (int j = 0; j <= i; j++) {
					rowList.add(getNumber2(i,j));
				}
				finalList.add(rowList);
			}
	        return finalList;
	    }
	 
	 public static int  getNumber(int level,int index)
	 {
		 if(level==0 && index==0)
		 {
			 return 1;
		 }
		 
		 if(index==0)
		 {
			 return 1;
		 }else if(index==level)
		 {
			 return 1;
		 }
		 else{
			 return getNumber(level-1,index-1)+getNumber(level-1,index);
		 }
	 }
	 
	 public  int  getNumber2(int level,int index)
	 {
		 if(level==0 && index==0)
		 {
			 return 1;
		 }
		 
		 if(index==0)
		 {
			 return 1;
		 }else if(index==level)
		 {
			 return 1;
		 }
		 else{
			 return finalList.get(level-1).get(index-1)+finalList.get(level-1).get(index);
			 //return getNumber(level-1,index-1)+getNumber(level-1,index);
		 }
	 }
}
