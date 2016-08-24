package com.interview.regex;

public class RegexMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String regexStr=".";
		String matchedString="qweeee";
		System.out.println(String.format("Regex String %s is %s match %s",regexStr,evaluate(matchedString, regexStr)?"":"not", matchedString));
	}
	
	  public static boolean evaluate(String source, String pattern) {
		    if (source == null || pattern == null) {
		      throw new IllegalArgumentException("You can't pass a null strings as input");
		    }
		    if (pattern.length() == 0) return source.length() == 0;
		    // Length 1 is special case
		    if (pattern.length() == 1 || pattern.charAt(1) != '*') {
		      if (source.length() < 1 || (pattern.charAt(0) != '.' && source.charAt(0) != pattern.charAt(
		          0))) {
		        return false;
		      }
		      return evaluate(source.substring(1), pattern.substring(1));
		    } else {
		      int len = source.length();

		      int i = -1;
		      while (i < len && (i < 0 || pattern.charAt(0) == '.' || pattern.charAt(0) == source.charAt(
		          i))) {
		        if (evaluate(source.substring(i + 1), pattern.substring(2))) return true;
		        i++;
		      }
		      return false;
		    }
		  }
}
