package com.comp301.a05driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SnakeOrderAcrossPoolsIterator implements Iterator<Driver> {
    private final List<Iterator<Driver>> driverPools;
    private final int size;
    private Driver nextDriver;
    private Integer currentIndex = -1;
    private int direction = 0;
    private boolean repeat = false;
    private boolean start = true;

    public SnakeOrderAcrossPoolsIterator(List<Iterable<Driver>> driverPools) {
        if (driverPools == null) {
            throw new IllegalArgumentException("invalid arguments");
        }
        this.driverPools = new ArrayList<>();
        for (Iterable<Driver> driverPool : driverPools) {
            this.driverPools.add(driverPool.iterator());
        }
        this.size = this.driverPools.size();
    }

    private void iterateIndex() {
        if (currentIndex == 0 && currentIndex == this.size - 1) {
            return;
        }
        if (this.currentIndex == 0) {
            this.direction = 0;
        } else if (this.currentIndex == this.size - 1) {
            this.direction = 1;
        }
        if (this.repeat) {
            this.repeat = false;
            return;
        }
        currentIndex += this.direction == 0 ? 1 : -1;
        if ((this.currentIndex == 0 || this.currentIndex == this.size - 1) && !this.start) {
            this.repeat = true;
        }
        this.start = false;
    }

    private void loadNext() {
        loadNext(0);
    }

    private void loadNext(int i) {
        if (i == this.size * 4) {
            this.nextDriver = null;
            return;
        }
        iterateIndex();
        if (this.currentIndex == null || this.currentIndex < 0 || this.currentIndex >= this.size) {
            return;
        }
        Driver driver = getNext();
        if (driver == null) {
            loadNext(i + 1);
        } else {
            this.nextDriver = driver;
        }
    }

    private Driver getNext() {
        try {
            return driverPools.get(this.currentIndex).next();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        if (this.size == 0) {
            return false;
        }
        if (nextDriver != null) {
            return true;
        } else {
            loadNext();
            return nextDriver != null;
        }
    }

    @Override
    public Driver next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Driver next = nextDriver;
        nextDriver = null;
        return next;
    }
}