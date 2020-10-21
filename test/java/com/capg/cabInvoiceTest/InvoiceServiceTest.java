package com.capg.cabInvoiceTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.capg.cabInvoice.CabInvoiceGenerator;
import com.capg.cabInvoice.Ride;

public class InvoiceServiceTest {

	@Test
	public void givenDistanceAndTimeShouldReturnFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		double distance = 10.0;
		int time = 20;
		double fareMoreThan5 = cabInvoiceGenerator.calculateFare(distance, time);
		assertTrue(fareMoreThan5 == 120);
	}

	@Test
	public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		double distance = 0.1;
		int time = 2;
		double fareLessThan5 = cabInvoiceGenerator.calculateFare(distance, time);
		assertTrue(fareLessThan5 == 5);
	}

	@Test
	public void givenMultipleRidesShouldReturnTotalFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		Ride[] rides = { new Ride(10.0, 20), new Ride(0.1, 2) };
		double totalFare = cabInvoiceGenerator.multipleRidesFare(rides);
		assertTrue(totalFare == 125);
	}
}
