import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 만들어야하는 숫자
        int[] make = new int[n];
        for (int i = 0; i < n; i++) {
            make[i] = Integer.parseInt(br.readLine());
        }
        int num = 1; // 자연수
        Stack<Integer> stack = new Stack<>(); // 스택
        boolean possible = true;

        for (int i = 0; i < make.length; i++) {
            // num <= make ? make 까지 넣고 pop 한번
            if (num <= make[i]) {
                while (num <= make[i]) {
                    stack.push(num);
                    sb.append("+\n");
                    num++;
                }
                stack.pop();
                sb.append("-\n");
            } else {
                // 적으면 make를 뺌
                int pop = stack.pop();
                if (pop != make[i]) {
                    possible = false;
                    break;
                }
                sb.append("-\n");
            }
        }
        if (possible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
