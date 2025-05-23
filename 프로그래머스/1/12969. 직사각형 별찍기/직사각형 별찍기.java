import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        StringBuilder col = new StringBuilder();

        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        
        char[] arr = new char[a + 1];
        Arrays.fill(arr, 0, a, '*');
        arr[a] = '\n';
        String row = new String(arr);
        
        for (int i = 0; i < b; i++) {
            col.append(row);
        }

        System.out.println(col.toString());
    }
}