//{ Driver Code Starts
//Initial Template for Java

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
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int[][] memMat = new int[n][m];
        int max = 0;
        for(int i=0;i<n;i++){
            if(S1.charAt(i) == S2.charAt(m-1)){
                memMat[i][m-1] = 1;
                max = 1;
            }
        }
        
        for(int i=0;i<m;i++){
            if(S1.charAt(n-1) == S2.charAt(i)){
                memMat[n-1][i] = 1;
                max = 1;
            }
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
                if(S1.charAt(i) == S2.charAt(j)){
                    memMat[i][j] = memMat[i+1][j+1] + 1;
                    max = Math.max(max, memMat[i][j]);
                } else {
                    memMat[i][j] = 0;
                }
            }
        }
        
        return max;
    }
}