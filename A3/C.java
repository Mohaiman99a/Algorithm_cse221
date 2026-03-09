import java.util.*;
import java.io.*;

public class C{

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        String s= br.readLine();
        StringTokenizer st=new StringTokenizer(s, " ");
        long a=Long.parseLong(st.nextToken());
        long b=Long.parseLong(st.nextToken());

        out.println(modularPower(a,b, 107));
        out.flush();
    }


    static long modularPower(Long a, Long b, int mod){
        long result=1;
        a=a%mod;

        while(b>0){           
            if(b%2==1){
                result = (result * a)% mod;
            }
            a=(a*a)%mod;
            b=b/2;
        }

        return result;
    }
}
