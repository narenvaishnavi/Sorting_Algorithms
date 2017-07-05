/*
    Date: 11th May,2017
    @Author: Naren Vaishnavi
    Modified Quick Sort 
      - Median of 3 as pivot.
      - For small subproblem size = 15, insertion sort is used.
*/
package modifiedquicksort;

import java.util.Arrays;
import java.util.Random;

public class ModifiedQuickSort {
    
    private static final Random random = new Random();
    private static final int RANDOM_INT_RANGE = 25;

    public static void main(String[] args) {
      	long time1 = System.currentTimeMillis();
        System.out.print("Time Taken:" + time1);
        int[] arr = assignValues(10);
        System.out.println("Before Sorting " + Arrays.toString(arr));
        if(arr.length >0)
        quickSort(arr, 0, arr.length - 1);
        System.out.print("Sorted Array:");
        for (int i : arr) {
            System.out.println(i);
        }
        long time = System.currentTimeMillis();
        System.out.print(time);
    }

    private static int[] assignValues(int size) {
        final int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(RANDOM_INT_RANGE);
        }
        return arr;
    }

    public static void quickSort(int[] arr, int left, int right) {
        
          if (left + 15 <= right) {
            
            double median = medianPivot(arr, left, right);
            int partition = InplacePartition(arr, left, right, median);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
            
        } else {
            
            doInsertionSort(arr);

        }
    }

    public static int medianPivot(int[] intArray, int left, int right) {
        int center = (left + right) / 2;

        if (intArray[left] > intArray[center]) {
            swap(intArray, left, center);
        }

        if (intArray[left] > intArray[right]) {
            swap(intArray, left, right);
        }

        if (intArray[center] > intArray[right]) {
            swap(intArray, center, right);
        }

        swap(intArray, center, right - 1);
        return intArray[right - 1];
    }

    public static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static int InplacePartition(int[] arr, int left, int right, double pivot) {
        int leftPos = left;
        int rightPos = right - 1;

        while (true) {
            while (arr[++leftPos] < pivot);
            while (arr[--rightPos] > pivot);
            if (leftPos >= rightPos) {
                break;
            } else {
                swap(arr, leftPos, rightPos);
            }
        }
        swap(arr, leftPos, right - 1);
        return leftPos;
    }

    public static void doInsertionSort(int[] array) {
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

    }

}
