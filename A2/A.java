import java.util.*;
import java.io.*;

public class A{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        //input
        String in=br.readLine();
        StringTokenizer st_in=new StringTokenizer(in, " ");
        int n=Integer.parseInt(st_in.nextToken());
        long sum=Long.parseLong(st_in.nextToken());

        //Filling the array
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s, " ");
        long[] arr=new long[n];

        for(int i=0; i<n; i++){
            arr[i]=Long.parseLong(st.nextToken());
        }


        //Finding the sum 
        // 2 pointer used as already sorted
        int left=0;
        int right= n-1;
        boolean found=false;

        while(left<right && found==false){                 
            long sum_check= arr[left] + arr[right];

            if(sum_check==sum){
                found=true;
                out.println((left+1)+ " "+ (right+1));       //1 based indexing
            }
            else if(sum_check<sum) left++;
            else if(sum_check>sum) right--;
        }

        if(found==false) out.println("-1");
        out.flush();
    }
}
