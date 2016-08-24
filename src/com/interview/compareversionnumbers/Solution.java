package com.interview.compareversionnumbers;
/**
 * Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", 
it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compareVersion("1.1","1.1.1"));
	}
	public static int compareVersion(String version1, String version2) {
        String[] ver1=version1.split("\\.");
        String[] ver2=version2.split("\\.");
        int maxlength=ver1.length> ver2.length ? ver1.length:ver2.length;
        for (int i = 0; i < maxlength; i++) {
			if(i>ver1.length-1)
			{
				//second version is larger
				for(int j=i;j<ver2.length;j++)
				{
					if(Integer.parseInt(ver2[j])>0)
					{
						return -1;
					}
				}
				//all left number in version2 is 0, so the two versions are same
				return 0;
			}else if(i>ver2.length-1)
			{
				for(int j=i;j<ver1.length;j++)
				{
					if(Integer.parseInt(ver1[j])>0)
					{
						return 1;
					}
				}
				//first version is larger
				return 0;
			}else{
				if(Integer.parseInt(ver1[i])==Integer.parseInt(ver2[i]))
				{
					continue;
				}else if(Integer.parseInt(ver1[i])>Integer.parseInt(ver2[i]))
				{
					return 1;
				}else{
					return -1;
				}
			}
			
		}
        return 0;
    }

}
