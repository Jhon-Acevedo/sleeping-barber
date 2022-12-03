package test;

import models.Barber;
import models.BarberShop;
import models.Customer;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Test {

    public static final int NUM_SEATS = 5;
    public static final int NUM_CUST = 12;

    public static void main(String[] args) {

        BarberShop shop = new BarberShop(NUM_SEATS);
        new Barber("Barber1", shop).start();
        int counter = 0;
        while (true) {
            try {
                sleep(TimeUnit.SECONDS.toMillis((long) (Math.random() * 5 + 1)));
                new Customer(counter, "Customer " + counter, shop).start();
                counter++;
            } catch (
                    InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
