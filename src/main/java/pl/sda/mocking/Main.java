package pl.sda.mocking;

public class Main {
    public static void main(String[] args) {
        System.out.println("Gold price for today is: " + new GoldPriceRetrieverImpl().fetchGoldPrice());
  GoldPriceRetrieverImpl goldPriceRetriever = new GoldPriceRetrieverImpl();
   MarijuanaGoldWorthCalculator marijuanaGoldWorthCalculator = new MarijuanaGoldWorthCalculator(goldPriceRetriever);

        System.out.println(marijuanaGoldWorthCalculator.ouncesPerGoldKilo());

    }
}
