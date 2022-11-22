package EjercicioMesaFilosofos;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numHilos = 5;
        Thread[] lstHilos = new Thread[numHilos];

        for (int i = 0; i < numHilos; i++) {
            lstHilos[i] = new Thread(new HiloFilosofo(i, new Random().nextBoolean()));
            lstHilos[i].start();
        }
    }


    static class HiloFilosofo extends Thread {
        int id;
        boolean turno;

        public HiloFilosofo(int id, boolean turno) {
            this.id = id;
            this.turno = turno;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("ID: " + id + " Turno: " + turno);
            }
        }
    }
}