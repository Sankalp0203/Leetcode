//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        int T = sum;
        boolean[][] memMat = new boolean[N][T+1];
        for(int i=0;i<N;i++){
            memMat[i][0] = true;
        }
        
        for(int j=1;j<T+1;j++){
            memMat[N-1][j] = (j - arr[N-1] == 0);
        }
        
        for(int i=N-2;i>=0;i--){
            for(int j=T;j>=1;j--){
                memMat[i][j] = memMat[i+1][j];
                int subRes = j-arr[i];
                if(subRes >=0 && subRes<=T){
                    memMat[i][j] = memMat[i+1][subRes] || memMat[i][j];
                }
            }
        }
        return memMat[0][T];
    }
}