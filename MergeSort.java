package geeksForGeeks.sorting;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {

	public static <T extends Comparable<T>> void mergeSort(T[] arr, int start,
			int end) {

		if (arr.length == 0 || start >= end) {
			return;
		}
		int mid = start + (end - start + 1) / 2;
		mergeSort(arr, start, mid - 1);
		mergeSort(arr, mid, end);
		merge(arr, start, mid, end);
	}

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void merge(T[] arr, int start,
			int mid, int end) {

		Object[] aux1 = new Object[mid - start];

		Object[] aux2 = new Object[end - mid + 1];
		int i = start;
		int idx = 0;
		while (i < mid) {
			aux1[idx++] = arr[i++];
		}
		i = mid;
		idx = 0;
		while (i <= end) {
			aux2[idx++] = arr[i++];
		}
		int idx1 = 0;
		int idx2 = 0;
		int pos = start;
		while (idx1 < aux1.length && idx2 < aux2.length) {
			if (((T) aux1[idx1]).compareTo((T) aux2[idx2]) <= 0) {
				arr[pos++] = (T) aux1[idx1++];
			} else {
				arr[pos++] = (T) aux2[idx2++];
			}
		}

		if (idx1 == aux1.length) {
			while (idx2 != aux1.length) {
				arr[pos++] = (T) aux2[idx2++];
			}
		} else if (idx2 == aux2.length) {
			while (idx1 != aux1.length) {
				arr[pos++] = (T) aux1[idx1++];
			}
		}
	}

	public static void main(String[] args) {

		Integer[] arr = new Integer[] { 4, 0, 0, 8, 3, 6 };
		System.out.println(Arrays.toString(arr));
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

		String[] strArr = new String[] { "sudeep", "varsha", "varsha", "ram",
				"ravi", "swastik" };
		System.out.println(Arrays.toString(strArr));
		mergeSort(strArr, 0, strArr.length - 1);
		System.out.println(Arrays.toString(strArr));
	}
}
