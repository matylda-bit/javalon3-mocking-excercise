package pl.sda.mocking;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MarijuanaGoldWorthCalculator {
    private static final BigDecimal WEED_OZ_PRICE = new BigDecimal("248.78");
    private GoldPriceRetriever goldPriceRetriever;
    private Alerter alerter;

    public BigDecimal ouncesPerGoldOz() {
        BigDecimal ouncesPerGoldOz = goldPriceRetriever.fetchGoldPrice().divide(WEED_OZ_PRICE, RoundingMode.UP);
        if(ouncesPerGoldOz.equals(BigDecimal.ZERO)) {
            alerter.alert();
        }
        return ouncesPerGoldOz;
    }

    public MarijuanaGoldWorthCalculator(GoldPriceRetriever goldPriceRetriever, Alerter alerter) {
        this.goldPriceRetriever = goldPriceRetriever;
        this.alerter = alerter;
    }
}
