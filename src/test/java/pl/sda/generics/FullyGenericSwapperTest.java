package pl.sda.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FullyGenericSwapperTest {
    @Test
    void shouldSwapInts() {
        //given
        Integer[] array = {1, 2, 3, 4};
        FullyGenericSwapper<Integer> swapper = new FullyGenericSwapper<>(array);

        //when
        swapper.swap();

        //then
        Integer[] expectedArray = {4, 2, 3, 1};
        assertArrayEquals(expectedArray, array);
    }

    @Test
    void shouldSwapStrings() {
        //given
        String[] array = {"ala", "ma", "kota"};
        FullyGenericSwapper<String> swapper = new FullyGenericSwapper<>(array);

        //when
        swapper.swap();

        //then
        String[] expectedArray = {"kota", "ma", "ala"};
        assertArrayEquals(expectedArray, array);
    }

}