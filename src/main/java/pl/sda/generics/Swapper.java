package pl.sda.generics;

public class Swapper {

    public <T> void swap (T [] array){
        T temp = array [0];
        array[0] = array [array.length -1];
        array [array.length-1] = temp;

    }

}
