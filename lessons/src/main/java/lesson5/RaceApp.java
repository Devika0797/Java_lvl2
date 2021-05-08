package lesson5;

public class RaceApp {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        //locker
        Object lock = new Object();
        Object lock2 = new Object();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    synchronized (lock2) {
                        counter.increment();
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    synchronized (lock2) {
                        counter.increment();
                    }
                }
            }
        });
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();

        System.out.println(counter.getCount());
    }


    private static class Counter {
        private int count = 0;

        public int getCount() {
            return count;
        }

        public void increment() {
            count++;
        }
    }
}
