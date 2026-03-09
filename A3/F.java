import java.util.*;
import java.io.*;

public class F{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        int n=Integer.parseInt(br.readLine());
        String s= br.readLine();
        StringTokenizer st=new StringTokenizer(s, " ");
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        int[] result=new int[n];
        BST_inorder(arr, 0, n-1, result);
        for(int i=0; i<n; i++) out.print(result[i]+ " ");

        out.flush();
    }




    static int indx=0;
    static void BST_inorder(int[] arr, int l, int r, int[] result){
        if(l>r) return;     //Base case

        int mid=(l+r)/2;
        result[indx++]=arr[mid];
        BST_inorder(arr, l, mid-1, result);
        BST_inorder(arr, mid+1, r, result);
    }
}
