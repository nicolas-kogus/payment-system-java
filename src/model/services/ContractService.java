package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContractService {

    OnlinePaymentService onlinePaymentService = new PaypalService();

    public void processContract(Contract contract, Integer months) {

        Double paymentTax = 0.00;

        for (int i = 1; i <= months; i++) {

            paymentTax = contract.getTotalValue() / months;

            paymentTax += onlinePaymentService.interest(paymentTax, months) * i;
            paymentTax += onlinePaymentService.paymentFee(paymentTax);

            contract.addInstallment(new Installment(contract.getDate().plusMonths(i), paymentTax));

        }
    }
}
