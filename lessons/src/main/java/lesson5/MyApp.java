package lesson5;

public class MyApp {

    public static void main(String[] args) throws InterruptedException { // метод main создает и запускает второй поток
        Thread thread = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        // объявление через анонимный класс
        Thread thread3 = new Thread(new MyRunnable(){
            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    System.out.println(i);
                }
            }
        });

        // заменить на лямду выражение
        Thread thread4 = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                }
        });

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread3.join();// блокировка потока "Дождись, пока поток не закончит свою работу" Тот, кто вызывает join, тот и ждет
        thread4.join();
        System.out.println("main end");
    }
// 1 вариант запуска потоков
    private static class MyRunnable implements Runnable { // поток MyRunnable делает работу, выполняет логику

        @Override
        public void run() { //  run и start - методы разных интерфейсов
            for (int i = 0; i < 2; i++) {
                try {
                    Thread.sleep(400);// заставляет поток поспать 400 милисекунд
                }catch (InterruptedException e){ // приостановление потока
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + i);

            }
        }
    }

// 2 вариант запуска потоков

    private static class MyThread extends Thread {
        @Override
        public void run() { //
            for (int i = 0; i < 3; i++) {
                System.out.println(i);

            }
        }

    }

}
