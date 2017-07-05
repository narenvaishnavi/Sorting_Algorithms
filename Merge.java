package merge;

/*
    Date: 12th May,2017
    @Author: Naren Vaishnavi
    Merge Sort with time complexity of O(nlogn).
 */
import java.util.Arrays;
import java.util.Random;

public class Merge {

    int[] array;
    int[] temp;
    int length;
    private static final Random random = new Random();
    private static final int RANDOM_INT_RANGE = 100000;

    public static void main(String a[]) {
        long time1 = System.currentTimeMillis();
        System.out.print("Time Taken:" + time1);
        int[] arr = newArray(40000);
        System.out.println("Starting array: " + Arrays.toString(arr));
        //int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        Merge merge = new Merge();
        merge.sort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
        long time = System.currentTimeMillis();
        System.out.print("Time Taken:" + time);

    }

    private static int[] newArray(int size) {
        final int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(RANDOM_INT_RANGE);
        }
        return arr;
    }

    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.temp = new int[length];
        doMergeSort(0, length - 1);
    }

    public void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    public void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            temp[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = temp[i];
            k++;
            i++;
        }

    }
}
