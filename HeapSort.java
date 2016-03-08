package geeksForGeeks.sorting;

import java.util.Arrays;

// Using arrays

public class HeapSort {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 4, 2, 90, 0, 3, 6 };
		System.out.println(Arrays.toString(arr));
		heapSort(arr, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static int getLeft(int i, int lastIdx) {
		if ((2 * i + 1) <= lastIdx) {
			return 2 * i + 1;
		} else {
			return -1;
		}
	}

	public static int getRight(int i, int lastIdx) {
		if ((2 * i + 2) <= lastIdx) {
			return 2 * i + 2;
		} else {
			return -1;
		}
	}

	public static int getParent(int i, int lastIdx) {
		if ((i - 1) / 2 >= 0) {
			return (i - 1) / 2;
		} else {
			return -1;
		}
	}

	public static <T extends Comparable<T>> void swap(T[] arr, int i,
			int largest) {

		T temp = arr[i];
		arr[i] = arr[largest];
		arr[largest] = temp;
	}

	public static <T extends Comparable<T>> void maxHeapify(T[] arr, int i,
			int lastIdx) {
		T curr = arr[i];
		T left = getLeft(i, lastIdx) != -1 ? arr[getLeft(i, lastIdx)] : null;
		T right = getRight(i, lastIdx) != -1 ? arr[getRight(i, lastIdx)] : null;

		int largest = i;
		if (left != null && left.compareTo(curr) > 0
				&& (right == null || left.compareTo(right) > 0)) {
			largest = getLeft(i, lastIdx);
		} else if (right != null && right.compareTo(curr) > 0
				&& (left == null || right.compareTo(left) > 0)) {
			largest = getRight(i, lastIdx);
		}
		if (largest != i) {
			swap(arr, i, largest);
			maxHeapify(arr, largest, lastIdx);
		}
	}

	public static <T extends Comparable<T>> void buildHeap(T[] arr, int lastIdx) {

		for (int i = getParent(lastIdx, lastIdx); i >= 0; i--) {
			maxHeapify(arr, i, arr.length - 1);
		}
	}

	public static <T extends Comparable<T>> void removeTop(T[] arr, int idx) {
		T temp = arr[0];
		arr[0] = arr[idx];
		arr[idx] = temp;
	}

	private static <T extends Comparable<T>> void heapSort(T[] arr, int lastIdx) {

		buildHeap(arr, lastIdx);
		System.out.println("=" + Arrays.toString(arr));
		for (int i = 0; i <= lastIdx; i++) {
			removeTop(arr, lastIdx - i);
			maxHeapify(arr, 0, lastIdx - (i + 1));
			System.out.println("--" + Arrays.toString(arr));
		}

	}
}
