import java.util.*;
import java.io.*;

public class G {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        //input 
        StringTokenizer n_st=new StringTokenizer(br.readLine(), " ");
        int n1=Integer.parseInt(n_st.nextToken());
        int n2= Integer.parseInt(n_st.nextToken());
        String s1=br.readLine();
        StringTokenizer st1=new StringTokenizer(s1, " ");
        int[] arr=new int[n1];

        for(int i=0; i<n1; i++){
            arr[i]=Integer.parseInt(st1.nextToken());
        }


        for(int i=0; i<n2; i++){
            String a=br.readLine();
            StringTokenizer st_a=new StringTokenizer(a, " ");

            long low_given=Long.parseLong(st_a.nextToken());
            long up_given=Long.parseLong(st_a.nextToken());

            int up_indx= Bound(arr, up_given, "upper");
            int low_indx= Bound(arr, low_given, "lower");

            out.println(up_indx - low_indx);             //No +1
        }

        out.flush();
    }



//helper
    public static int Bound(int[] arr, long given, String s){
        int left=0;
        int right= arr.length-1;      

        while(left <= right){
            int mid= left + (right-left)/2;

            
            if(arr[mid]>given) right=mid-1;
            else if(arr[mid]<given) left= mid+1;

            else if(arr[mid]==given && s.equals("lower")) right=mid-1;
            else if(arr[mid]==given && s.equals("upper")) left= mid+1;
        }
        return left;
    }
}
