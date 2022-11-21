package Ejercicio4;

import static java.lang.Thread.sleep;

public class Ejercicio4 {
    public static void main(String[] args) {
        long ini = System.currentTimeMillis();
        long tmax;
        if (args.length == 1) {
            // En caso de que quieras probar la segunda parte del ejercicio en la que le pasas a args un tiempo determinado
            // debes escribir esto en el terminal donde x es el tiempo que quieras que dure el programa
            // java .\Ejercicio4.java x
            tmax = Long.parseLong(args[0]);
        } else {
            tmax = 16;
        }

        long fin;
        Hilo hilo = new Hilo();
        hilo.start();

        while (true) {
            System.out.println("Esperando...");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            fin = System.currentTimeMillis();
            if (((fin - ini) / 1000) >= tmax) {
                break;
            }
        }
        if (hilo.isAlive()) {
            hilo.tiempo = 0;
        }
        try {
            hilo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        fin = System.currentTimeMillis();
        System.out.println("Fin de programa. Tiempo de ejecución " + (fin - ini) / 1000 + " segundos");
    }
}

class Hilo extends Thread {
    String[] mensajes = {"Programas", "Procesos", "Servicios", "Hilos"};
    long tiempo = 4000;

    public Hilo() {
    }

    @Override
    public void run() {
        for (String s : mensajes) {
            System.out.println(Thread.currentThread().getName() + ": " + s);
            try {
                sleep(tiempo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

