package com.interview.graycode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * 89. Gray Code

    Total Accepted: 70137
    Total Submissions: 183930
    Difficulty: Medium

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, 
print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
//		mySolution.grayCode(3);
		mySolution.grayCode2(2);
	}
	
	/**
	 * Correct version
	 * @param n
	 * @return
	 */
	public List<Integer> grayCode(int n) {
	       /**
	         * First put all the number to a mapping with same number of 1 bit
	         */
			List<Integer> resultList=new ArrayList<>();
			if(n==0)
			{
				return new ArrayList<Integer>(Arrays.asList(0));
			}
			if(n==1)
			{
				return new ArrayList<Integer>(Arrays.asList(0,1));
			}
			resultList.add(0);
			resultList.add(1);
			
			
			for (int i = 2; i < Math.pow(2, n); i++) {
				String currStr=Integer.toBinaryString(i);
				StringBuilder sb=new StringBuilder();
				for (int j = 0; j < currStr.length(); j++) {
					if(j==0)
					{
						char curChar=((0+ (currStr.charAt(j)-'0')) % 2 == 0)?'0':'1';
						sb.append(curChar);
					}else{
						char curChar=(((currStr.charAt(j-1)-'0')+ (currStr.charAt(j)-'0')) % 2 == 0)?'0':'1';
						sb.append(curChar);
					}
				}
				
				if(resultList.contains(Integer.parseInt(sb.toString(), 2)))
				{
					sb.insert(0, '1');
				}
				resultList.add(Integer.parseInt(sb.toString(), 2));
			//	System.out.println(sb.toString());
				
			}
			
			
//			String currStr=Integer.toBinaryString(resultList.get(resultList.size()-1));
//			while(currStr.length()<=n)
//			{
//				StringBuilder sb=new StringBuilder();
//				for (int i = 0; i < currStr.length(); i++) {
//					if(i==0)
//					{
//						char curChar=((0+ (currStr.charAt(i)-'0')) % 2 == 0)?'0':'1';
//						sb.append(curChar);
//					}else{
//						char curChar=((currStr.charAt(i-1)+ (currStr.charAt(i)-'0')) % 2 == 0)?'0':'1';
//						sb.append(curChar);
//					}
//				}
//				System.out.println(sb.toString());
//				if(resultList.contains(Integer.parseInt(sb.toString(), 2)))
//				{
//					sb.insert(0, '1');
//				}
//				resultList.add(Integer.parseInt(sb.toString(), 2));
//				currStr=Integer.toBinaryString(resultList.get(resultList.size()-1));
//			}
			return resultList.subList(0, (int)Math.pow(2, n));
	    }
	//Not correct version
	 public List<Integer> grayCode1(int n) {
		 Map<Integer,List<Integer>> numberMapping=new HashMap<>();
		 //Generate a mapping, key is the number of 1 bits, value is a list of number
		 for (int i = 0; i <= (Math.pow(2,n)-1); i++) {
			 int oneBits=Integer.bitCount(i);
			if(numberMapping.containsKey(oneBits))
			{
				numberMapping.get(oneBits).add(i);
			}else{
				List<Integer> myList=new ArrayList<>();
				myList.add(i);
				numberMapping.put(oneBits, myList);
			}
		}
		 int index=0;
		 List<Integer> resultList=new LinkedList();
		 int currentBitCound=0;
		 while(index<Math.pow(2,n))
		 {
			 if(resultList.isEmpty())
			 {
				 resultList.add(0);
				 mapRemove(numberMapping,0);
				 
			 }else{
				 //Main logic, start from 0
				 int prevNumber=resultList.get(resultList.size()-1);
				 int prevBitsCount=Integer.bitCount(prevNumber);
				 
				 if(prevBitsCount-1>=0)
				 {
					 //Decide whether add one bit or minus one bit
					 //Try minus bit first
					 if(numberMapping.containsKey(prevBitsCount-1))
					 {
						 //using minus
						 currentBitCound=prevBitsCount-1;
					 }else{
						 //adding a bit
						 currentBitCound=prevBitsCount+1;
					 }
				 }else{
					 //Adding one bit
					 currentBitCound=prevBitsCount+1;
				 }
				 //Insert the next number to the result list
				 int nextNumber=numberMapping.get(currentBitCound).get(0);
				 
				 resultList.add(nextNumber);
				 numberMapping.get(currentBitCound).remove(0);
				 if(numberMapping.get(currentBitCound).size()==0)
				 {
					 mapRemove(numberMapping,currentBitCound);
				 }
				 
			 }
			 index++;
		 }
		 System.out.println(resultList.toString());
		 return resultList;
	        
	    }
	 
	 public void mapRemove(Map<Integer,List<Integer>> targetMap,int number)
	 {
		 Iterator<Map.Entry<Integer, List<Integer>>> myIter=targetMap.entrySet().iterator();
		 while(myIter.hasNext())
		 {
			 if(myIter.next().getKey()==number)
			 {
				 myIter.remove();
				 return;
			 }
		 }
	 }
	 //Not correct version
	 public List<Integer> grayCode2(int n){
//		 System.out.println(Integer.parseInt("0110", 2));
//		 System.out.println(Integer.toBinaryString(23));
//		 StringBuilder sb=new StringBuilder("110");
//		 sb.insert(0, '1');
//		 System.out.println(sb.toString());
		 if(n==0)
         {
             return new ArrayList<Integer>();
         }
         if(n==1)
         {
             List<Integer> myList=new ArrayList<>();
             myList.add(0);
             myList.add(1);
             return myList;
         }
		 resultList.clear();
		 resultList.add(0);
		 resultList.add(1);
		 int currentNumber=resultList.get(1);
		 int index=2;
		 while(index<Math.pow(2, n))
		 {
			 while(currentNumber !=-1)
			 {
				 currentNumber=removeOneBit(Integer.toBinaryString(currentNumber)); 
				 if(currentNumber!=-1)
				 {
					 resultList.add(currentNumber);
					 index++;
				 }else{
					 break;
				 }
			 }
			 
			 currentNumber=resultList.get((resultList.size()-1));
			 while(Integer.toBinaryString(currentNumber).length()<=n)
			 {
				 
				 currentNumber=addingOneBit(Integer.toBinaryString(currentNumber));
				 resultList.add(currentNumber);
				 index++;
				 if(allOneBits(Integer.toBinaryString(currentNumber)))
					{
						 break;
					}
				 
			 }
			 
		 }
		 
		 return resultList.subList(0, (int)Math.pow(2, n)-1);
	 }
	 static List<Integer> resultList=new ArrayList<>();
	 public int addingOneBit(String input)
	 {
		 StringBuilder tmp=new StringBuilder(input);
		 
		 for (int i = input.length()-1; i >= 0; i--) {
			if(input.charAt(i)=='0')
			{
				tmp.setCharAt(i, '1');
				if(resultList.contains(Integer.parseInt(tmp.toString(),2)))
				{
					tmp.setCharAt(i, '0');
					continue;
				}else{
					return Integer.parseInt(tmp.toString(),2);
				}
			}
		}
		//All the 0 position is occupied, need to insert to the left margin
		 tmp.insert(0, '1');
		 return Integer.parseInt(tmp.toString(),2);
		 
		 
	 }
	 
	 //Remove one bit from right sight
	 public int removeOneBit(String input)
	 {
		 StringBuilder tmp=new StringBuilder(input);
		 
		 for (int i = input.length()-1; i >= 0; i--) {
			if(input.charAt(i)=='1')
			{
				tmp.setCharAt(i, '0');
				if(resultList.contains(Integer.parseInt(tmp.toString(),2)))
				{
					tmp.setCharAt(i, '1');
					continue;
				}else{
					
					return Integer.parseInt(tmp.toString(),2);
				}
			}
		}
		 return -1;
	 }
	 
	 public boolean allOneBits(String input)
	 {
		 for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i)!='1')
			{
				return false;
			}
		}
		 return true;
	 }
}
