package org.ies.bank.components.readers.scanner;

import org.ies.bank.model.Accounts;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp3 {
    private final Scanner scanner;
    private final ScannerBankReader bankReader;

    public BankApp3(Scanner scanner, ScannerBankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();

        bank.printAccounts();

        Accounts account = bank.findAccount("ES0003");

        if (account != null) {
            account.withdraw(50);
        } else {
            System.out.println("La cuenta no existe");
        }

        bank.showCustomerAccounts("000X");
        Accounts account2 = bank.findAccount("ES004");

        if (account2 != null) {
            account2.deposit(300);
        }else {
            System.out.println("La cuenta no existe");
        }

        bank.showAccount("ES0001");


    }
}
