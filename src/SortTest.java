/**
 * @description: 实现所有的排序方法
 * @return:
 * @Author: M
 * @create: 2022/6/30 10:32
 */

public class SortTest {
    static void bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int t = arr[r];
            arr[r] = arr[l];
            arr[l] = t;
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {-1, 61, 53, -6, 12, 29, 35, 24, 976, 68, 797, 486};
        quickSort(numbers,0,2);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
