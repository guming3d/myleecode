package com.interview.mergesortedarray;
/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to 
hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1=new int[]{4,0};
		int[] test2=new int[]{3};
		merge(test1,1,test2,1);
	}
	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
	     //merge the two sorted integer arrays from right to left
		 
		 int index1=m-1;
		 int index2=n-1;
		 int largeIndex=0;
		 int next2Fill=m+n-1;
		 boolean firstDone=false;
		 boolean secondDone=false;
		 
		 if((nums2.length==0)||n==0)
		 {
			 return;
		 }
		 if(m==0)
		 {
			 for (int i = 0; i < n; i++) {
				 nums1[i]=nums2[i];
				
			}
			 return;
		 }
		 
		 while(!((secondDone==true)||(firstDone==true)))
		 {
			 if(nums2[index2]>=nums1[index1])
			 {
				 nums1[next2Fill]=nums2[index2];
				 if(index2==0)
				 {
					 secondDone=true;
				 }else{
					 index2--;
				 }
			
				 next2Fill--;
			 }else{
				 nums1[next2Fill]=nums1[index1];
				 if(index1==0)
				 {
					 firstDone=true;
				 }else{
					 index1--;
				 }
				 next2Fill--;
			 }
		 }
		 if(firstDone ==true)
		 {
			 while(index2>=0)
			 {
				 nums1[next2Fill]=nums2[index2];
				 index2--;
				 next2Fill--;
			 }
		 }
		 
		 
		 System.out.println("aaaa");
//		 if(nums1[0]>=nums2[0])
//		 {
//			 nums1[next2Fill]=nums1[0];
//			 nums1[0]=nums2[0];
//		 }else{
//			 nums1[next2Fill]=nums2[0];
//
//		 }
		 
//		 while(index1>0)
//		 {
//			 nums[next2Fill]=nums[index1];
//			 index1--;
//			 next2Fill--
//		 }
		 
	    }
}
