package com.carparkingsystem.display;

public class DisplayOutput {

	public void printWithNewLine(String messageToPrint) {
		System.out.println(messageToPrint);
		
	}

	public void parkingLotFull() {
		System.out.println("Parking lot is full!!");
		
	}

	public void notFound() {
		System.out.println("No parked car matches the query");
	}


}
