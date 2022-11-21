package Ejercicio5;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Ejercicio5 {
    public static void main(String[] args) {
        Saldo saldo = new Saldo(5);
        System.out.println("Saldo inical: " + saldo.get());
        System.out.println("============================");

        double cantidad = 5;
        int numHilos = 5;

        Thread[] lstHilos = new Thread[numHilos];

        for (int i = 0; i < numHilos; i++) {
            lstHilos[i] = new Thread(new Hilo(saldo, i, cantidad));
            lstHilos[i].start();
            cantidad += i;
        }

        for (int i = 0; i < numHilos; i++) {
            try {
                lstHilos[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("============================");
        System.out.println("Saldo final: " + saldo.get());
    }
}

class Hilo implements Runnable {

    Saldo saldo;
    int id;
    double cantidad;

    public Hilo(Saldo saldo, int id, double cantidad) {
        this.saldo = saldo;
        this.id = id;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        saldo.add(id, cantidad);
    }
}

class Saldo {
    double saldo;

    public Saldo(double saldo) {
        this.saldo = saldo;
    }

    public double get() {
        return this.saldo;
    }

    private static void randomSleep() {
        try {
            sleep(Math.abs(new Random().nextInt()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void set(double saldo) {
        this.saldo = saldo;
    }

    public synchronized void add(int id, double cantidad) {
        System.out.println("Operación del Hilo " + id);
        this.saldo += cantidad;
        System.out.println("------------------------");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Saldo: " + this.saldo);
    }
}
