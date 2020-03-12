package pl.sda.mocking;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarijuanaGoldWorthCalculatorTest {
    @Test
    void shouldTestHappyPath() {
        //given
        GoldPriceRetriever mockRetriever = Mockito.mock(GoldPriceRetriever.class);
        Mockito.when(mockRetriever.fetchGoldPrice()).thenReturn(new BigDecimal("205.32"));
        Alerter alerter = Mockito.mock(Alerter.class);

        MarijuanaGoldWorthCalculator marijuanaGoldWorthCalculator = new MarijuanaGoldWorthCalculator(mockRetriever, alerter);
        //when
        BigDecimal actual = marijuanaGoldWorthCalculator.ouncesPerGoldOz();
        //then
        BigDecimal expected = new BigDecimal("0.83");
        assertEquals(expected, actual);
    }

    @Test
    void shouldTestFreeGold() {
        //given
        GoldPriceRetriever mockRetriever = Mockito.mock(GoldPriceRetriever.class);
        Mockito.when(mockRetriever.fetchGoldPrice()).thenReturn(BigDecimal.ZERO);
        Alerter alerter = Mockito.mock(Alerter.class);

        MarijuanaGoldWorthCalculator marijuanaGoldWorthCalculator = new MarijuanaGoldWorthCalculator(mockRetriever, alerter);
        //when
        BigDecimal actual = marijuanaGoldWorthCalculator.ouncesPerGoldOz();
        //then
        BigDecimal expected = BigDecimal.ZERO;
        assertEquals(expected, actual);
    }

    // Interaction testing

    @Test
    void shouldAlertFreeWeed() {
        //given
        GoldPriceRetriever mockRetriever = Mockito.mock(GoldPriceRetriever.class);
        Mockito.when(mockRetriever.fetchGoldPrice()).thenReturn(BigDecimal.ZERO);
        Alerter alerter = Mockito.mock(Alerter.class);

        MarijuanaGoldWorthCalculator marijuanaGoldWorthCalculator = new MarijuanaGoldWorthCalculator(mockRetriever, alerter);
        //when
        marijuanaGoldWorthCalculator.ouncesPerGoldOz();
        //then
        Mockito.verify(alerter).alert();
    }

}