package com.ravi.uber.services.impl;

import com.ravi.uber.entities.RideRequest;
import com.ravi.uber.exceptions.ResourceNotFoundException;
import com.ravi.uber.repositories.RideRequestRepository;
import com.ravi.uber.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {

        return rideRequestRepository.findById(rideRequestId).orElseThrow(()->
                new ResourceNotFoundException("RideRequest not found by id: "+rideRequestId)
        );
    }
    @Override
    public void update(RideRequest rideRequest) {
        rideRequestRepository.findById(rideRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not found with id: "+rideRequest.getId()));
        rideRequestRepository.save(rideRequest);
    }
}
