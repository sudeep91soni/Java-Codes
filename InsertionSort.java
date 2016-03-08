package geeksForGeeks.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static <T extends Comparable<T>> void insertionSort(T[] arr) {

		if (arr.length == 0) {
			return;
		}
		for (int pos1 = 1; pos1 < arr.length; pos1++) {
			int pos2 = pos1 - 1;
			while (pos2 >= 0
					&& arr[pos2 + 1].compareTo(arr[pos2]) < 0) {
				T temp = arr[pos2 + 1];
				arr[pos2 + 1] = arr[pos2];
				arr[pos2] = temp;
				pos2--;
			}
		}
	}

	public static void main(String[] args) {

		Integer[] arr = new Integer[] { 4, 2, 90, 0, 3, 6 };
		System.out.println(Arrays.toString(arr));
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		
		String[] strArr = new String[] { "42", "23", "9", "0", "3", "6" };
		System.out.println(Arrays.toString(strArr));
		insertionSort(strArr);
		System.out.println(Arrays.toString(strArr));
	}
}
