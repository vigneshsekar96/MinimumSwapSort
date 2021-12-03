
public class MinSwaps {
    public static void main(String[] args) {
        long[] arr = new long[]{8, 7, 6, 5, 1, 2, 3, 4};
        System.out.println(minSwaps(arr));
    }

    private static long minSwaps(long[] sorted) {

        long[] arr = copyArr(sorted);
        sortArray(sorted);

        long swaps = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] != arr[i]) {
                int index = findIndex(arr, sorted[i]);
                long temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                swaps++;
            }
        }
        return swaps;

    }

    private static long[] copyArr(long[] arr) {
        long[] copy = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    private static long[] sortArray(long[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                long min = arr[i];
                if (min > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = min;
                }
            }
        }
        return arr;
    }

    private static int findIndex(long[] arr, long l) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == l) {
                return i;
            }
        }
        return -1;
    }
}