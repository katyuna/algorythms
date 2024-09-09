import sort.InsertionSort;
import sort.RadixSort;
import sort.Sortable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Integer> arrayNums = new ArrayList<>(Arrays.asList(120, 203, 130, 600, 500, 908, 456, 101, 999, 100, 107, 707));
        List<String> arrayStrings = new ArrayList<>(Arrays.asList("рот", "акт", "ярд", "вол"));

        System.out.print("Исходный массив чисел: ");
        for (int i = 0; i < arrayNums.size(); i++) {
            System.out.print(arrayNums.get(i) + " ");
        }
        System.out.println(" ");
        System.out.println(" ");

        //Сортировка вставками
        System.out.println("СОРТИРОВКА ВСТАВКАМИ");
        Sortable insertionSort = new InsertionSort(arrayNums);
        System.out.print("Отсортированный массив: ");
        insertionSort.sortList(arrayNums);
        insertionSort.printList(arrayNums);
        System.out.println(" ");
        System.out.println(" ");

        arrayNums = new ArrayList<>(Arrays.asList(120, 203, 130, 600, 500, 908, 456, 101, 999, 100, 107, 707));

        //Поразрядная сортировка для чисел
        System.out.println("ПОРАЗРЯДНАЯ СОРТИРОВКА");
        Sortable radixSort = new RadixSort(arrayNums);
        System.out.print("Отсортированный массив: ");
        radixSort.sortList(arrayNums);
        radixSort.printList(arrayNums);
        System.out.println(" ");

        arrayNums = new ArrayList<>(Arrays.asList(120, 203, 130, 600, 500, 908, 456, 101, 999, 100, 107, 707));

    }
}