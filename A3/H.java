import java.util.*;
import java.io.*;

public class H{

    static int[] inorder;
    static int[] postorder;
    static int post_indx=0;


    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);


        //Filling up the array
        int n=Integer.parseInt(br.readLine());
        String s_in= br.readLine();
        StringTokenizer st_in=new StringTokenizer(s_in, " ");
        String s_post= br.readLine();
        StringTokenizer st_post=new StringTokenizer(s_post, " ");
        inorder=new int[n];
        postorder= new int[n];
        for(int i=0; i<n; i++){
            inorder[i]= Integer.parseInt(st_in.nextToken());
            postorder[i]=Integer.parseInt(st_post.nextToken());
        }

        
        preorder(0, n-1, 0, n-1, out);   
        out.flush();
    }

    static void preorder(int in_start, int in_end, int post_start, int post_end, PrintWriter out){
        if(in_start>in_end || post_start>post_end) return;   //base case

        int root= postorder[post_end];   //* */
        
        //Data-left-right
        out.print(root+ " ");
        int in_indx= -1;
        for(int i=in_start; i<=  in_end; i++){
            if(inorder[i]==root){
                in_indx=i;
                break;
            }
        }

        int leftSize = in_indx - in_start;

        preorder(in_start, in_indx-1, post_start, post_start+leftSize-1, out);
        preorder(in_indx+1, in_end, post_start+leftSize, post_end-1  , out);
  
    }
}
