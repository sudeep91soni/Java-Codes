package geeksForGeeks.random;

import java.util.Arrays;

public class Return1sComplement {

	public static void main(String[] args) {
		int n = 6;
				
		int bitCount = 0;
		
		int temp = n;

		while (temp > 0) {
			temp /= 2;
			bitCount++;
		}

		int[] arr = new int[bitCount];

		temp = n;
		int i = bitCount;
		while (temp > 0) {
			arr[--i] = temp % 2;
			temp /= 2;
		}
		for (int j = 0; j < bitCount; j++) {
			arr[j] = arr[j] == 0 ? 1 : 0;
		}

		int number = 0;
		for (int j = 0; j < bitCount; j++) {
			number += arr[bitCount - (j + 1)] * Math.pow(2, j);
		}
		System.out.println(number);

	}
}
