package HWK5;

public class MI3C_HWK5_412630153_06 {
    static int threadUsed = 4;
    static int[] rlt = new int[threadUsed];
    public static void main(String[] args){
        int m = 100_000, n = threadUsed;
        double singleTime = singleThread(m);
        double multiTime = multiThread(m, n);
        System.out.println("Total numbers: " + m + "\nThreads used: " + n);
        System.out.println("Total execution time of SingleThread：" + singleTime +" s");
        System.out.println("Total execution time of MultiThread：" + multiTime +" s");
    }
    static double singleThread(int m){
        int cnt = 0;
        double start = System.currentTimeMillis();
        for (int i = 2 ; i < m ; i++){
            if(isPrime(i)){
                cnt++;
            }
        }
        double end = System.currentTimeMillis();
        double time = (end - start) / 1000;
        System.out.println("Single thread prime cnt: " + cnt);
        return time;
    }
    static double multiThread(int m, int n){
        int step = m / n;
        Thread[] t = new Thread[n];
        int total = 0;
        double start = System.currentTimeMillis();
        for (int i = 0 ; i < n ; i++){
            final int lower = step * i + 1;
            final int upper = step * (i + 1);
            final int index = i;
            t[i] = new Thread(() -> {
                rlt[index] = isPrimeLoop(lower, upper);
            });
            t[i].start();
        }
        for (int i = 0; i < n; i++) {
            try {
                t[i].join();
                total+=rlt[i];
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        double end = System.currentTimeMillis();
        double time = (end - start) / 1000;
        System.out.println("Multiple thread prime cnt: " + total);
        return time;
    }
    static int isPrimeLoop(int start, int end){
        int cnt = 0;
        for (int i = start ; i <= end ; i++){
            if(i<2){
                continue;
            }
            if(isPrime(i)){
                cnt++;
            }
        }
        return cnt;
    }
    static boolean isPrime(int n){
        for (int i = 2 ; i <= Math.sqrt(n) ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
/*
CPU: AMD Ryzen 7 7700 8C16T
Single thread prime cnt: 5761455
Multiple thread prime cnt: 5761455
Total numbers: 100000000
Threads used: 4
Total execution time of SingleThread：53.231 s
Total execution time of MultiThread：18.447 s
 */
