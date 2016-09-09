package com.interview.simplifypath;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

click to show corner cases.
Corner Cases:

    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' 
    together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("///"));
	}
	public static  String simplifyPath(String path) {
		Stack<String> pathStack=new Stack<>();
		if(path.equalsIgnoreCase("/"))
		{
			return path;
		}
		String[] splitStr=path.split("/");
		if(splitStr.length==0)
		{
			return "/";
		}
		for (int i = 0; i < splitStr.length; i++) {
			if(i==0)
			{
				pathStack.push(splitStr[i]);
				continue;
			}else{
				if(splitStr[i].equalsIgnoreCase(".") || splitStr[i].equalsIgnoreCase(""))
				{
					continue;
				}else if(splitStr[i].equalsIgnoreCase(".."))
				{
					if(pathStack.size()>1)
					{
						pathStack.pop();
						continue;
					}
				}else{
					pathStack.push(splitStr[i]);
				}
			}
			
			//System.out.println(splitStr[i]);
		}
		String finalStr="";
		
		if(pathStack.size()==1)
		{
			return "/";
		}
		while(!pathStack.isEmpty())
		{
			if(finalStr.length()==0)
			{
				finalStr=finalStr+pathStack.pop();
			}else{
				finalStr=pathStack.pop()+"/"+finalStr;		
			}
			
		}
		
		return finalStr;
    }
}
