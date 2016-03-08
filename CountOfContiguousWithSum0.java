package geeksForGeeks.arrays;

import java.util.Arrays;

public class CountOfContiguousWithSum0 {

	public static void main(String[] args) {

		countContiBlocksUnOpt(new int[] { 4, 5, 1, 7, 0, -8, 1, 0, 1, -1, 0 });

	}

	// Not optimised... order n2 but works fine for all numbers only for sum as zero.
	private static void countContiBlocksUnOpt(int[] arr) {
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
				if (temp[i] == temp[j]) {
					count++;
					System.out.println(i + " " + (j - 1));
				}
			}
		}
		/*
		 * HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); for
		 * (int i = 0; i < temp.length; i++) { if (map.containsKey(temp[i])) {
		 * System.out.println(map.get(temp[i]) + " " + (i - 1)); count++; } else
		 * { map.put(temp[i], i); } }
		 */
		System.out.println(count);
	}
}
