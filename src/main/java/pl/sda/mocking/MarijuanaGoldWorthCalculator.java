package pl.sda.mocking;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MarijuanaGoldWorthCalculator {

    private static final BigDecimal WEED_OZ_PRICE = new BigDecimal("248.78");
    private GoldPriceRetriever goldPriceRetriever;

    public MarijuanaGoldWorthCalculator(GoldPriceRetriever goldPriceRetriever) {
        this.goldPriceRetriever=goldPriceRetriever;
    }

    public BigDecimal ouncesPerGoldKilo() {
        return goldPriceRetriever.fetchGoldPrice().divide(WEED_OZ_PRICE, RoundingMode.UP);
    }
}
