package com.capg.cabInvoice;

public class CabInvoiceGenerator {

	private final int NORMAL_COST_PER_KM = 10;
	private final int NORMAL_COST_PER_MIN = 1;
	private int NORMAL_MIN_FARE = 5;
	private final int PREMIUM_COST_PER_KM = 15;
	private final int PREMIUM_COST_PER_MIN = 2;
	private int PREMIUM_MIN_FARE = 20;

	public double calculateFare(double distance, float time, String type) {
		if(type.equals("normal"))
			return Math.max((distance * NORMAL_COST_PER_KM + time * NORMAL_COST_PER_MIN), NORMAL_MIN_FARE);
		else if(type.equals("premium"))
			return Math.max((distance * PREMIUM_COST_PER_KM + time * PREMIUM_COST_PER_MIN), PREMIUM_MIN_FARE);
		else
			return 0;
	}

	public InvoiceSummary multipleRidesFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.distance, ride.time, ride.rideType);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}
}
