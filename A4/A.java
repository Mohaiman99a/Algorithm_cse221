import java.util.*;
import java.io.*;

public class A{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken()); //Adj matrix size
        int m= Integer.parseInt(st.nextToken()); //Number of input

        //Filling the matrix
        int[][] adj_matrix=new int[n][n];
        for(int i=0; i<m; i++){
            StringTokenizer st2=new StringTokenizer(br.readLine());
            int u= Integer.parseInt(st2.nextToken());
            int v= Integer.parseInt(st2.nextToken());
            int w= Integer.parseInt(st2.nextToken());

            adj_matrix[u-1][v-1]= w;   //Input(1 indx based) -> 0 indx based
        }


        //Output
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(adj_matrix[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        out.print(sb);
        out.flush();
    }
}
