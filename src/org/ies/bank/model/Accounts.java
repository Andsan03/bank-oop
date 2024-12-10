package org.ies.bank.model;

import java.util.Objects;

public class Accounts {
    private String iban;
    private double saldo;
    private Customer customer;

    public Accounts(String iban, double saldo, Customer customer) {
        this.iban = iban;
        this.saldo = saldo;
        this.customer = customer;
    }
    public void withdraw (double money) {
        saldo -= money;
    }

    public void showInfo () {
        System.out.println(". IBAN: " + getIban() + ". Saldo: " + getSaldo() + ". Nif cliente: " + getCustomer().getNif());
    }
    public void deposit(double money) {
        saldo += money;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return Double.compare(saldo, accounts.saldo) == 0 && Objects.equals(iban, accounts.iban) && Objects.equals(customer, accounts.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, saldo, customer);
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "iban='" + iban + '\'' +
                ", saldo=" + saldo +
                ", customer=" + customer +
                '}';
    }
}
