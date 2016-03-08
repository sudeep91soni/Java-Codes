package geeksForGeeks.arrays;

public class FloorCeilInSortedArray {

	public static void main(String[] args) {
		getFloorCeil(new int[] { 2, 4, 7, 9, 12, 15 }, 16, 0, 5);
	}

	private static void getFloorCeil(int[] arr, int k, int st, int en) {

		if (en < st) {
			return;
		}
		int mid = st + (en - st) / 2;
		if (arr[mid] == k) {
			System.out.println("Floor: " + arr[mid]);
			System.out.println("Ceil: " + arr[mid]);
		}
		if (mid + 1 <= en && arr[mid] < k && arr[mid + 1] > k) {
			System.out.println("Floor: " + arr[mid]);
			System.out.println("Ceil: " + arr[mid + 1]);
		} else if (mid == st || mid == en || st == en) {
			if (k < arr[mid]) {
				System.out.println("ceil is " + arr[mid]);
			} else if (k > arr[mid]) {
				System.out.println("floor is " + arr[mid]);
			}
		}

		else if (arr[mid] > k) {
			getFloorCeil(arr, k, st, mid);
		} else if (arr[mid] < k) {
			getFloorCeil(arr, k, mid + 1, en);
		}
	}
}
