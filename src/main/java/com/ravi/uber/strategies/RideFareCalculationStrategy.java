package com.ravi.uber.strategies;


import com.ravi.uber.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10.0;

    double calculateFare(RideRequest rideRequest);
}
