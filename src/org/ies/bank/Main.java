package org.ies.bank;

import org.ies.bank.components.AccountsReader;
import org.ies.bank.components.BankApp;
import org.ies.bank.components.BankReader;
import org.ies.bank.components.CustomerReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in):
        CustomerReader customerReader = new CustomerReader(scanner);
        AccountsReader accountsReader = new AccountsReader(scanner, customerReader);
        BankReader bankReader = new BankReader(scanner,accountsReader);
        BankApp bankApp = new BankApp(scanner, bankReader);
    }
}