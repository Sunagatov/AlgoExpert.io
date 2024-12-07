package sorting;

public class InsertionSort {

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int current = array[i];
			int j = i - 1;
			while(j >= 0 && current < array[j]) {
				array[j+1] = array[j];
				j--;
			}
			// в этой точке мы вышли, так что j так же -1
			// или в первом элементе, где текущий >= a[j]
			array[j+1] = current;
		}
	}
}
