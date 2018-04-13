package edu.handong.csee.java.lab09.arraylist;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class is a sales report using ArrayList.
 * ArrayList is like a 'malloc' in C.
 * @author HWK
 *
 */
public class Lab09ArrayList {

	private double highestSales;
	private double averageSales;
	private int numOfSalesman;

	/*public Lab09ArrayList() {
		this.highestSales = 0.0;
		this.averageSales = 0.0;
		this.numOfSalesman = 0;
	}

	Lab09ArrayList m = new Lab09ArrayList(); */

	private ArrayList<String> associatesArray = new ArrayList<String>(); // name
	private ArrayList<Double> salesArray = new ArrayList<Double>(); // sales
	// If I used array, like previous Lab09, the format is 'double[] salesArray = new double[numOfSalesman];

	public static void main(String[] args) {

		Lab09ArrayList myList = new Lab09ArrayList();

		myList.getData();
		myList.computeAverage();
		myList.computeHighestSales();
		myList.printResults();

	}

	Scanner myKeyboard = new Scanner(System.in);

	public void getData() {

		System.out.print("Enter number of sales associate : "); // getting associate number
		numOfSalesman = myKeyboard.nextInt();

		//SalesReport mySales = new SalesReport();

		for (int i = 0; i < numOfSalesman; i++) {

			System.out.println("Enter data for associate number " +(i+1) + ".");

			System.out.print("Name ? : ");
			String name = myKeyboard.nextLine(); // String name
			associatesArray.add(i,name); // adding String name to ArrayList ( 본문에서는 add(name)과 같이 index는 적지 않았음 )


			System.out.print("Sales? : ");
			double sales = myKeyboard.nextDouble(); // Double sales
			salesArray.add(i,sales);

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

		int listSize = salesArray.size(); // same as numOfSalesman

		double highest = salesArray.get(0); // 초기값 젤 큰건 array의 첫번째 인자
		//System.out.println(highest + "-------------");

		double temp = 0.0;

		for(int i = 1; i<listSize; i++) {

			temp = salesArray.get(i);
			if(highest < temp) {
				highest = temp;
			}
		}
		setHighestSales(highest);
		//System.out.print("Highest sales is $" + highest +".");
	}

	public void printResults() {


		System.out.println("Highest sales is $" + getHighestSales());
		System.out.println("Average sales is : "+ getAverageSales());
		System.out.println("The following has the highest sales : ");
		for(int i = 0; i<numOfSalesman; i++) {
			double difference = 0.0;

			System.out.println("Name : " + associatesArray.get(i));
			System.out.println("Sales : " + salesArray.get(i));
			if (salesArray.get(i) < getAverageSales()) {
				difference = (getAverageSales() - salesArray.get(i));
				System.out.println("$"+ difference +" below the average.");
			}
			else if (salesArray.get(i) == getAverageSales()) {
				System.out.println("Earned just as much as average.");
			}

			else {
				difference = (salesArray.get(i)-getAverageSales());
				System.out.println("$"+ difference +" above the average.");
			}

		}

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

