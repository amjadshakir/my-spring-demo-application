package com.techreturners.myspringdemo.model;

import java.util.concurrent.atomic.AtomicLong;

public class Coffee {
    private long id;
    private String name;

    public Coffee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
