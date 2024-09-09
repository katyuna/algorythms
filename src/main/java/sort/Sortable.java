package sort;

import java.util.List;

public interface Sortable {
    /*
    Чтобы метод sortArray работал как для чисел, так и для строк (и любых других объектов, которые можно сравнивать),
    нужно использовать ограничение на тип T в параметре метода, указав,
    что T должен реализовывать интерфейс Comparable<T>.
    Это позволяет сравнивать элементы друг с другом.
     */
    <T extends Comparable<T>> void sortList (List<T> array);
    //public <T> void sortArray(List<T> array);


    default <T> void printList (List<T> array){
        for(int i =0; i<array.size(); i++){
            System.out.print(array.get(i) + " ");
        }
    }
}
