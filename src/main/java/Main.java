import sort.InsertionSort;
import sort.Sortable;

public class Main {
    public static void main(String[] args) {

        int[] array = {12, 23, 13, 6, 5};
        Sortable insertionSort = new InsertionSort(array);

        System.out.println("Исходный массив: ");


        System.out.println("Массив, отсортированный вставками: ");
        insertionSort.sortArray(array);



    }
}