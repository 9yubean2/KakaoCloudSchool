import java.util.*;
public class BOJ10872 {
    public static int factorial(int n){
        if (n<=1){
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(factorial(N));
    }

}
