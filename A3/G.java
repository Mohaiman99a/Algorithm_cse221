//Inorder r kaj only bhag kora

import java.util.*;
import java.io.*;

public class G{

    static int[] inorder;
    static int[] preorder;
    static int pre_indx=0;


    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);


        //Filling up the array
        int n=Integer.parseInt(br.readLine());
        String s_in= br.readLine();
        StringTokenizer st_in=new StringTokenizer(s_in, " ");
        String s_pre= br.readLine();
        StringTokenizer st_pre=new StringTokenizer(s_pre, " ");
        inorder=new int[n];
        preorder= new int[n];
        for(int i=0; i<n; i++){
            inorder[i]= Integer.parseInt(st_in.nextToken());
            preorder[i]=Integer.parseInt(st_pre.nextToken());
        }

        
        postorder(0, n-1, out);  
        out.flush();
    }

    static void postorder(int start, int end, PrintWriter out){
        if(start>end) return;   //base case

        int root= preorder[pre_indx++]; 
        int in_indx= -1;

        for(int i=start; i<=    end; i++){
            if(inorder[i]==root){
                in_indx=i;
                break;
            }
        }

        //Left-Right-Data
        postorder(start, in_indx-1, out);
        postorder(in_indx+1, end, out);
        out.print(root+ " ");
    }
}
