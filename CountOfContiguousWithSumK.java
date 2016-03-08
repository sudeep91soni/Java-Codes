package geeksForGeeks.arrays;

import java.util.Arrays;

public class CountOfContiguousWithSumK {

	public static void main(String[] args) {

		// Top four works for all numbers...
		countContiBlocksLongAll(new int[] { 4, -5, -1, 7, -8, 1 }, -1);

		countContiBlocksLongAll(new int[] { 4, -5, 0, 1, 0, 1 }, 1);

		countContiBlocksUnOptimised(new int[] { 4, -5, -1, 7, -8, 1 }, -1);

		countContiBlocksUnOptimised(new int[] { 4, 4, 8, 6, 2, 7, 8, 0, 8 }, 8);

		System.out.println();

		countContiBlocksPositive(new int[] { 4, 4, 8, 6, 2, 7, 8, 0, 8 }, 8);

	}

	// works for all order n2
	private static void countContiBlocksLongAll(int[] arr, int k) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum == k) {
					System.out.println(i + " " + j);
					count++;
				}
			}
		}
		System.out.println(count);
	}

	// Works perfectly fine for all but unoptimised...
	private static void countContiBlocksUnOptimised(int[] arr, int k) {
		int count = 0;
		int[] temp = new int[arr.length + 1];

		temp[0] = 0;
		for (int i = 0; i < arr.length; i++) {
			temp[i + 1] = temp[i] + arr[i];
		}
		System.out.println(Arrays.toString(arr));

		System.out.println(Arrays.toString(temp));

		for (int i = 0; i < temp.length; i++) {
			for (int j = temp.length - 1; j > i; j--) {
				if (temp[i] == temp[j] - k) {
					count++;
					System.out.println(i + " " + (j - 1));
				}
			}
		}

		/*
		 * HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		 * 
		 * for (int i = 0; i < temp.length; i++) { //
		 * System.out.println("start"); // System.out.println(temp[i] +
		 * Arrays.toString(temp)); if (map.containsKey(temp[i] - k)) {
		 * System.out.println(map.get(temp[i] - k) + " " + (i - 1)); count++;
		 * map.put(temp[i], i); } else { // System.out.println("sdf" + temp[i]);
		 * map.put(temp[i], i); } }
		 */
		System.out.println(count);
	}

	// Window method for positive numbers But misses the end cases like
	// countContiBlocksPositive(new int[] { 4, 4, 8, 6, 2, 7, 8, 0, 0, 8 }, 8);
	private static void countContiBlocksPositive(int[] arr, int k) {

		/*
		 * Initialize curr_sum as value of first element and starting point as 0
		 */
		int count = 0;
		int curr_sum = arr[0], start = 0, i;

		/*
		 * Add elements one by one to curr_sum and if the curr_sum exceeds the
		 * sum, then remove starting element
		 */
		for (i = 1; i <= arr.length; i++) {

			System.out.println("====" + curr_sum + " " + start + " " + i);
			// If curr_sum exceeds the sum, then remove the starting elements
			while (curr_sum > k && start < i - 1) {
				curr_sum = curr_sum - arr[start];
				start++;
			}

			// If curr_sum becomes equal to sum, then return true
			if (curr_sum == k) {
				System.out.println(start + " " + (i - 1));
				count++;
			}

			// Add this element to curr_sum
			if (i < arr.length)
				curr_sum = curr_sum + arr[i];
		}

		// If we reach here, then no subarray
		System.out.println(count);

	}

}
