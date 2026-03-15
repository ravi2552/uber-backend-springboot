package com.ravi.uber.strategies;


import com.ravi.uber.entities.Driver;
import com.ravi.uber.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findMatchingDrivers(RideRequest rideRequest);
}
