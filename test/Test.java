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
        new Barber("Barber1", 4, shop).start();

//        obtener la hora del sistema
        long startTime = System.currentTimeMillis();

        try {
            for (int i = 0; i < NUM_CUST; i++)
                new Customer(i, "Customer " + i, (int) (Math.random() * 10 + 1), shop).start();
            sleep(TimeUnit.SECONDS.toMillis(30));
        } catch (
                InterruptedException e) {
            throw new RuntimeException(e);
        }

//        obtener la hora del sistema
        long endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución: " + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime) + " segundos");
    }
}
