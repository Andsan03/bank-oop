package org.ies.bank.components.readers.scanner;

import org.ies.bank.model.Accounts;

public class BankAppWithErrors {
    private final ScannerBankReader bankReader;

    public BankAppWithErrors(ScannerBankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {

        var bank = bankReader.read();


        Accounts account = bank.findAccount("ES0001");
        if(account != null) {
            account.showInfo();
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }
}
