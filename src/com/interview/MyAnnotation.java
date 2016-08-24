package com.interview;
import java.util.stream.Stream;

public class MyAnnotation {
	public void printOut(int n)
	{
		System.out.println("-------"+n);
	    if(n >= 10)
	        printOut(n/10);
	    System.out.print(n % 10);    
	}
	public static void main(String[] args) {
		new MyAnnotation().printOut(12345);
		Stream<String> fruitStream = Stream.of("apple", "banana", "pear", "kiwi", "orange");

		fruitStream.filter(s -> s.matches(".*pp.*"))
		           .map(String::toUpperCase)
		           .sorted()
		           .forEach(System.out::println);
	}

}
