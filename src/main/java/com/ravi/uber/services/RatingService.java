package com.ravi.uber.services;


import com.ravi.uber.dto.DriverDto;
import com.ravi.uber.dto.RiderDto;
import com.ravi.uber.entities.Ride;

public interface RatingService {
    DriverDto rateDriver(Ride ride, Integer rating);
    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);
}
