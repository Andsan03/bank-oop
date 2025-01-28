package org.ies.bank.components.readers.scanner;

import org.ies.bank.model.Accounts;
import org.ies.bank.model.Bank;

public class BankApp4 {
    private final ScannerBankReader bankReader;

    public BankApp4(ScannerBankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();

        Accounts account = bank.findAccount("ES0001");

        if (account != null) {
            account.showInfo();
            Accounts account2 = bank.findAccount("ES0002");
            bank.transfer(account.getIban(), account2.getIban(), account.getSaldo());
            bank.showInfoBank();
        }
    }
}
