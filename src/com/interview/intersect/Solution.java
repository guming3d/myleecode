package com.interview.intersect;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
 * @author mcgu
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1={1,2,2,1,3,6,4};
		int[] nums2={2,2,3,1};
		intersection2(nums1,nums2);
		
	}
public static int[] intersection(int[] nums1, int[] nums2) {
	HashSet nums1Hash=new HashSet<Integer>();
	HashSet nums2Hash=new HashSet<Integer>();
	for(int i: nums1)
	{
		nums1Hash.add(i);
	}
	for(int i: nums2)
	{
		nums2Hash.add(i);
	}    
	ArrayList<Integer> nums1List=new ArrayList<Integer>();
	ArrayList<Integer> nums2List=new ArrayList<Integer>();
	nums1Hash.forEach(item ->nums1List.add((Integer)item));
	nums2Hash.forEach(item ->nums2List.add((Integer)item));
	nums1List.sort(new Comparator<Integer>() {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			// TODO Auto-generated method stub
			return arg0-arg1;
			//return 0;
		}
		
	});
	nums1List.forEach(item ->{System.out.println(item);});
	
	System.out.println("----------------------------");
	nums2List.sort(new Comparator<Integer>() {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			// TODO Auto-generated method stub
			return arg0-arg1;
			//return 0;
		}
		
	});
	nums2List.forEach(item ->{System.out.println(item);});
	
	ArrayList<Integer> numsIntersect=new ArrayList<Integer>();
	int i=0;
	int j=0;
	while(i<nums1List.size() && j<nums2List.size())
	{
		if(nums1List.get(i)==nums2List.get(j)){
			numsIntersect.add(nums1List.get(i));
			i++;
			j++;
			
		}
		else if(nums1List.get(i) > nums2List.get(j)){
			j++;
		}else if(nums1List.get(i) < nums2List.get(j)){
			i++;
		}	
	}
	System.out.println("==================================");
	numsIntersect.forEach(item ->{System.out.println(item);});
	
	int [] result=new int[numsIntersect.size()];
	for(int index=0;index<numsIntersect.size();index++){
		result[index]=numsIntersect.get(index);
	}
	
	
	return result;
    }

public static int[] intersection2(int[] nums1, int[] nums2) {
	if(nums1==null || nums2==null)
	{
		return null;
	}
	Set<Integer> set1=new HashSet<>();
	Set<Integer> set2=new HashSet<>();
	for (int i = 0; i < nums1.length; i++) {
		set1.add(nums1[i]);
	}
	for (int i = 0; i < nums2.length; i++) {
		set2.add(nums2[i]);
	}
	
	List<Integer> resultList=new ArrayList<>();
	if(set1.size()>set2.size())
	{
		set2.forEach(item->{
			if(set1.contains(item))
			{
				resultList.add(item);
			}
		});
	}else{
		set1.forEach(item->{
			if(set2.contains(item))
			{
				resultList.add(item);
			}
		});
	}
	int[] resultArray=new int[resultList.size()];
	
	for (int i = 0; i < resultList.size(); i++) {

		resultArray[i]=resultList.get(i);
		System.out.println(resultArray[i]);
	}
	
//	resultArray=resultList.toArray(resultArray)
	return resultArray;
	
}
}
