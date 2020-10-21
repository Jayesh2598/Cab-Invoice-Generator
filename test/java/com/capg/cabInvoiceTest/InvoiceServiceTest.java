package com.capg.cabInvoiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.capg.cabInvoice.CabInvoiceGenerator;
import com.capg.cabInvoice.InvoiceSummary;
import com.capg.cabInvoice.Ride;

public class InvoiceServiceTest {
	
	CabInvoiceGenerator cabInvoiceGenerator = null;
	
	@Before
	public void setup() throws Exception {
		cabInvoiceGenerator = new CabInvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTimeShouldReturnFare() {
		double distance = 10.0;
		int time = 20;
		double fareMoreThan5 = cabInvoiceGenerator.calculateFare(distance, time);
		assertTrue(fareMoreThan5 == 120);
	}

	@Test
	public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 2;
		double fareLessThan5 = cabInvoiceGenerator.calculateFare(distance, time);
		assertTrue(fareLessThan5 == 5);
	}

	@Test
	public void givenMultipleRidesShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(10.0, 20), new Ride(0.1, 2) };
		InvoiceSummary invoiceSummary = cabInvoiceGenerator.multipleRidesFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 125);
		assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
}
