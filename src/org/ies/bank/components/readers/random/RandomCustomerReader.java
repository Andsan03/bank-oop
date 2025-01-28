package org.ies.bank.components.readers.random;

import org.ies.bank.components.readers.CustomerReader;
import org.ies.bank.model.Customer;

import java.util.Random;

public class RandomCustomerReader implements CustomerReader {
    private final Random random;

    public RandomCustomerReader(Random random) {
        this.random = random;
    }

    private  final static String[] NAMES = {
            "Pepa","George","Bob","Calamardo","Pattricio","Pocoyo"
    };

    private  final static String[] SURNAME = {
            "Pepa","George","Bob","Calamardo","Pattricio","Pocoyo"
    };

    @Override
    public Customer read() {
        String nif = random.nextLong(1000000000) + "X";
        String name = NAMES[random.nextInt(NAMES.length)];
        String surname = SURNAME[random.nextInt(SURNAME.length)];
        return new Customer(
                nif,
                name,
                surname
        );
    }
}
