package geeksForGeeks.arrays;

public class MaxContiguousSumInArray {

	public static void main(String[] args) {
		int[] arr = new int[] { -2, 4, -1, 0, 7, -1 };
		int getMaxSum = getMaxSum(arr);
		System.out.println(getMaxSum);
	}

	// Kadane algo
	private static int getMaxSum(int[] arr) {
		int currMax = arr[0];
		int maxSoFar = arr[0];
		for (int i = 1; i < arr.length; i++) {
			currMax = Math.max(arr[i], currMax + arr[i]);
			maxSoFar = Math.max(currMax, maxSoFar);
		}
		return maxSoFar;
	}
}
