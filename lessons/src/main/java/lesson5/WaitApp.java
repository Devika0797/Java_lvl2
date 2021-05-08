package lesson5;

public class WaitApp {

   private final Object lock = new Object();
    String current = "A";

    public static void main(String[] args) {
        WaitApp printApp = new WaitApp();
        // сощздаем два потока
        Thread t1 = new Thread(printApp::printA);
        Thread t2 = new Thread(printApp::printB);
        t1.start();
        t2.start();
    }
    public void printA() {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                while (!current.equals("A")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                current = "B";
                lock.notify();
            }
        }
    }

    public void printB() {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                while (!current.equals("B")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                current = "A";
                lock.notifyAll();
            }
        }

    }
    private static class PrintApp {


    }
}
