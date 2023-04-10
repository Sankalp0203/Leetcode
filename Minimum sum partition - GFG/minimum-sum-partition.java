//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int nums[], int n) 
	{ 
	    // Your code goes here
	    int tSum = 0;
	    for(int i: nums){
	        tSum += i;
	    }
        int[][] memMat = new int[2][tSum+1];
        
        for(int i=0;i<=tSum;i++){
            memMat[1][i] = Math.abs(2*i-tSum);
        }
        
        int iVal = 0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=tSum;j++){
                int cVal = iVal%2;
                int nVal = cVal+1;
                nVal = nVal%2;
                memMat[cVal][j] = memMat[nVal][j];
                if(j+nums[i] <= tSum){
                    memMat[cVal][j] = Math.min(memMat[nVal][j], memMat[nVal][j+nums[i]]);
                }
            }
            iVal++;
        }
        iVal--;
        iVal = iVal%2;
        return memMat[iVal][0];
	} 
}
