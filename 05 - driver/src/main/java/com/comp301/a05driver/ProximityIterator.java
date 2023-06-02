package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ProximityIterator implements Iterator<Driver> {
  private final Iterator<Driver> driverPool;
  private final Position clientPosition;
  private final int proximityRange;
  private Driver nextDriver;

  public ProximityIterator(
      Iterable<Driver> driverPool, Position clientPosition, int proximityRange) {
    if (clientPosition == null || driverPool == null) {
      throw new IllegalArgumentException("position or driver pool can't be null");
    }
    this.driverPool = driverPool.iterator();
    this.clientPosition = clientPosition;
    this.proximityRange = proximityRange;
    this.nextDriver = null;
  }

  private void loadNextDriver() {
    while (driverPool.hasNext()) {
      Driver driver = driverPool.next();
      if (driver.getVehicle().getPosition().getManhattanDistanceTo(clientPosition)
          <= proximityRange) {
        nextDriver = driver;
        break;
      }
    }
  }

  @Override
  public boolean hasNext() {
    if (nextDriver == null) {
      loadNextDriver();
    }
    return nextDriver != null;
  }

  @Override
  public Driver next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    Driver driver = nextDriver;
    nextDriver = null;
    return driver;
  }
}
