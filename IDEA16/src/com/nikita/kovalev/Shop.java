package com.nikita.kovalev;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Work of cash desks
 */
public class Shop {

    private ExecutorService cashBox;

    public Shop(final int cashBoxCount) {
        cashBox = Executors.newFixedThreadPool(cashBoxCount);
    }

    public void sendCustomer(final Customer customer) {
        cashBox.submit(customer);
    }

    public void close() {
        cashBox.shutdown();
    }
}
