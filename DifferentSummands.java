import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        int i=1,sum=0;
        while(true)
        {
            sum+=i;
            if(sum>n)
            {
                //System.out.println("before size:"+summands.size());
                int lastind=summands.size()-1;
                //System.out.println("loopindex:"+lastind);
                int last=summands.get(lastind)+(n-(sum-i));
                summands.set(lastind,last);
                //System.out.println("after size:"+summands.size());
                break;
             }  
             summands.add(i);
             if(sum==n)
                break;
             i++;
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

