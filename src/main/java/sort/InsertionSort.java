package sort;

public class InsertionSort implements Sortable{

    int[] array;

    public InsertionSort(int[] array) {
        this.array = array;
    }

    @Override
    public void sortArray(int[] array) {
        //Предполагаем, что первый элемент уже отсортирован
        for (int i =1; i< array.length; i++){
            int key = array[i]; //Элемент, который нужно вставить в отсортированную часть
            int j = i-1; //Индекс последнего элемента в отсортированной части
             while (j>=0 && array[j]>key){ //Сравниваем элемент с последним в отсортированной части
                 array[j+1] = array[j]; //Если последний элемент в отсортированной части больше, то сдвигаем его вправо
                 j = j-1; //Переходим к предыдущему элементу в отсортированной части
             }
             array[j+1] = key;
        }
    }
}
