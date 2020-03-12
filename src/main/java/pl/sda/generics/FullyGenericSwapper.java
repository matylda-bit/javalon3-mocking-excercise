package pl.sda.generics;

public class FullyGenericSwapper<T> {
    private T[] array;

    public FullyGenericSwapper(T[] array) {
        this.array = array;
    }

    public void swap() {
        T temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;
    }

}
