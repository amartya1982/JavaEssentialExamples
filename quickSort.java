public class quickSort {

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};

        System.out.println("Original Array:");
        printArray(array);

        quickSortFunction(array, 0, array.length - 1);

        System.out.println("Sorted Array:");
        printArray(array);
    }

    // Quick Sort function
    public static void quickSortFunction(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, low, high);

            // Recursively sort the elements before and after the partition
            quickSortFunction(array, low, pivotIndex - 1);
            quickSortFunction(array, pivotIndex + 1, high);
        }
    }

    // Partition function to place the pivot in the correct position
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Choosing the last element as the pivot
        int i = low - 1; // Index of the smaller element

        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (array[j] <= pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap the pivot element with the element at i + 1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Return the pivot index
    }

    // Utility function to print the array
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
