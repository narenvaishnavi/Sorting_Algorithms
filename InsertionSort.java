/*
    Date: 10th May,2017
    @Author: Naren Vaishnavi
    Insertion Sort with time complexity of O(n2).
*/
package insertionsort;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    private static final Random random = new Random();
    private static final int RANDOM_INT_RANGE = 10;

    public static void main(String args[]) {
	long time1 = System.currentTimeMillis();
        System.out.print("Time Taken:" + time1);
        int[] arrsize = assignValues(10000); // call to assignValues method
        System.out.println("Before Sorting: " + Arrays.toString(arrsize));
        int[] arr2 = doInsertionSort(arrsize);
        
        System.out.println("After Sorting: " + Arrays.toString(arr2));
        // time taken to run the algorithm
        long time = System.currentTimeMillis();
        System.out.print("Time Taken:" + time);

    }

    private static int[] assignValues(int size) {
        final int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(RANDOM_INT_RANGE);
        }
        return array;
    }

    // insertion algorithm implementation
    public static int[] doInsertionSort(int[] array) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;

        }
        return array;
    }

}
