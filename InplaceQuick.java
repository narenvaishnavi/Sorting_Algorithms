/*
    Date: 11th May,2017
    @Author: Naren Vaishnavi
    Inplace Quick Sort 
*/
package InplaceQuick;

import java.util.Arrays;
import java.util.Random;

public class InplaceQuick {

    private static final Random random = new Random();
    private static final int RANDOM_INT_RANGE = 100000;

    public static void main(String[] args) {
	long time1 = System.currentTimeMillis();
        System.out.print("Time Taken:" + time1);

        int[] arr = assignValues(100000);
        System.out.println("Before Sorting " + Arrays.toString(arr));

        if (arr.length > 0) {
            inPlaceQuick(arr, 0, arr.length - 1);
        }

        System.out.println("Sorted array: " + Arrays.toString(arr));
        long time = System.currentTimeMillis();
        System.out.print("Time Taken:" + time);

    }

    private static int[] assignValues(int size) {
        final int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(RANDOM_INT_RANGE);
        }
        return arr;
    }

    private static void inPlaceQuick(int[] arr, int left, int right) {

        if (left >= right) {
            return; // sorted
        }
        final int range = right - left + 1;
        int pivot = random.nextInt(range) + left;
        int newPivot = InplacePartition(arr, left, right, pivot);
        inPlaceQuick(arr, left, newPivot - 1);
        inPlaceQuick(arr, newPivot + 1, right);

    }

    private static int InplacePartition(int[] arr, int left, int right, int pivot) {

        int pivotVal = arr[pivot];

        swap(arr, pivot, right);

        int indexValue = left;
        for (int i = left; i <= (right - 1); i++) {
            if (arr[i] < pivotVal) {
                swap(arr, i, indexValue);
                indexValue++;
            }
        }
        swap(arr, indexValue, right);
        return indexValue;
    }

    private static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
