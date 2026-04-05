import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine(), " ");
        int nodes= Integer.parseInt(st.nextToken());
        int edges= Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph= new ArrayList[nodes + 1];     //[] graph- is an array of Arraylist type

        //arraylist initialize kora
        for(int i=1; i<=nodes ; i++){
            graph[i]= new ArrayList<>();
        }

        //Fill up the array
        for(int i=0; i<edges; i++){
            StringTokenizer st2= new StringTokenizer(br.readLine(), " ");
            int u= Integer.parseInt(st2.nextToken());
            int v= Integer.parseInt(st2.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }


        //BFS
        boolean[] visited= new boolean[nodes+1];
        Queue<Integer> q= new LinkedList<>();

        visited[1]= true;
        q.add(1);

        while(!q.isEmpty()){
            int u=q.poll();
            out.print(u+ " ");

            for(int v:graph[u]){         //ArrayList r prothom tay giye boshbe
                if(!visited[v]){
                   visited[v]= true;
                    q.add(v); 
                }
            }
        }
        out.flush(); 
    }      
}
