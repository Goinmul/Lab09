package edu.handong.csee.java.lab09.prob1;
import java.util.Scanner;
import java.util.Arrays; // I didn't use the array packages that other programmers made, actually..
/**
 * This class is about making sales report.
 * I used constructor on it.
 * @author HW
 */
public class SalesReport {

	private double highestSales = 0;
	private int numOfSalesman = 0;
	private SalesReport[] team;
	private double averageSales=0;
	private String name;
	private double salesNum = 0.0;

	public SalesReport(){ // a constructor
		this.name="0";
		this.salesNum = 0.0;
	}

	public void getData() {

		System.out.print("Enter number of sales associate:"); // getting associate number
		Scanner myScanner = new Scanner(System.in);
		numOfSalesman = myScanner.nextInt();

		double temp1 = 0.0;
		//SalesReport mySales = new SalesReport();

		for (int i = 0; i < numOfSalesman; i++) {

			System.out.print("Enter data for associate number "+(i+1));

			System.out.print("Enter name of sales associate: ");
			String name1 = myScanner.nextLine();
			team[i].setName(name1);

			System.out.print("Enter associate's sales : $");
			double sales1 = myScanner.nextDouble();
			team[i].setSalesNum(sales1);

			if(sales1 > temp1) {

				setHighestSales(sales1);
				temp1 = sales1;

			}

		}
	}

	public void CalculateAverage() {

		double calSum = 0.0;
		numOfSalesman = getNumOfSalesman();

		for (int i=0; i<numOfSalesman;i++) {
			calSum += team[i].salesNum;
		}

		double average1 = calSum/numOfSalesman;
		System.out.print("Average sales is : "+ calSum);

		setAverageSales(average1);
		//return average1;
	}

	public void HighestSales() {
		System.out.print("Average sales per associate is $" + averageSales); // I want to get access to the method above's variable average1,...
		System.out.print("The highest sales figure is $"+ highestSales +".");

		System.out.print("The following had the highest sales");

		for (int i = 0; i<numOfSalesman;i++) {
			System.out.print("Name : "+ team[i].getName());
			System.out.print("Sales : $" + team[i].getSalesNum());
			if (team[i].getSalesNum()<getHighestSales())
				System.out.print("$"+(getAverageSales()-team[i].getSalesNum())+" below the average.");

			else {
				System.out.print("$"+(team[i].getSalesNum()-getAverageSales())+" above the avergae.");
			}
		}
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalesNum() {
		return salesNum;
	}

	public void setSalesNum(double salesNum) {
		this.salesNum = salesNum;
	}

	public int getNumOfSalesman() {
		return numOfSalesman;
	}

	public void setNumOfSalesman(int numOfSalesman) {
		this.numOfSalesman = numOfSalesman;
	}

	public double getAverageSales() {
		return averageSales;
	}

	public void setAverageSales(double averageSales) {
		this.averageSales = averageSales;
	}

	public double getHighestSales() {
		return highestSales;
	}

	public void setHighestSales(double highestSales) {
		this.highestSales = highestSales;
	}



	public static void main (String[] args) {
		SalesReport rpt = new SalesReport();

		rpt.getData();
		rpt.CalculateAverage();
		rpt.HighestSales();

	}
}
