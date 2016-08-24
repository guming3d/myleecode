package com.interview.firstbadversion;
/**
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, 
 * all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. 
Implement a function to find the first bad version. 
You should minimize the number of calls to the API.
 * @author mcgu
 *
 */
public class Solution extends VersionControl{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution myTest=new Solution();
		myTest.firstBadVersion2(2126753390);
	}
	 public int firstBadVersion(int n) {
	        int indexStart=1;
	        int indexEnd=n;
	        if(n==1)
	        {
	        	return n;
	        }
	        if(n==2)
	        {
	        	if(isBadVersion(indexStart)==true)
	        	{
	        		return indexStart;
	        	}else{
	        		return indexEnd;
	        	}
	        }
	        while(indexEnd-indexStart>1)
	        {
	        	if(isBadVersion(indexStart)==false && isBadVersion(indexEnd)==true)
	        	{
	        		long middleTmp;
	        		int middle;
	        		middle=indexStart + (indexEnd-indexStart)/2;
//	        		try{
//	        			middleTmp=Math.addExact(indexStart, indexEnd);
//	        			middle=(int)middleTmp/2;
//	        		}catch(Exception e){
//	        			//System.out.println("overflow, need to change to long");
//	        			middleTmp=Math.addExact((long)indexStart, (long)indexEnd);
//	        			middle=(int)(middleTmp/2);
//	        		}
	        		
	        		//long middle=(long)indexStart + indexEnd;
	        		if(isBadVersion(middle)==false)
	        		{
	        			indexStart=middle;
	        			continue;
	        		}else if(isBadVersion(middle)==true){
	        			indexEnd=middle;
	        			continue;
	        		}
	        	}else{
	        		if(isBadVersion(indexStart)==true)
	        		{
	        			System.out.println(indexStart);
	        			return indexStart;
	        		}
	        	}
	        	
	        }
	        
	        System.out.println(indexEnd);
	        return indexEnd;
	    }
	 public int firstBadVersion2(int n) {
	        int indexStart=1;
	        int indexEnd=n;
	        if(n==1)
	        {
	        	return n;
	        }
	        if(n==2)
	        {
	        	if(isBadVersion(indexStart)==true)
	        	{
	        		return indexStart;
	        	}else{
	        		return indexEnd;
	        	}
	        }
	        while(indexEnd-indexStart>1)
	        {
	        	if(isBadVersion(indexStart)==false && isBadVersion(indexEnd)==true)
	        	{
	        		long middleTmp;
	        		int middle;
	        		try{
	        			middleTmp=Math.addExact(indexStart, indexEnd);
	        			middle=(int)middleTmp/2;
	        		}catch(Exception e){
	        			//System.out.println("overflow, need to change to long");
	        			middleTmp=Math.addExact((long)indexStart, (long)indexEnd);
	        			middle=(int)(middleTmp/2);
	        		}
	        		
	        		//long middle=(long)indexStart + indexEnd;
	        		if(isBadVersion(middle)==false)
	        		{
	        			indexStart=middle;
	        			continue;
	        		}else if(isBadVersion(middle)==true){
	        			indexEnd=middle;
	        			continue;
	        		}
	        	}else{
	        		if(isBadVersion(indexStart)==true)
	        		{
	        			System.out.println(indexStart);
	        			return indexStart;
	        		}
	        	}
	        	
	        }
	        
	        System.out.println(indexEnd);
	        return indexEnd;
	    }
}
