package org.ies.bank.components;

import org.ies.bank.model.Accounts;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankReader {
    private final Scanner scanner;
    private final AccountsReader accountsReader;

    public BankReader(Scanner scanner, AccountsReader accountsReader) {
        this.scanner = scanner;
        this.accountsReader = accountsReader;
    }
    public Bank read () {
        System.out.println("Escribe los datos del banco");
        System.out.println("Nombre");
        String name = scanner.nextLine();
        System.out.println("¿Cuantas cuentas tiene el banco?");
        int size = scanner.nextInt();
        scanner.nextLine();

        Accounts[] accounts = new Accounts[size];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = accountsReader.read();
        }
        return new Bank(
                name,
                accounts
        );
    }
}
