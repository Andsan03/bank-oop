package org.ies.bank.components.readers.scanner;

import org.ies.bank.components.readers.BankReader;
import org.ies.bank.model.Accounts;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class ScannerBankReader implements BankReader {
    private final Scanner scanner;
    private final ScannerAccountsReader accountsReader;

    public ScannerBankReader(Scanner scanner, ScannerAccountsReader accountsReader) {
        this.scanner = scanner;
        this.accountsReader = accountsReader;
    }
    @Override
    public Bank read() {
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
