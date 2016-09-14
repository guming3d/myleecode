package com.interview.zigzagconversion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *  (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("abcdefg",3));
	}
	 public static String convert(String s, int numRows) {
	     if(s.length()==0 || s.length() ==1)
	     {
	    	 return s;
	     }
		 if(numRows==1)
		 {
			 return s;
		 }
		 if(numRows==2)
		 {
			 StringBuilder sub1=new StringBuilder();
			 for (int i = 0; i < s.length(); i++) {
				if(i % 2==0)
				{
					sub1.append(s.charAt(i));
				}
			}
			 StringBuilder sub2=new StringBuilder();
			 for (int i = 0; i < s.length(); i++) {
					if(i % 2==1)
					{
						sub2.append(s.charAt(i));
					}
				}
			 sub1.append(sub2.toString());
			 return sub1.toString();
		 }
		 
		 int totalMax=numRows*2 -2;
		 //first generate a ArrayList to work as a seperation
		 Map<Integer,List<Integer>> intervalMap=new HashMap<>();
		 for(int i = 0; i < numRows; i++) {
			 List<Integer> intervalList=new ArrayList<>();
			 if(i==0 || i==numRows-1)
			 {
				 
				 intervalList.add(totalMax);
				 intervalMap.put(i, intervalList);
			 }else{
				 intervalList.add(totalMax-i*2);
				 intervalList.add(i*2);
				 intervalMap.put(i, intervalList);
			 }
		 }
		 StringBuilder sb=new StringBuilder();
		 for (int i = 0; i < numRows; i++) {
			 int firstIndex=i;
			 int interval=0;
			 while(firstIndex<s.length())
			 {
				 if(firstIndex % totalMax <= numRows-1)
				 {
					 interval=intervalMap.get(i).get(0);
				 }else{
					 interval=intervalMap.get(i).get(1);
				 }
				 sb.append(s.charAt(firstIndex));
				 firstIndex+=interval;
			 }
			
		}
		 
		 return sb.toString();
		 
		 
		 
	    }
}
