import java.io.*;

public class A3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine()); 
        for (int t = 0; t < T; t++) {
            long N = Integer.parseInt(br.readLine());              //Long- longer number
            long sum = (N*(N+1))/2;
            out.println(sum);
        }
        out.flush();
    }
}
