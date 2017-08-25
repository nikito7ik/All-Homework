package com.nikita.kovalev;

import java.util.Random;

/**
 * Main class creating cash desks
 */
public class MainActivity {

    public static void main(final String... args) throws Exception {
        Shop shop = new Shop(10);

        for (int i = 0; i < 20; i++) {
            shop.sendCustomer(new Customer(i, new Random().nextInt(25)));
        }

        Thread.sleep(10000);

        shop.close();
    }
}
