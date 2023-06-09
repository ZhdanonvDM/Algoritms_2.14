package pro.sky;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
      IntegerListImpl s = new IntegerListImpl();
       fillBase(s);
        printStringList(s);
        System.out.println(s.containsBinary((Integer)4));

//      Тестирование методов рекурсивной сортировки
/*        long start = System.currentTimeMillis();
        int[] testArray = generateRandomArray();
        mergeSort(Arrays.copyOf(testArray, testArray.length));
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        quickSort(Arrays.copyOf(testArray, testArray.length), 0, testArray.length-1);
        System.out.println(System.currentTimeMillis() - start);*/

//      Тестирование методов сортировки

/*        long start = System.currentTimeMillis();

        //Пузырьковая сортировка
        sortBubble(Arrays.copyOf(testArray, testArray.length));
        System.out.println(System.currentTimeMillis() - start);

        //Сортировка выбором
        start = System.currentTimeMillis();
        sortSelection(Arrays.copyOf(testArray, testArray.length));
        System.out.println(System.currentTimeMillis() - start);

        //Сортировка вставкой
        start = System.currentTimeMillis();
        sortInsertion(Arrays.copyOf(testArray, testArray.length));
        System.out.println(System.currentTimeMillis() - start);*/
    }




    //Методы рекурсивной сортировки
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }
    public static void merge(int[] arr, int[] left, int[] right) {
        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }



    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }


    //Методы сортировки
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }



    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[1_000_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000) + 10000;
        }
        return arr;
    }



    public static void printStringList(IntegerListImpl s) {
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }
        System.out.println();
    }
    public static void fillBase (IntegerListImpl s) {
        s.add(1);
        s.add(3);
        s.add(2);
        s.add(8);
        s.add(0);
        s.add(4);
    }

}