package com.capg.cabInvoice;

public class CabInvoiceGenerator {

	private final int COST_PER_KM = 10;
	private final int COST_PER_MIN = 1;
	private int MIN_FARE = 5;

	public double calculateFare(double distance, float time) {
		return Math.max((distance * COST_PER_KM + time * COST_PER_MIN), MIN_FARE);
	}

	public double multipleRidesFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.distance, ride.time);
		}
		return totalFare;
	}
}
