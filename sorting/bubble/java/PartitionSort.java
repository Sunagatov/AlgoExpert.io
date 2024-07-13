public class PartitionSort {

	static int partition(int[] array, 
			     int begin, 
			     int end) {
		int pivot = end;
		int counter = begin;
		for (int i = begin; i < end; i++) {
			if (array[i] < array[pivot]) {
				int temp = array[counter];
				array[counter] = array[i];
				array[i] = temp;
				counter++;
			}
		}
		int temp = array[pivot];
		array[pivot] = array[counter];
		array[counter] = temp;

		return counter;
	}
}
