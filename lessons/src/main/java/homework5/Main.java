package homework5;

public class Main {
    private static final int size = 10000000;
    private static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod(){
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long t1 = System.currentTimeMillis();//vremya vipolneninya
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long t2 = System.currentTimeMillis();
        System.out.println("First method: " + (t2 - t1)); // vremya raboti

    }

    public static void secondMethod() throws InterruptedException {
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long t1 = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        // potoki
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        //skleika
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr1, 0, arr, h, h);
        long t2 = System.currentTimeMillis();
        System.out.println("Second method: " + (t2 - t1));



    }
}
