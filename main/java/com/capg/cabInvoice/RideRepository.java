package com.capg.cabInvoice;

import java.util.Map;
import java.util.HashMap;

public class RideRepository {
	private Map<Integer, Ride[]> userID_rides = new HashMap<>();

	public void addEntry(int userId, Ride[] rides) {
		userID_rides.put(userId, rides);
	}

	public Ride[] getRides(int userId) {
		return userID_rides.get(userId);
	}
}