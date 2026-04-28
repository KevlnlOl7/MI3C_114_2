package HWK10;

public class MI3C_HWK10_412630153_01 {
    public static void main(String[] args) {
        int sum = myFunction(12, 5, 16, 10, 7, 22, 6, 14, 9, 11);
        System.out.println(sum);
        test1();
    }
    public static int myFunction(int... n){
        int sum = 0;
        int i = 0;
        while(i < n.length){
            if(n[i] % 2 != 0){
                sum+=n[i];
            }
            i++;
        }
        return sum;
    }
    public static void test1() {
        int cnt = 0;
        int i = 2;
        while(cnt <= 400) {
            if (isPrime(i)) {
                cnt++;
                if (cnt % 100 == 0) {
                    System.out.println(i);
                }
            }
            i++;
        }
    }
    public static boolean isPrime(int n){
        int i = 2;
        while(i < Math.sqrt(n)){
            if(n%i==0){
                return false;
            }
            i++;
        }
        return true;
    }
    public static int checkSum(char ch){
        int num = 0;
        switch (ch){
            case 'A':
                num = 10;
                break;
            case 'B':
                num = 11;
                break;
            case 'C':
                num = 12;
                break;
            case 'D':
                num = 13;
                break;
            case 'E':
                num = 14;
                break;
            case 'F':
                num = 15;
                break;
            case 'G':
                num = 16;
                break;
            case 'H':
                num = 17;
                break;
            case 'I':
                num = 34;
                break;
            case 'J':
                num = 18;
                break;
            case 'K':
                num = 19;
                break;
            case 'L':
                num = 20;
                break;
            case 'M':
                num = 21;
                break;
            case 'N':
                num = 22;
                break;
            case 'O':
                num = 35;
                break;
            case 'P':
                num = 23;
                break;
            case 'Q':
                num = 24;
                break;
            case 'R':
                num = 25;
                break;
            case 'S':
                num = 26;
                break;
            case 'T':
                num = 27;
                break;
            case 'U':
                num = 28;
                break;
            case 'V':
                num = 29;
                break;
            case 'W':
                num = 32;
                break;
            case 'X':
                num = 30;
                break;
            case 'Y':
                num = 31;
                break;
            case 'Z':
                num = 33;
                break;
            default:
                break;
        }
        return 0;
    }
}
