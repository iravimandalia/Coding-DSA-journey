/*
Problem name: Pair Sum
Difficulty: Easy

Problem Statement
Given an integer array arr of size N and an integer S. Return the list of all pairs of elements such that for each sum of elements of each pair equals to S.

Problem Statement:
-------------------------
Given an integer array arr of size N and an integer S. Return the list of all pairs of elements such that for each sum of elements of each pair equals to S.

Note:
-> Each pair should be sorted i.e the first value should be less than or equals to the second value. 
-> Return the list of pairs sorted in non-decreasing order of their first value. In case if two pairs have the same first value, the pair with a smaller second value should come first.


Sample Input 1:
5 5
1 2 3 4 5
Sample Output 1:
1 4
2 3

Sample Input 2:
5 0
2 -3 3 3 -2
Sample Output 2:
-3 3
-3 3
-2 2

*/


/*
Approach 1 - Brute Force
Initialize a list to store our results. For each element in the array arr[i], 0 <= i < N, check if (arr[i] + arr[j]), equals to given sum or not, where i < j < N. If the condition matches, add the pair(arr[i], arr[j]) to the list. Sort the list of pairs as per the given output format and return this list.

Time Complexity
O(N^2), where N is the size of the input array.

In the worst case, for each element, we will be checking all other elements in the array.

Space Complexity
O(1)

In the worst case, a constant extra space is required.
*/

import java.util.*;

public class Solution {
	public static int[][] pairSum(int arr[], int S) {
		int n = arr.length;
		
		List<int[]> ans = new ArrayList<>();
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++) {
				if(arr[i] + arr[j] == S){
					int[] pair = new int[2];
					pair[0] = arr[i];
					pair[1] = arr[j];
					ans.add(pair);
				}
			}
		}
		
		int res[][] = new int[ans.length][2];
		for(int i = 0; i < ans.size(); i++){
			int num1 = ans.get(i)[0];
			int num2 = ans.get(i)[1];
			
			res[i][0] = Math.min(num1, num2);
			res[i][1] = Math.max(num1, num2);
		}
		
		Arrays.sort(res, new Comparator<int[]>(){
			public int compare(int a[], int[] b){
				if(a[0] == b[0]) {
					return a[1] - b[1];
				} else {
					return a[0] - b[0];
				}
			}
		});
		
		return res;
	}
}

/*
Approach 2 - Using HashMap
After initializing the list to store our results. For each element in the array arr[i], 0 <= i < N, we will check whether there exists an element equals to (S - arr[i]) already in the map. If it exists we will add the pair(arr[i], S - arr[i]) count number of times to the list, where count represents the frequency of (S - arr[i]) in the map. Also, we will increment the frequency of the current element (arr[i]) in the map. Sort the list of pairs as per the given output format and return this list.

Time Complexity
O(N), where N is the number of elements in the array.

In the worst case, for each element, we will be adding all the pairs formed by this element in the array.

Space Complexity
O(N), where N is the number of elements in the array.

In the worst case, O(N) extra space is required for the hashmap to store the frequency of each element.
*/

import java.util.*;

public class Solution {

    public static int[][] pairSum(int arr[], int S) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap();
        
		List<int[]> ans = new ArrayList();
		for(int ele : arr) {
			int count = map.getOrDefault(S - ele, 0);
				
			int[] pair = new int[2];
			pair[0] = ele;
			pair[1] = S - ele;
				
			while(count-- > 0) {
			ans.add(pair);
			}
				
			map.put(ele, map.getOrDefault(ele, 0) + 1);
		}
	    
		int res[][] = new int[ans.size()][2];
		for(int i = 0; i < ans.size(); i++) {
			int a = ans.get(i)[0], b = ans.get(i)[1];
			res[i][0] = Math.min(a, b);
			res[i][1] = Math.max(a, b);
		}
		
		Arrays.sort(res, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
			if(a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
			}
		});
		
		return res;
    }
}