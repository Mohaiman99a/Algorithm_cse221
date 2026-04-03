import java.util.*;
import java.io.*;

public class G{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st1=new StringTokenizer(br.readLine(), " ");
        int n= Integer.parseInt(st1.nextToken());
        int m= Integer.parseInt(st1.nextToken());
        int k= Integer.parseInt(st1.nextToken());

        boolean[][] board= new boolean[n+1][m+1];
        int[][] knights= new int[k][2];
        int[] moves_x= {-2, -2,  -1,  -1,  1,   1,   2,  2};
        int[] moves_y= {-1,  1,  -2,   2,  2,  -2,  -1,  1};
        boolean found= false;

        //Arranging inputs in the array
        for(int i=0; i<k; i++){
            StringTokenizer st2=new StringTokenizer(br.readLine(), " ");
            int x=Integer.parseInt(st2.nextToken());
            int y=Integer.parseInt(st2.nextToken());
            board[x][y]= true;
            knights[i][0]= x;   //row number
            knights[i][1]= y;   //col number
        }


        //Checking
        for(int i=0; i<k; i++){
            int x= knights[i][0];
            int y= knights[i][1];

            for(int j=0; j<8   ; j++){
                int curr_x= x + moves_x[j];
                int curr_y= y + moves_y[j];

                if(curr_x>=1 && curr_x<=n && curr_y>=1 && curr_y<= m){
                    if(board[curr_x][curr_y]){
                        found= true;
                        break;
                    }
                }
            }
            if(found) break;
        }

        if(found) out.println("YES");
        else out.println("NO");

        out.flush();
    }
}
