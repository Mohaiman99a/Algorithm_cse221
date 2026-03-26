import java.util.*;
import java.io.*;

public class B{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());          //Vertex number
        int m= Integer.parseInt(st.nextToken());         //Edge Number


        //Inputting u,v,w
        StringTokenizer st_u=new StringTokenizer(br.readLine());
        int[] u= new int[ m ];   
        for(int i=0; i<m; i++){
           u[i]=Integer.parseInt(st_u.nextToken());  
        }

        StringTokenizer st_v=new StringTokenizer(br.readLine());
        int[] v= new int[m];
        for(int i=0; i<m; i++){
           v[i]=Integer.parseInt(st_v.nextToken());
        }

        StringTokenizer st_w=new StringTokenizer(br.readLine());
        int[] w= new int[m];
        for(int i=0; i<m; i++){
           w[i]=Integer.parseInt(st_w.nextToken());  
        }


        //ArrayList inside an array
        ArrayList<String>[] adj=new ArrayList[n+1];    //int[] arr=new int[n+1] 
        for(int i=1; i<=n; i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0; i<m;i++){
            adj[u[i]].add(  "("  + v[i] +   ","  + w[i] +  ")" );
        }


        //Output
        StringBuilder sb=new StringBuilder();
        for(int i=1; i<=n; i++){    
                sb.append(i);      
                sb.append(":");
                for(String curr: adj[i]){
                    sb.append(" ");
                    sb.append(curr);
                }
                sb.append("\n");
        }
        out.print(sb);
        out.flush();
    }
}
