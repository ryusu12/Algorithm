import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        sc.close();
        String answer = "==";
        if(a>b) {
            answer = ">";
        } else if (a<b) {
            answer = "<";
        }
        System.out.println(answer);
    }
}