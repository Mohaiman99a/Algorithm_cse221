import java.util.*;
import java.io.*;

public class H {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        int n=Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine(), " ");
            long k=Long.parseLong(st.nextToken());
            long x=Long.parseLong(st.nextToken());

            long skipped= (k-1)/(x-1);
            long val= k+ skipped;

            out.println(val);
        }
        
        out.flush();
    }

}

