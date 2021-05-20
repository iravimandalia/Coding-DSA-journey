/*
Program for Fibonacci numbers
Difficulty Level : Medium (GFG)

The Fibonacci numbers are the numbers in the following integer sequence.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ......

Given a number n, print n-th Fibonacci Number.

Input  : n = 2
Output : 1

Input  : n = 9
Output : 34

*/

public class Fibonacci {
	
	//Fibonacci pure recursive function
	public static int recurFib(int n) {
		if(n == 0 || n == 1)
			return n;
		return recurFib(n-1) + recurFib(n-2);
	}
	
	//Fibonacci Memoized = Recursion + storage 
	public static int fibM(int n) {
		int storage[] = new int[n+1];
		for(int i = 0; i <= n; i++) {
			storage[i] = -1;
		}
		return fibM(n, storage);
	}
	
	//Memoize helper
	public static int fibM(int n, int storage[]) {
		//memoization technique
		if(n == 0 || n == 1) {
			storage[n] = n;
			return storage[n];
		}
		
		if(storage[n] != -1) {
			return storage[n];
		}
		
		storage[n] = fibM(n-1, storage) + fibM(n-2, storage); 
		
		return storage[n];
	}
	
	//Fibonacci DP = only storage + iterative
	public static int fibDp(int n) {
		//bottom up approach
		int[] storage = new int[n+1];
		storage[0] = 0;
		storage[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			storage[i] = storage[i-1] + storage[i-2];
		}
		return storage[n];
	}
	
	public static void main(String[] args) {
		int n = 9;
		System.out.println("DP solution: " + fibDp(n));
		System.out.println("Memoize solution: " + fibM(n));
		System.out.println("Recursive solution: " + recurFib(n));
	}
}
