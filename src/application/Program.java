package application;

import model.entities.Contract;
import model.services.ContractService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);

            System.out.println("Entre os dados do contrato:");
            System.out.print("Numero: ");
            int number = input.nextInt();
            System.out.print("Data (dd/MM/yyyy): ");
            LocalDate date = LocalDate.parse(input.next(), fmt);
            System.out.print("Valor do contrato: ");
            double totalValue = input.nextDouble();
            System.out.print("Entre com o numero de parcelas: ");
            int months = input.nextInt();
            System.out.println("Parcelas:");

            Contract contract = new Contract(number, date, totalValue);
            ContractService service = new ContractService();
            service.processContract(contract, months);

            for (int i = 1; i <= contract.getInstallments().size(); i++) {
                System.out.println(contract.getInstallments().get(i - 1));
            }

        input.close();
    }
}
