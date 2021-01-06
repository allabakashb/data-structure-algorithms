package com.hackerrank.visa3;

import java.util.Scanner;


/*
Write the implementation of the Student and Result Classes
*/

class Student {
	
	String name;
	int studentClass;
	float result;
	
	Student(String name, int studentClass) {
		
		this.name = name;
		this.studentClass = studentClass;
		
		System.out.println("Added student: " + name + 
				" to the roll of class: " + studentClass);
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public String publish() {
		
		if (this.result > 33.33) {
			
			return this.name + " has been promoted to class: " + 
			(this.studentClass + 1);
		} else {
			
			return this.name + " has been retained in class: " 
			+ this.studentClass;
		}
	}
}

class Result extends Student {

	int sub1;
	int sub2;
	int sub3;
	
	public Result(int sub1, int sub2, int sub3, String name, int stClass) {
		
		super(name, stClass);
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		
		System.out.println(name + " obtained " + sub1 + " marks in subject1");
		System.out.println(name + " obtained " + sub2 + " marks in subject2");
		System.out.println(name + " obtained " + sub3 + " marks in subject3");
	}

	public String calculateResult() {
		
		this.result = (this.sub1 + this.sub2 + this.sub3) * 100 / 300;
		
		return this.publish();
	}

	public String changeMarks(int newMarks, String sub) {
		
		System.out.println(this.getName() + " has ordered a recheck in " + sub);
		
		if (sub.equals("subject1")) {
			
			this.sub1 = newMarks;
		} else if (sub.equals("subject2")) {
			
			this.sub2 = newMarks;
		} else {
			
			this.sub3 = newMarks;
		}
			
		this.calculateResult();
		
		String msg = "";
		
		if (this.result > 33.33) {
			msg = "Following is the new result: " + this.getName() +
					" has been promoted to class: " + 
					(this.studentClass + 1);
		} else {
			
			msg = "Following is the new result: " + this.getName() +
					" has been retained in class: " + 
					(this.studentClass + 1);
		}
		return msg;
	}
	
}

public class Solution1{
 public static void main(String[] args){
  
  Scanner sc = new Scanner(System.in);
  String[] names = sc.nextLine().split(" ");
  int[][] marks = new int[names.length][3];

  for(int i = 0; i < names.length; i++){
   String[] temp = sc.nextLine().split(" ");
   marks[i][0] = Integer.parseInt(temp[0]);
   marks[i][1] = Integer.parseInt(temp[1]);
   marks[i][2] = Integer.parseInt(temp[2]);	
  }
  String[] cla = sc.nextLine().split(" ");

  Result r1 = new Result(marks[0][0], marks[0][1], marks[0][2],names[0], Integer.parseInt(cla[0]));
  Result r2 = new Result(marks[1][0], marks[1][1], marks[1][2],names[1], Integer.parseInt(cla[1]));
  Result r3 = new Result(marks[2][0], marks[2][1], marks[2][2],names[2], Integer.parseInt(cla[2]));
  Result r4 = new Result(marks[3][0],marks[3][1], marks[3][2], names[3],Integer.parseInt(cla[3]));
  Result r5 = new Result(marks[4][0], marks[4][1], marks[4][2], names[4], Integer.parseInt(cla[4]));
  String sub = sc.nextLine();
  int newMarks = Integer.parseInt(sc.nextLine());

  System.out.println(r1.calculateResult());
  System.out.println(r2.calculateResult());
  System.out.println(r3.calculateResult());
  System.out.println(r4.calculateResult());
  System.out.println(r5.calculateResult());
     
  System.out.println(r1.changeMarks(newMarks,sub));
  System.out.println(r3.changeMarks(newMarks,sub));
  System.out.println(r5.changeMarks(newMarks,sub));
 }	
}
