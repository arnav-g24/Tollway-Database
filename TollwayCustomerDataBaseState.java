//00062663

import java.util.*;
import java.io.*;

public class TollwayCustomerDataBaseState {
	static Scanner console;
	static ArrayList<Customer> customerList;

	public static void main(String args[]) {	//calls all helper methods to load the customer list
		console = getReader("Names");
		customerList = new ArrayList<>();

		while (console.hasNext()) {
			customerList.add(readCustomer(console));
		}

		for (int i = 0; i < customerList.size(); i++) {
			Customer temp = customerList.get(i);
			System.out.println(temp.getInfo());
			System.out.println();
		}

//		System.out.println("Total number of records: " + customerList.size());
	}

	private static Customer readCustomer(Scanner in) {		//uses scanner to create a new Customer object, return the object to load into list
		String line = in.nextLine();

		String[] splitLine = line.split(",");

		Name nm = new Name(splitLine[0], splitLine[1]);
		CarInfo info = new CarInfo(splitLine[2], splitLine[3], splitLine[4]);
		Payment pay = new Payment(splitLine[5], splitLine[6]);

		Customer customer = new Customer(nm, info, pay);
		return customer;
	}

	private static Scanner getReader(String name) {			//creates a new scanner for the given text file name
		try {
			console = new Scanner(new File(name + ".txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
		return console;
	}

}

////// Customer Attributes: Name, CarInfo, Payment
class Customer {
	Name name;
	CarInfo info;
	Payment payment;

	public Customer(Name name, CarInfo info, Payment payment) {			//constructor
		this.name = name;
		this.info = info;
		this.payment = payment;
	}

	public String getInfo() {			// return the full customer information
		return name.getInfo() + "\n" + info.getInfo() + "\n" + payment.getInfo();
	}

}

////// Name Attributes: first name, last name
class Name {
	String first, last;

	public Name(String last, String first) {    //constructor
		this.first = first;
		this.last = last;
	}

	public String getInfo() {   // return the name information
		return "Name: " + first + " "+ last;
	}

}

////// CarInfo Attributes: make, model, license_plates
class CarInfo {
	String make, model, license_plates;

	public CarInfo(String make, String model, String license_plates) {  //constructor
		this.make = make;
		this.model = model;
		this.license_plates = license_plates;
	}

	public String getInfo() {   // return the car information
		return "Car Information: " + this.make + this.model + this.license_plates;
	}

}

////// Payment Attributes: deposit, credit_card 
class Payment {
	String deposit;
	String credit_card;

	public Payment(String deposit, String credit_card) {   //constructor
		this.deposit = "$" + deposit;
		this.credit_card = credit_card;
	}

	public String getInfo() {   // return the payment information
		return "Payment: " + this.deposit + this.credit_card;
	}

}
