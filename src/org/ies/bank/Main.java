package org.ies.bank;

import org.ies.bank.components.readers.scanner.ScannerAccountsReader;
import org.ies.bank.components.readers.scanner.BankApp;
import org.ies.bank.components.readers.scanner.ScannerBankReader;
import org.ies.bank.components.readers.scanner.ScannerCustomerReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScannerCustomerReader customerReader = new ScannerCustomerReader(scanner);
        ScannerAccountsReader accountsReader = new ScannerAccountsReader(scanner, customerReader);
        ScannerBankReader bankReader = new ScannerBankReader(scanner,accountsReader);
        BankApp bankApp = new BankApp(scanner, bankReader);

        bankApp.run();
    }
}