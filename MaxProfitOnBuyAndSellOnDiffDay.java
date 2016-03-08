package geeksForGeeks.arrays;

public class MaxProfitOnBuyAndSellOnDiffDay {

	public static void main(String[] args) {

		System.out.println(maxDiff(new int[] { 2, 3, 10, 6, 4, 8, 1 }, 5));
		System.out.println(maxDiffEff(new int[] { 2, 3, 10, 6, 4, 8, 1 }, 5));
	}

	static int maxDiff(int arr[], int arr_size) {
		int max_diff = arr[1] - arr[0];
		int i, j;
		for (i = 0; i < arr_size; i++) {
			for (j = i + 1; j < arr_size; j++) {
				if (arr[j] - arr[i] > max_diff)
					max_diff = arr[j] - arr[i];
			}
		}
		return max_diff;
	}

	// Maintain min element before ith element... And update max diff if we get
	// some new big at ith pos
	static int maxDiffEff(int arr[], int arr_size) {
		int max_diff = arr[1] - arr[0];
		int min_element = arr[0];
		int i;
		for (i = 1; i < arr_size; i++) {
			if (arr[i] - min_element > max_diff)
				max_diff = arr[i] - min_element;
			if (arr[i] < min_element)
				min_element = arr[i];
		}
		return max_diff;
	}

}
