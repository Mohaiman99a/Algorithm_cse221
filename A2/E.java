import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        //input 
        StringTokenizer n_st=new StringTokenizer(br.readLine(), " ");
        int n=Integer.parseInt(n_st.nextToken());
        int target= Integer.parseInt(n_st.nextToken());
        String s1=br.readLine();
        StringTokenizer st1=new StringTokenizer(s1, " ");
        long[] arr=new long[n];

        for(int i=0; i<n; i++){
            arr[i]=Long.parseLong(st1.nextToken());
        }


        //Finding the longest subarray
        int left=0;
        long sum=0;
        int maxLength=0;

        for(int right=0; right<n; right++){
            sum= sum + arr[right];

            while(sum>target && left<=right){
                sum= sum - arr[left];
                left++;
            }
            maxLength= Math.max(maxLength, (right-left+1));     //Careful
        }

        
        out.println(maxLength);
        out.flush();
    }
}
