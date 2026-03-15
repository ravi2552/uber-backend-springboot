package com.ravi.uber.strategies;


import com.ravi.uber.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.ravi.uber.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.ravi.uber.strategies.impl.RideFareDefaultFareCalculationStrategy;
import com.ravi.uber.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {
    private final RideFareDefaultFareCalculationStrategy rideFareDefaultFareCalculationStrategy;
    private final RideFareSurgePricingFareCalculationStrategy rideFareSurgePricingFareCalculationStrategy;
    private final DriverMatchingNearestDriverStrategy driverMatchingNearestDriverStrategy;
    private final DriverMatchingHighestRatedDriverStrategy driverMatchingHighestRatedDriverStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
        if (riderRating>=4.8){
            return driverMatchingHighestRatedDriverStrategy;
        }else {
            return driverMatchingNearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy(){
        LocalTime surgeStartTime = LocalTime.of(10,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);
        if (isSurgeTime){
            return rideFareSurgePricingFareCalculationStrategy;
        }else{
            return rideFareDefaultFareCalculationStrategy;
        }
    }

}
