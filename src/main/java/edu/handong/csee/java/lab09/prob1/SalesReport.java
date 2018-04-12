package edu.handong.csee.java.lab09.prob1;
import java.util.Scanner;
import java.util.Arrays; // I didn't use the array packages that other programmers made, actually..
/**
 * This class is about making sales report.
 * I used constructor on it.
 * @author HW
 *
 */
public class SalesReport {
	
	private int highestSales = 0;
	private int numOfSalesman = 0;
	private SalesReport[] team;
	
	private String name;
	private double salesNum = 0.0;

	public SalesReport(){ // a constructor
		this.name="0";
		this.salesNum = 0.0;
	}

	public void getData() {
		
		System.out.println("Enter number of sales associate:"); // getting associate number
		Scanner myScanner = new Scanner(System.in);
		numOfSalesman = myScanner.nextInt();

		
		for (int i = 0; i < numOfSalesman; i++) {
			
			System.out.println("Enter data for associate number "+(i+1));
			
			System.out.print("Enter name of sales associate: ");
			String name1 = myScanner.nextLine();
			team[i].name = name1;
			
			System.out.print("Enter associate's sales : $");
			double sales1 = myScanner.nextDouble();
			team[i].salesNum = sales1;
			
		}
	}
	
	public void CalculateAverage(SalesReport[] team) {

		double calSum = 0.0;
		numOfSalesman = getNumOfSalesman();
		
		for (int i=0; i<numOfSalesman;i++) {
			calSum += team[i].salesNum;
		}
		
		double average1 = calSum/numOfSalesman;
		System.out.print("Average sales is : "+calSum);
	}

	
	public static void main (String[] args) {
		SalesReport rpt = new SalesReport();
		
		rpt.getData();
		rpt.CalculateAverage();
		
	
	}

	public int getNumOfSalesman() {
		return numOfSalesman;
	}

	public void setNumOfSalesman(int numOfSalesman) {
		this.numOfSalesman = numOfSalesman;
	}


	
	
	
	
}
