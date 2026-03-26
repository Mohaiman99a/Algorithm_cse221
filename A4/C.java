import java.util.*;
import java.io.*;

public class C{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        int n= Integer.parseInt(br.readLine()); //Adj matrix size
        int[][] adj_matrix=new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine(), " ");
            int edge= Integer.parseInt(st.nextToken());
            for(int j=0; j<edge; j++){
                int v= Integer.parseInt(st.nextToken());
                adj_matrix[i][v]=1;
            }
        }


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
