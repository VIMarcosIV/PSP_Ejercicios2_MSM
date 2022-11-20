package Ejercicio3;

public class Main implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 15; i++) {
                if (Thread.currentThread().getName().equals("Thread-1")) {
                    System.out.println(Thread.currentThread().getName() + ": " + "Hola");
                    Thread.sleep(2000);
                } else if (Thread.currentThread().getName().equals("Thread-0")) {
                    if (i == 0) Thread.sleep(20);
                    System.out.println(Thread.currentThread().getName() + ": " + "mundo");
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Thread world = new Thread(main);
        Thread hello = new Thread(main);
        hello.start();
        world.start();
        try {
            Thread.sleep(5000);
            hello.interrupt();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
