package model.services;

public class PaypalService implements OnlinePaymentService{
    public Double paymentFee(Double amount) {
        return 0.00;
    }

    public Double interest(Double amount, Integer months) {
        return 0.00;
    }
}
