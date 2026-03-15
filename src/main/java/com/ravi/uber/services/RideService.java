package com.ravi.uber.services;

import com.ravi.uber.dto.RideRequestDto;
import com.ravi.uber.entities.Driver;
import com.ravi.uber.entities.Ride;
import com.ravi.uber.entities.RideRequest;
import com.ravi.uber.entities.Rider;
import com.ravi.uber.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);

    void matchWithDrivers(RideRequestDto rideRequestDto);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);
}

