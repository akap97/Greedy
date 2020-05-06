import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        Arrays.sort(segments, new Comparator<Segment>(){
            @Override
            public int compare(Segment segment1, Segment segment2) {
                return segment1.end - segment2.end;
            }
        });
        List<Integer> listOfPoints = new ArrayList<>();
        int i = 0, n = segments.length;
        while (i < n) {
            int right = segments[i].end;
            listOfPoints.add(right);
            // BZ: must fix `right` since i is increasing
            while (i < n &&  segments[i].start <= right &&
                    right <= segments[i].end)
                i++;
        }
         int[] points = new int[listOfPoints.size()];
        for(int j = 0; j < listOfPoints.size(); j++)
            points[j] = listOfPoints.get(j);
        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
