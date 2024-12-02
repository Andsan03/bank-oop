package org.ies.bank.components;

import org.ies.bank.model.Accounts;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class AccountsReader {
    private final Scanner scanner;
    private final CustomerReader customerReader;

    public AccountsReader(Scanner scanner, CustomerReader customerReader) {
        this.scanner = scanner;
        this.customerReader = customerReader;
    }
    public Accounts read() {
        System.out.println("Escribe los datos de la cuenta");
        System.out.println("IBAN");
        String iban = scanner.nextLine();
        System.out.println("Saldo");
        double saldo = scanner.nextDouble();
        System.out.println("Cliente");
        Customer customer = customerReader.read();

        return new Accounts(
                iban,
                saldo,
                customer
        );

    }
}

