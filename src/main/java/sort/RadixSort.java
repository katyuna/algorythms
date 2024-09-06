package sort;
import java.util.List;

public class RadixSort implements Sortable {
    /*Поразрядная сортировка: смысл алгоритма - сначала сортируем по единицам, потом по десяткам, потом по сотням и т.д
    Асимптотическая сложность О(n), но требуется дополнительная память для хранения счетчика.
    Эффективен для сортировки чисел и строк фиксированной длины.
    При этом должен быть известен размер алфавита.
    Размер счетчика равен размеру алфавита.
    Пример: Допустим все числа в массиве в диапазоне от 0 до 999. Т.е. 3 разряда: единицы, десятки, сотни. При этом известно, что в каждом разряде может быть цифра от 0 до 9 т.е. размер счетчика 10
    Если строки, то разрядность - количество букв, размер алфавита = количество букв в алфавите.
     */
    List<Integer> array;

    public RadixSort(List<Integer> array) {
        this.array = array;
    }

    @Override
    public <T extends Comparable<T>> void sortArray(List<T> array) {
        // Проверяем, что элементы массива - это Integer
        if (array.get(0) instanceof Integer) {
            sortIntegers((List<Integer>) array);
        } else if (array.get(0) instanceof String) {
            sortStrings((List<String>) array);
        } else {
            throw new UnsupportedOperationException("Реализован метод только для Integer и String");
        }
    }

    private void sortIntegers(List<Integer> array) {
        int max = findMax(array); // Находим максимальное число, чтобы определить количество разрядов
        // Проходим по каждому разряду
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSortForInteger(array, exp);
        }
    }

    private void sortStrings(List<String> array) {

    }

    // Метод для нахождения максимального числа в массиве
    private int findMax(List<Integer> array) {
        int max = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        return max;
    }

    //Метод сортировки по разряду
    private void countSortForInteger(List<Integer> array, int exp) {
        int n = array.size();
        int[] output = new int[n]; // Временный массив для хранения результата сортировки по текущему разряду
        int[] counter = new int[10]; // Счетчик для каждого значения разряда (0-9)


        /* Заполняем счетчик.
        Начинаем с самого младшего разряда и посчитаем сколько раз каждая цифра встречается в разряде.
        Запишем в счетчик количество нулей - в позицию 0, количество единиц - 1 и т.д., девяток в позицию 9.
        */

        for (int i = 0; i < n; i++){
            //Получаем цифру в разряде путем нахождения остатка от деления
            int digit = (array.get(i) / exp) % 10;
            //Увеличиваем соответсвующую позицию в счетчике
            counter[digit]++;
        }


        /* Изменяем count[i], чтобы он содержал фактическую позицию этого разряда в output.
         Т.е. нужно вычислить, где должны располагаться элементы в выходном массиве.
        Сначала должны идти все элементы с цифрой 0, потом все элементы с цифрой 1, потом - 2 и тд.
        Для этого с помощью префиксной суммы нужно вычислить значения, которые показывают, сколько элементов должно быть до цифры i в отсортированном порядке.
        */
        for (int i = 1; i < 10; i++) {
            counter[i] += counter[i - 1];
        }
        // Создаем отсортированный массив на основе текущего разряда
        for (int i = n - 1; i >= 0; i--) {
            int digit = (array.get(i) / exp) % 10;
            output[counter[digit] - 1] = array.get(i);
            counter[digit]--;
        }

        // Копируем отсортированные элементы в исходный массив
        for (int i = 0; i < n; i++) {
            array.set(i, output[i]);
        }
    }

}

