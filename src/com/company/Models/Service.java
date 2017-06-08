package com.company.Models;

import java.util.Random;

/**
 * Created by pavel on 08.06.17.
 */
public class Service {
    private static final Random random = new Random();
    public static long generateId() {
        return System.currentTimeMillis() + random.nextInt(100);
    }
}
