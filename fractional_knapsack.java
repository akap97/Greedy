import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FractionalKnapsack {
    private static Scanner scanner;

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int n = values.length, a;
        Double[] vBw = new Double[n];
        
        for (int i = 0; i < n; i++) {
            vBw[i] = (Double) (values[i]*1.0/weights[i]);
        }
        Map<Double, Integer[]> m = new HashMap<Double, Integer[]>();
        
        for (int i = 0; i < n; i++) {
            Integer[] temp = new Integer[2];
            temp[0] = values[i];
            temp[1] = weights[i];
            m.put(vBw[i], temp);
        }
        Map<Double, Integer[]> newMap = new TreeMap<Double, Integer[]>(Collections.reverseOrder());
        newMap.putAll(m);
        for (Double key: newMap.keySet()) {
            if (capacity == 0) {
                return value;
            }
            a = (newMap.get(key)[1] > capacity)?capacity:newMap.get(key)[1];
            value = value+a*(newMap.get(key)[0]*1.0/newMap.get(key)[1]);
            capacity = capacity-a;
        }
        return value;
    }
    public static void main(String args[]) {
        scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        double ans = getOptimalValue(capacity, values, weights);
        System.out.println(String.format("%.4f", ans));
    }
} 
