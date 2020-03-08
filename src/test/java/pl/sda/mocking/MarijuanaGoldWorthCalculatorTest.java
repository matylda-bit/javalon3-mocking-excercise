package pl.sda.mocking;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MarijuanaGoldWorthCalculatorTest {
    @Test
    void should() {
        //given
        MarijuanaGoldWorthCalculator marijuanaGoldWorthCalculator = new MarijuanaGoldWorthCalculator(() -> new BigDecimal("205.32"));
        //when
        BigDecimal actual = marijuanaGoldWorthCalculator.ouncesPerGoldKilo();
        //then
        BigDecimal expected = new BigDecimal("0.83");
        assertEquals(expected, actual);
    }
    class FakeGoldPriceRetriever implements GoldPriceRetriever{

        @Override
        public BigDecimal fetchGoldPrice() {
            return new BigDecimal("205.32");
        }


    }

}