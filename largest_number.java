import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
       for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int ij = Integer.parseInt(a[i] + a[j]);
                int ji = Integer.parseInt(a[j] + a[i]);
                if (ij < ji) {
                    String temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    j--;
                }
            }
        }
        return String.join("", a);
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

