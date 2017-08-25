package com.nikita.kovalev;

import java.util.ArrayList;

/**
 * Created by nikit on 24.07.2017.
 */
public class MainActivity {
    static final int philosopherCount = 5;
    static final int runSeconds = 15;
    static ArrayList<Fork> forks = new ArrayList();
    static ArrayList<Philosopher> philosophers = new ArrayList();

    public static void main(final String... args) {
        for (int i = 0 ; i < philosopherCount ; i++) forks.add(new Fork());
        for (int i = 0 ; i < philosopherCount ; i++)
            philosophers.add(new Philosopher());
        for (Philosopher p : philosophers) new Thread(p).start();
        long endTime = System.currentTimeMillis() + (runSeconds * 100);

        do {
            StringBuilder sb = new StringBuilder("|");

            for (Philosopher p : philosophers) {
                sb.append(p.philosopherEnum.toString());
                sb.append("|");
            }

            sb.append(" |");

            for (Fork f : forks) {
                int holder = f.atomicInteger.get();
                sb.append(holder==-1?"   ":String.format("Philosopher%02d",holder));
                sb.append("|");
            }

            System.out.println(sb.toString());
            try {Thread.sleep(100);} catch (Exception ex) {}
        } while (System.currentTimeMillis() < endTime);

        for (Philosopher p : philosophers) p.end.set(true);
        for (Philosopher p : philosophers)
            System.out.printf("Philosopher%02d: ate %,d times, %,d/sec\n",
                    p.id, p.timesEaten, p.timesEaten/runSeconds);
    }
}
