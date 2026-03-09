import java.util.*;
import java.io.*;

public class B{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        //input line 1
        String in=br.readLine();
        StringTokenizer st_in=new StringTokenizer(in, " ");
        int n=Integer.parseInt(st_in.nextToken());
        int m=Integer.parseInt(st_in.nextToken());
        long k=Long.parseLong(st_in.nextToken());

        //Filling array 1
        String s1=br.readLine();
        StringTokenizer st1=new StringTokenizer(s1, " ");
        long[] arr1=new long[n];

        for(int i=0; i<n; i++){
            arr1[i]=Long.parseLong(st1.nextToken());
        }

        //Filling array 2
        String s2=br.readLine();
        StringTokenizer st2=new StringTokenizer(s2, " ");
        long[] arr2=new long[m];

        for(int i=0; i<m; i++){
            arr2[i]=Long.parseLong(st2.nextToken());
        }



        //Near sum
        int left=0;
        int right=m-1;
        long nearest_diff=Long.MAX_VALUE;
        int best_left=0;
        int best_right=m-1;

        while(left<n && right>=0){              //Different condition than normal two pointer
            long sum=arr1[left]+ arr2[right];
            long diff=Math.abs(sum-k);

            if(diff<nearest_diff){
                nearest_diff=diff;
                best_left=left;
                best_right=right;
            }

            if(sum>k) right--;
            if(sum <= k) left++;
        }

        out.println((best_left+1)+ " "+ (best_right+1));
        out.flush();
    }
}
