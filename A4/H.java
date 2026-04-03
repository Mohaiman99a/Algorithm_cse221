import java.util.*;
import java.io.*;

public class H {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st1=new StringTokenizer(br.readLine(), " ");
        int N= Integer.parseInt(st1.nextToken());
        int Q= Integer.parseInt(st1.nextToken());

        int[][] adj_graph= new int[N+1][N+1];
        int[] indx_for_all= new int[N+1];

        //Filling up according to gcd
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i!=j && gcd(i,j)==1){
                    adj_graph[i][indx_for_all[i]]= j;
                    indx_for_all[i]++;
                }
            }
        }

        //output
        for(int i=0; i<Q; i++){
            StringTokenizer st2=new StringTokenizer(br.readLine(), " ");
            int a= Integer.parseInt(st2.nextToken());
            int b= Integer.parseInt(st2.nextToken());

            if(b <= indx_for_all[a]) out.println(adj_graph[a][b-1]);
            else out.println(-1);
        }
        out.flush();
    }




    public static int gcd(int a, int b){
        while(b!=0){
            int temp= a%b;
            a= b;
            b= temp;
        }
        return a;
    }

}
