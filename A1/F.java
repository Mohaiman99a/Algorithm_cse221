import java.io.*;
import java.util.*;

public class A6 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        int t= Integer.parseInt(br.readLine());

        //Fill array
        int[] arr=new int[t];
        String s= br.readLine();
        StringTokenizer st=new StringTokenizer(s, " ");
        for(int i=0; i<t; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }


        //Swaping
        for(int i=0;i<t; i++){
            for(int j=0; j<t-1;j++){
                if((arr[j]%2==0 && arr[j+1]%2==0) ||(arr[j]%2!=0 && arr[j+1]%2!=0)){
                    if(arr[j]> arr[j+1]){
                    int temp= arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            }
        }

        //print
        for(int i=0; i<t; i++){
            out.print(arr[i]+ " ");
        }
        out.flush();
    }
    
}
