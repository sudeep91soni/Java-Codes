package geeksForGeeks.arrays;

public class FindEquilIndex {

	public static void main(String[] args) {
		getEquiIdx(new int[] { 10, 3, 4, 17, 2, 1, 7, 3, 9, 3, 11  });

	}

	private static void getEquiIdx(int[] arr) {

		int leftSum = 0;
		int rightSum = 0;
		int sum = getSum(arr);
		System.out.println(sum);
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				rightSum = sum - (leftSum + arr[i]);
			} else {
				rightSum = sum - (leftSum + arr[i - 1] + arr[i]);
			}
			leftSum = sum - (rightSum + arr[i]);
			System.out.println("leftSum rightSum: " + leftSum + " " + arr[i]
					+ " " + rightSum);
			if (leftSum == rightSum) {
				System.out.println(i);
			}
		}
		System.out.println("NAN");

	}

	private static int getSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

}
