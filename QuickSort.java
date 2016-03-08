package geeksForGeeks.sorting;

import java.util.Arrays;

public class QuickSort {

	public static <T extends Comparable<T>> int getIndOfPivot(T[] arr,
			int start, int end) {
		T pivot = arr[end];
		int idx1 = start;
		for (int idx2 = start; idx2 < end; idx2++) {
			if (arr[idx2].compareTo(pivot) < 0) {
				T temp = arr[idx1];
				arr[idx1] = arr[idx2];
				arr[idx2] = temp;
				idx1++;
			}
		}
		T temp = arr[idx1];
		arr[idx1] = arr[end];
		arr[end] = temp;
		return idx1;
	}

	public static <T extends Comparable<T>> void quickSort(T[] arr, int start,
			int end) {

		if (arr.length == 0 || start >= end) {
			return;
		}

		int idx1 = getIndOfPivot(arr, start, end);

		quickSort(arr, start, idx1 - 1);
		quickSort(arr, idx1, end);
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 4, 2, 90, 0, 3, 6 };
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

		String[] strArr = new String[] { "sudeep", "ravi", "varsha", "om",
				"sonam", "swastik" };
		System.out.println(Arrays.toString(strArr));
		quickSort(strArr, 0, strArr.length - 1);
		System.out.println(Arrays.toString(strArr));
	}
}
