package pro.sky;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
      IntegerListImpl s = new IntegerListImpl();
        fillBase(s);
        System.out.println(s.containsBinary((Integer)8));


/*//      Тестирование методов сортировки

        int[] testArray = generateRandomArray();
        long start = System.currentTimeMillis();

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
        int[] arr = new int[100_000];
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