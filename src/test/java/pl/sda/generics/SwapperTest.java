package pl.sda.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SwapperTest {
    @Test
    void shouldSwapInts() {
        //given
        Integer[] array = {1, 2, 3, 4};
        Swapper swapper = new Swapper();

        //when
        swapper.swap(array);

        //then
        Integer[] expectedArray = {4, 2, 3, 1};
        assertArrayEquals(expectedArray, array);
    }

    @Test
    void shouldSwapStrings() {
        //given
        String[] array = {"ala", "ma", "kota"};
        Swapper swapper = new Swapper();

        //when
        swapper.swap(array);

        //then
        String[] expectedArray = {"kota", "ma", "ala"};
        assertArrayEquals(expectedArray, array);
    }


}