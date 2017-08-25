package com.nikita.kovalev;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The buyer pays for purchases at the cash desk
 */
public class Customer implements Runnable {

    private static final int TIME_ON_PRODUCT = 1000;

    private final List<Integer> productIds;
    private final int id;

    public Customer(final int id, final int size) {
        this.id = id;
        productIds = new ArrayList<>(size);
        initProducts(size);
    }

    private void initProducts(final int size) {
        final Random random = new Random();
        for (int i = 0; i < size; i++) {
            productIds.add(random.nextInt(1000));
        }
    }

    @Override
    public void run() {
        final Thread thread = Thread.currentThread();
        try {
            Thread.sleep(TIME_ON_PRODUCT * productIds.size());
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Cash Box: {\n\tid: " + thread.getId() + ",\n\t" + this.toString() + "}\n");
    }

    @Override
    public String toString() {
        return "Customer: {\n\t"
                + "id: " + id + ",\n\t\t"
                + "numberOfProducts: " + productIds.size() + ",\n\t\t"
                + "products: " + productIds + "\n\t"
                + "}\n";
    }
}
