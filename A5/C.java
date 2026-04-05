import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st1= new StringTokenizer(br.readLine(), " ");
        int nodes= Integer.parseInt(st1.nextToken());
        int edges= Integer.parseInt(st1.nextToken());
        int s= Integer.parseInt(st1.nextToken());
        int d= Integer.parseInt(st1.nextToken());

        //Make arrayList before making the graph
        ArrayList<Integer>[] graph = new ArrayList[nodes+1];
        for(int i=1; i<= nodes; i++){
            graph[i]= new ArrayList<>();
        }


        //making the graph
        if(edges>0){
        StringTokenizer st_u= new StringTokenizer(br.readLine(), " ");
        StringTokenizer st_v= new StringTokenizer(br.readLine(), " ");

         for(int i=0; i<edges; i++){
            int u= Integer.parseInt(st_u.nextToken());
            int v= Integer.parseInt(st_v.nextToken());

            graph[u].add(v);
            graph[v].add(u);
          }
        }

        //lexicographically
        for(int i=1; i<=nodes; i++){
            Collections.sort(graph[i]);
        }

        //Bfs
        boolean[] visited= new boolean[nodes+1];
        int[] parent= new int[nodes+1];
        int[] distance= new int[nodes+1];

        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        visited[s]= true;
        distance[s]=0;
        parent[s]=0;

        while(!q.isEmpty()){
            int node= q.poll();
            for(int neighbor: graph[node]){
                if(!visited[neighbor]){
                q.add(neighbor);
                visited[neighbor]= true;
                distance[neighbor]=distance[node]+1;
                parent[neighbor]= node;
                }
            }
        }


        //couldn't reach
        if(!visited[d]){
            out.println(-1);
            out.flush();
            return;
        }


        //If reaches, backtrack
        ArrayList<Integer> path= new ArrayList<>();
        int curr= d;

        while(curr!=0){      //stops when parent becomes 0
            path.add(curr);
            curr= parent[curr];
        }


        //reverse the path
        Collections.reverse(path);

        out.println(distance[d]); //distance
        for(int i=0; i<path.size(); i++){
            out.print(path.get(i));
            if(i+1<path.size()) out.print(" ");
        }
        out.flush();
    }
}
