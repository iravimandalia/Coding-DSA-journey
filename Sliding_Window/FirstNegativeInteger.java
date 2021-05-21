/*
First negative integer in every window of size k.
https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/


Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.

Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
Output : -8 0 -6 -6
First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6

Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
Output : -1 -1 -7 -15 -15 0

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(K)
*/

import java.util.LinkedList;
public class FirstNegativeInteger {
	
	public static long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        LinkedList<Long> l = new LinkedList<>();
        long[] ans = new long[N-K+1];
        int ind = 0;
        int i = 0, j = 0;
        
        while(j < N){
            if(A[j] < 0) {
                l.add(A[j]);
            }
                
            if(j-i+1 < K) {
                j++;
            }
            else if(j-i+1 == K){
                if(l.size() != 0) {
                	ans[ind++] = l.peek();
                }
                else {
                	ans[ind++] = 0L;
                }
                if(A[i] < 0)
                	l.remove();
                i++;
                j++;
            }
        }
        return ans;
    }
	
	//driver code
	public static void main(String[] args) {
		int N = 5;
		long A[] = {-8, 2, 3, -6, 10};
		int K = 2;
		
		long ans[] = printFirstNegativeInteger(A, N, K);
		for(int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

}
