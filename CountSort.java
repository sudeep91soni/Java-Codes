package geeksForGeeks.sorting;

import java.util.Arrays;

public class CountSort {

	static void countSort(Integer[] arr) {
		Integer max = getMax(arr);
		Integer min = getMin(arr);
		Integer[] count = new Integer[max - min + 1];

		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - min]++;
		}
		System.out.println(Arrays.toString(count));

		for (int i = 0, j = 0; i < count.length; i++) {
			int value = i + min;
			while (count[i] > 0) {
				arr[j++] = value;
				count[i]--;
			}
		}
	}

	private static Integer getMin(Integer[] arr) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	public static void main(String[] args) {

		Integer[] arr = new Integer[] { 7, -7, -3, -3, 6, 6, 3, 0};
		System.out.println(Arrays.toString(arr));
		countSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static Integer getMax(Integer[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
}
