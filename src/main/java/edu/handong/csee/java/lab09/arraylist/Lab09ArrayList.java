package edu.handong.csee.java.lab09.arraylist;

import java.util.ArrayList;
import java.util.HashMap; // delete later.
import java.util.Scanner;

public class Lab09ArrayList {

	private double highestSales;
	private double averageSales;
	private int numOfSalesman;
	
	private ArrayList<String> associatesArray = new ArrayList<String>(); // name
	private ArrayList<Double> salesArray = new ArrayList<Double>(); // sales
	
	Scanner myKeyboard = new Scanner(System.in);
	
	public void getData() {
		
		System.out.print("Enter number of sales associate:"); // getting associate number
		numOfSalesman = myKeyboard.nextInt();

		//SalesReport mySales = new SalesReport();

		for (int i = 0; i < numOfSalesman; i++) {
		
			System.out.println("Enter data for associate number " +(i+1) + ".");

			System.out.print("Name ?");
			String name = myKeyboard.nextLine(); // String name
			associatesArray.add(name); // adding String name to ArrayList
			
			System.out.print("Sales?");
			double sales = myKeyboard.nextDouble(); // Double sales
			salesArray.add(sales);
			
			//System.out.println("Do you want to add on more salesman?"); We don't need below part.
			//myKeyboard.nextLine();
			
			//if(myKeyboard.nextLine().equalsIgnoreCase("no")) {
			//	break;
			}
			
		}
	
	public void computeAverage() {
		double sum = 0.0;
		double average = 0.0;
		//새로 만들 ArrayList용 포문.
		for(int i = 0 ;i < numOfSalesman;i++) {
			
			sum += salesArray.get(i); // check if right
		}
		average = sum/numOfSalesman; // doulbe형을 int형으로 나눈거라 오차 있나 확인.
		
		setAverageSales(average);
		
	
	}
	
	public void computeHighestSales() {
		
		int listSize = salesArray.size();
		double highest = salesArray.get(0); // 초기값 젤 큰건 array의 첫번째 인자
		double temp = 0.0;
		
		for(int i = 0; i<listSize-1; i++) {
				if(highest < salesArray.get(i+1)) {
					highest = salesArray.get(i+1);
				}
			}
		setHighestSales(highest);
		//System.out.print("Highest sales is $" + highest +".");
	}
	
	public void printResults() {
		
		System.out.print("Highest sales is $" + getHighestSales() +".");
		System.out.print("Average sales is : "+ getAverageSales() + ".");
		
	}

	
	//getters and setters.
	public double getHighestSales() {
		return highestSales;
	}

	public void setHighestSales(double highestSales) {
		this.highestSales = highestSales;
	}

	public double getAverageSales() {
		return averageSales;
	}

	public void setAverageSales(double averageSales) {
		this.averageSales = averageSales;
	}
	
	
}

