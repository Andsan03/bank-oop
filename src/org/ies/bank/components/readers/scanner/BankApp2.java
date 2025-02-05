package org.ies.bank.components.readers.scanner;

import org.ies.bank.model.Accounts;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp2 {
    private final Scanner scanner;
    private final ScannerBankReader bankReader;

    public BankApp2(Scanner scanner, ScannerBankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();

        Accounts account = bank.findAccount("ES0001");

        if (account != null) {
            account.deposit(500);
        }else {
            System.out.println("La cuenta no existe");
        }

        Accounts account2 = bank.findAccount("ES0002");

        if (account2 != null) {
            account2.withdraw(30);
        }else {
            System.out.println("La cuenta no existe");
        }

        account.showInfo();
        account2.showInfo();

        bank.transfer(account.getIban(), account2.getIban(), 500);
    }
}
