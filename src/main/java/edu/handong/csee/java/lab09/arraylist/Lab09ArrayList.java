package edu.handong.csee.java.lab09.arraylist;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class is a sales report using ArrayList.
 * ArrayList is like a 'malloc' in C.
 * @author HWK
 *
 */
public class Lab09ArrayList { // start of a class

	private double highestSales; // initializing private variables.
	private double averageSales; // These are only used in this class!
	private int numOfSalesman;


	public Lab09ArrayList() { // a constructor for the private variables.
		this.highestSales = 0.0; // actually you don't have to instantiate this, since you can just accesss the variables by getters and setters.
		this.averageSales = 0.0;
		this.numOfSalesman = 0;
	}

	private ArrayList<String> associatesArray = new ArrayList<String>(); // name
	private ArrayList<Double> salesArray = new ArrayList<Double>(); // sales
	// If I use array, like previous Lab09, the format is 'double[] salesArray = new double[numOfSalesman];

	//	Lab09ArrayList a1 = new Lab09ArrayList();


	public static void main(String[] args) { // main method. Tried to make as clean as possible.

		Lab09ArrayList myList = new Lab09ArrayList(); // instantiate the class.

		myList.getData(); // these are the methods that I implemented below.
		myList.computeAverage();
		myList.computeHighestSales();
		myList.printResults();

	} // end of main

	Scanner myKeyboard = new Scanner(System.in); // instantiate scanner.

	public void getData() { // first "practical" method, getData.

		String not; // this is used for handling error, since without this below String name cannot get 'nextLine()' for the enter that user put at the end of entering the value.

		System.out.print("Enter number of sales associate : "); // getting associate number
		numOfSalesman = myKeyboard.nextInt(); // giving a value from user
		not = myKeyboard.nextLine(); // this is just to "consume" the useless "Enter" at the end of what user put just before this.

		for (int i = 0; i < numOfSalesman; i++) { // for loop, iterate as many as numOfSalesman.

			System.out.println("Enter data for associate number " +(i+1) + "."); // associate #1, #2, #3...

			System.out.print("Name ? : ");
			String name = myKeyboard.nextLine(); // String name gets the name from user.
			associatesArray.add(i,name); // adding String name to ArrayList 'associatesArray'


			System.out.print("Sales? : ");
			double sales = myKeyboard.nextDouble(); // Double sales
			salesArray.add(i,sales); // adding double sales to ArrayList 'salesArray'
			not = myKeyboard.nextLine(); // this is to consume the needless "Enter" that I explained up above.
		}

	}

	public void computeAverage() { // method computing average.

		double sum = 0.0; //instantiating variables that I will use.
		double average = 0.0;


		for(int i = 0 ;i < numOfSalesman;i++) { // for loop, iterating numOfSalesman times.

			sum += salesArray.get(i); // getting stuff from ArrayList 'salesArray', which is obviously double type.
		}
		average = sum/numOfSalesman; // It seems fine to divide double by integer type.

		setAverageSales(average); // setting average value. (since it is private, you have to use getters and setters.)


	}

	public void computeHighestSales() { // method for computing highest sales.

		int listSize = salesArray.size(); // same as numOfSalesman
		double highest = salesArray.get(0); // At the beginning, the highest number is the value at the first index.
		double temp = 0.0;

		for(int i = 1; i<listSize; i++) { // iterate 'listSize' times, which means I want to completely go through the arraylist.

			temp = salesArray.get(i); // temp is literally temporary place for saving stuff.
			if(highest < temp) { // if temp is bigger than 'current' highest value,
				highest = temp;// exchange them.
			}
		}
		setHighestSales(highest); // setting value
		//System.out.print("Highest sales is $" + highest +".");
	}

	public void printResults() { // this is just printing out all the computed values above.


		System.out.println("Highest sales is $" + getHighestSales());
		System.out.println("Average sales is $"+ getAverageSales());
		System.out.println("The following has the highest sales : ");
		for(int i = 0; i<numOfSalesman; i++) { // iterate numOfSalesman times to print out all the information of salesmen.
			double difference = 0.0;

			System.out.println("Name : " + associatesArray.get(i)); // getting names and sales from two arraylist,
			System.out.println("Sales : " + salesArray.get(i)); // respectively String type and double type.

			if (salesArray.get(i) < getAverageSales()) { // I had to make it clear whether he/she sold more/less than the average.
				difference = (getAverageSales() - salesArray.get(i));
				System.out.println("$"+ difference +" below the average."); // for the case he/she sold less than the average.
			}
			else if (salesArray.get(i) == getAverageSales()) { // if he/she sold just as much as average, this thing comes out.
				System.out.println("Earned just as much as average.");
			}

			else {
				difference = (salesArray.get(i)-getAverageSales());
				System.out.println("$"+ difference +" above the average.");// for the case he/she sold more than the average.
			}

		}

	}


	//getters and setters. Easily made by just clicking 'source - generate getters and setters'. Thanks JC!
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

