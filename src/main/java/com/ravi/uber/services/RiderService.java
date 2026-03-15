package com.ravi.uber.services;

import com.ravi.uber.dto.DriverDto;
import com.ravi.uber.dto.RideDto;
import com.ravi.uber.dto.RideRequestDto;
import com.ravi.uber.dto.RiderDto;
import com.ravi.uber.entities.Rider;
import com.ravi.uber.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RiderService {
    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId, Integer rating);

    RiderDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
