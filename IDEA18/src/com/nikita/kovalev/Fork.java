package com.nikita.kovalev;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nikit on 25.07.2017.
 */
public class Fork {
    public static final int ON_TABLE = -1;
    static int instances = 0;
    public int id;
    public AtomicInteger atomicInteger = new AtomicInteger(ON_TABLE);

    Fork() {
        id = instances++;
    }
}
