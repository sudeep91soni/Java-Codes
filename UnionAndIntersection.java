package geeksForGeeks.arrays;

import java.util.HashMap;

public class UnionAndIntersection {

	public static void main(String[] args) {

		getUnion(new int[] { 2, 4, 7, 9, 12, 12, 15 },
				new int[] { 3, 9, 12, 15 });
		System.out.println();

		getUnionMap(new int[] { 2, 4, 7, 9, 12, 12, 15 }, new int[] { 3, 9, 12,
				15 });
		System.out.println();

		getIntersectionBS(new int[] { 2, 4, 7, 9, 12, 15 }, new int[] { 3, 9,
				12, 15 });
	}

	private static void getIntersectionBS(int[] arr1, int[] arr2) {

		for (int i = 0; i < arr2.length; i++) {
			if (binarySearch(arr1, arr2[i], 0, arr1.length)) {
				System.out.println(arr2[i]);
			}
		}

	}

	private static boolean binarySearch(int[] arr, int k, int i, int j) {
		if (i > j) {
			return false;
		} else {
			int mid = i + (j - i) / 2;
			if (arr[mid] == k) {
				return true;
			} else if (arr[mid] < k) {
				return binarySearch(arr, k, mid + 1, j);
			} else {
				return binarySearch(arr, k, i, mid - 1);
			}
		}
	}

	private static void getUnionMap(int[] arr1, int[] arr2) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr1.length; i++) {
			if (!map.containsKey(arr1[i])) {
				System.out.println(arr1[i]);
				map.put(arr1[i], 1);
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			if (!map.containsKey(arr2[i])) {
				System.out.println(arr2[i]);
				map.put(arr2[i], 1);
			}
		}

	}

	private static void getUnion(int[] arr1, int[] arr2) {

		int idx1 = 0;
		int idx2 = 0;

		while (idx1 < arr1.length && idx2 < arr2.length) {
			if (arr1[idx1] < arr2[idx2]) {
				System.out.println(arr1[idx1++]);
			} else if (arr1[idx1] > arr2[idx2]) {
				System.out.println(arr2[idx2++]);
			} else {
				System.out.println(arr1[idx1++]);
				idx2++;
			}
		}
	}
}
