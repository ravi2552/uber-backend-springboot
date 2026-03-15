package com.ravi.uber.strategies.impl;

import com.ravi.uber.entities.Driver;
import com.ravi.uber.entities.Payment;
import com.ravi.uber.entities.enums.PaymentStatus;
import com.ravi.uber.entities.enums.TransactionMethod;
import com.ravi.uber.repositories.PaymentRepository;
import com.ravi.uber.services.WalletService;
import com.ravi.uber.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser(), platformCommission,null,payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
