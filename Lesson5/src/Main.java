import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int size = 10000000;
        int h = size / 2;
        float[] arr = new float[size];

        Arrays.fill(arr, 1.0f);

        oneThread(arr);
        System.out.println("===========");
        twoThreads(arr, h);
    }

    public static void oneThread(float[] arr) {
        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("single thread delta time: " + (System.currentTimeMillis() - a));
    }

    public static void twoThreads(float[] arr, int h) {
        float[] a1 = new float[h], a2 = new float[h];
        Thread t1, t2;
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        t1 = new Thread(() -> {
            synchronized (a1) {
                oneThread(a1);
            }
        });

        t2 = new Thread(() -> {
            synchronized (a2) {
                oneThread(a2);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("two threads delta time: " + (System.currentTimeMillis() - a));
    }
}
