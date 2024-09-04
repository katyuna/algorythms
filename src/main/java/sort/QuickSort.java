package sort;

import java.util.List;

public class QuickSort implements Sortable {
    /*Сначала выбирается элемент массива, который будет использоваться как опорный.
    Обычно это последний элемент в рассматриваемом диапазоне.

    Массив разбивается на две части:
    Одна часть содержит элементы, которые меньше или равны опорному элементу.
    Другая часть содержит элементы, которые больше опорного элемента.

    Для этого все элементы сравниваются с опорным, и те, которые меньше или равны ему, перемещаются в одну часть массива, а остальные — в другую. Это называется "разбиение" (partitioning).

    После разбиения массива, алгоритм рекурсивно применяет тот же процесс к двум полученным частям (до и после опорного элемента).

    После рекурсивной сортировки обеих частей, массив будет отсортирован. Поскольку каждая часть будет отсортирована, весь массив окажется отсортированным.
     */
    @Override
    public <T extends Comparable<T>> void sortArray(List<T> array) {

    }
}
