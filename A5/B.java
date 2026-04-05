import java.util.*;
import java.io.*;


public class B{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        //Input 1
        StringTokenizer st1= new StringTokenizer(br.readLine(), " ");
        int nodes= Integer.parseInt(st1.nextToken());
        int edges= Integer.parseInt(st1.nextToken());

        ArrayList<Integer>[] graph= new ArrayList[nodes+1];
        for(int i=1; i<=nodes; i++){
            graph[i]= new ArrayList<>();
        }


        //Input 2 & 3
        StringTokenizer st_u= new StringTokenizer(br.readLine(), " ");
        StringTokenizer st_v= new StringTokenizer(br.readLine(), " ");
        for(int i=0; i< edges; i++){
            int u= Integer.parseInt(st_u.nextToken());
            int v= Integer.parseInt(st_v.nextToken());
            graph[u].add(v);      //u[i] index r value graph r index number jekhane add hobe value
            graph[v].add(u);
        }

        //Sort before dfs
        for(int i=1; i<=nodes; i++){
            Collections.sort(graph[i], Collections.reverseOrder());

        }


        //dfs
        boolean[] visited= new boolean[nodes+1];
        Stack<Integer> s= new Stack<>();

        s.push(1);

        ArrayList<Integer> result= new ArrayList<>();

        while(!s.isEmpty()){
            int curr=s.pop();
            if(visited[curr]) continue;

            visited[curr]= true;  //result e add korar time true hobe
            result.add(curr);
            for(int neighbor: graph[curr]){    //because you have to complete the entire path
                if(!visited[neighbor]){
                    s.push(neighbor); 
                }
            }
        }


        //print
        for(int i=0; i<result.size(); i++){
            out.print(result.get(i)+ " ");
        }
        out.flush();
    } 
}
