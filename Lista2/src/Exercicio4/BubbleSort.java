package Exercicio4;

public class BubbleSort {
    public long bubbleSort(int[] array) {
        long swapCounter = 0;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {

                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;

                    swapped = true;
                    swapCounter++;
                }
            }
        } while (swapped);

        return swapCounter;
    }
}
