package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Bank {
    private String name;
    private Accounts[] accounts;

    public Bank(String name, Accounts[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public void printAccounts(Scanner scanner) {
        for (Accounts accounts : accounts) {
            System.out.println("IBAN: " + accounts.getIban() + "saldo: " + accounts.getSaldo() + "NIF: " + accounts.getCustomer().getNif());
        }
    }

    public void showAccount(String iban) {
        for (var account : accounts) {
            if (account.getIban().equals(iban)) {
                showAccounts();
            }
        }
    }
    public void deposit(String iban, double money) {
        for (var account : accounts) {
            if (account.getIban().equals(iban)) {
                account.deposit(money);
            }
        }
    }

    public void showCustomerAccounts(String nif) {
        for (var account: accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                showAccounts();
            }
        }
    }

    public void showAccounts() {
        for (var account : accounts) {
            account.showInfo();
        }
    }
    public Accounts findAccount (String iban) {
        for (var account:accounts) {
            if (account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
    }
    public int clientAccounts(String nif) {
        int number = 0;
        for (var account: accounts) {
            if (account.getCustomer().getNif().equals(nif))
                number ++;
        }
        return number;
    }
    public Customer returnInfo(String iban) {
        for (var account: accounts) {
            if (account.getIban().equals(iban)){
                return account.getCustomer();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Accounts[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
