package com.nikita.kovalev;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nikit on 25.07.2017.
 */
public class Philosopher implements Runnable {
    static final int maxWaitMs = 100;
    static AtomicInteger token = new AtomicInteger(0);
    static int instances = 0;
    static Random rand = new Random();
    AtomicBoolean end = new AtomicBoolean(false);
    int id;
    PhilosopherEnum philosopherEnum = PhilosopherEnum.Get;
    Fork left;
    Fork right;
    int timesEaten = 0;

    Philosopher() {
        id = instances++;
        left = MainActivity.forks.get(id);
        right = MainActivity.forks.get((id+1)%MainActivity.philosopherCount);
    }

    void sleep() { try { Thread.sleep(rand.nextInt(maxWaitMs)); }
    catch (InterruptedException ex) {} }

    void waitForFork(Fork fork) {
        do {
            if (fork.atomicInteger.get() == Fork.ON_TABLE) {
                fork.atomicInteger.set(id);
                return;
            } else {
                sleep();
            }
        } while (true);
    }

    public void run() {
        do {
            if (philosopherEnum == PhilosopherEnum.Pon) {
                philosopherEnum = PhilosopherEnum.Get;
            } else {
                if (token.get() == id) {
                    waitForFork(left);
                    waitForFork(right);
                    token.set((id+2)% MainActivity.philosopherCount);
                    philosopherEnum = PhilosopherEnum.Eat;
                    timesEaten++;
                    sleep();
                    left.atomicInteger.set(Fork.ON_TABLE);
                    right.atomicInteger.set(Fork.ON_TABLE);
                    philosopherEnum = PhilosopherEnum.Pon;
                    sleep();
                } else {
                    sleep();
                }
            }
        } while (!end.get());
    }
}
