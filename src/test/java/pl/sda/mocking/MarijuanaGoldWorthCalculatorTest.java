package pl.sda.mocking;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MarijuanaGoldWorthCalculatorTest {
    @Test
    void shouldTestHappyPath() {
        //given
        GoldPriceRetriever mockRetriever = mock(GoldPriceRetriever.class);
        when(mockRetriever.fetchGoldPrice()).thenReturn(new BigDecimal("205.32"));

        MarijuanaGoldWorthCalculator marijuanaGoldWorthCalculator = new MarijuanaGoldWorthCalculator(mockRetriever);
        //when
        BigDecimal actual = marijuanaGoldWorthCalculator.ouncesPerGoldKilo();
        //then
        BigDecimal expected = new BigDecimal("0.83");
        assertEquals(expected, actual);
    }

    @Test
    void shouldTestFreeGold() {
        //given
        GoldPriceRetriever mockRetriever = mock(GoldPriceRetriever.class);
        when(mockRetriever.fetchGoldPrice()).thenReturn(BigDecimal.ZERO);

        MarijuanaGoldWorthCalculator marijuanaGoldWorthCalculator = new MarijuanaGoldWorthCalculator(mockRetriever);
        //when
        BigDecimal actual = marijuanaGoldWorthCalculator.ouncesPerGoldKilo();
        //then
        BigDecimal expected = BigDecimal.ZERO;
        assertEquals(expected, actual);
    }

}