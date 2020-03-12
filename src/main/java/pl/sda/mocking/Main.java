package pl.sda.mocking;

public class Main {
    public static void main(String[] args) {
        System.out.println("Gold price for today is: " + new GoldPriceRetriever().fetchGoldPrice());
        GoldPriceRetriever goldPriceRetriever = new GoldPriceRetriever();
        Alerter alerter = new Alerter();
        MarijuanaGoldWorthCalculator marijuanaGoldWorthCalculator = new MarijuanaGoldWorthCalculator(goldPriceRetriever, alerter);
        System.out.println(marijuanaGoldWorthCalculator.ouncesPerGoldOz());

    }
}
