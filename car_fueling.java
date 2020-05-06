import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
      int n=stops.length-2; 
      int numrefil=0,currrefil=0;
      while(currrefil<=n)
      {
        int lastrefil=currrefil;
        while(currrefil<=n && (stops[currrefil+1]-stops[lastrefil])<=tank)
            currrefil++;
        if(currrefil==lastrefil)
            return -1;
        if(currrefil<=n)
            numrefil++;
        }
        return numrefil;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n+2];
        stops[0]=0;
	for (int i = 1; i <= n; i++) {
            stops[i] = scanner.nextInt();
        }
	stops[n+1]=dist;
        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
