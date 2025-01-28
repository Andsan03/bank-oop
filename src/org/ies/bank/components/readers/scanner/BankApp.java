package org.ies.bank.components.readers.scanner;

import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp {
    private final Scanner scanner;
    private final ScannerBankReader bankReader;


    public BankApp(Scanner scanner, ScannerBankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }
    public void run () {
        Bank bank = bankReader.read();

        int option;

        do {
            option = chooseOption();

            if (option == 1) {
                bank.printAccounts();
            } else if (option == 2) {
                System.out.println("Introduce el IBAN");
                String iban = scanner.nextLine();
                bank.showAccount(iban);
            } else if (option == 3) {
                System.out.println("Introduce el NIF");
                String nif = scanner.nextLine();
                bank.showCustomerAccounts(nif);
            } else if (option == 4) {
                System.out.println("Introduce el IBAN");
                String iban = scanner.nextLine();
                System.out.println("¿Cuanto dinero quiere introducir?");
                double money = scanner.nextDouble();
                scanner.nextLine();
                bank.deposit(iban, money);

            }


        }while (option != 6);


    }
    private int chooseOption() {
        int option;
        System.out.println("Elige una opcion");
        System.out.println("1.Mostrar las cuentas");
        System.out.println("Mostrar datos de la cuenta");
        System.out.println("3.MNostrar cuentas de cliente");
        System.out.println("4.Ingresar");
        System.out.println("5.Sacar");
        System.out.println("6.Salir");
        option = scanner.nextInt();
        scanner.nextLine();

        return option;
    }
}
