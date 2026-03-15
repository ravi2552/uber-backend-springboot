package com.ravi.uber.services;


import com.ravi.uber.entities.Payment;
import com.ravi.uber.entities.Ride;
import com.ravi.uber.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus paymentStatus);

}
