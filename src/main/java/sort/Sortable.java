package sort;

public interface Sortable {
    public void sortArray(int[] array);

    default void defaultPrintArrayMethod(int [] array){
        for(int i =0; i<array.length; i++){
            System.out.println(array[i] + ", ");
        }
    }
}
