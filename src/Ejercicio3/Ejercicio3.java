package Ejercicio3;

import static java.lang.Thread.sleep;

public class Ejercicio3 {
    public static void main(String[] args) {
        Hilo h1 = new Hilo("Hola");
        Hilo h2 = new Hilo(" mundo!\n");
        h1.start();
        try {
            sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        h2.start();

        // Descomentar para ver el apartado 2 en el que modificamos el programa

//        long i = System.currentTimeMillis();
//        while (true) {
//            if ((System.currentTimeMillis() - i) < 5000) {
//                h1.stop();
//                break;
//            }
//        }

    }
}

class Hilo extends Thread {
    String msg;

    public Hilo(String msg) {
        this.msg = msg;
    }

    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.print(msg);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

