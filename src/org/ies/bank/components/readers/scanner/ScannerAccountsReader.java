package org.ies.bank.components.readers.scanner;

import org.ies.bank.components.readers.AccountsReader;
import org.ies.bank.model.Accounts;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class ScannerAccountsReader implements AccountsReader {
    private final Scanner scanner;
    private final ScannerCustomerReader customerReader;

    public ScannerAccountsReader(Scanner scanner, ScannerCustomerReader customerReader) {
        this.scanner = scanner;
        this.customerReader = customerReader;
    }
    @Override
    public Accounts read() {
        System.out.println("Escribe los datos de la cuenta");
        System.out.println("IBAN");
        String iban = scanner.nextLine();
        System.out.println("Saldo");
        double saldo = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Cliente");
        Customer customer = customerReader.read();

        return new Accounts(
                iban,
                saldo,
                customer
        );

    }
}

