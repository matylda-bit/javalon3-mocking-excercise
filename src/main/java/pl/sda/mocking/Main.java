package pl.sda.mocking;

public class Main {
    public static void main(String[] args) {
        System.out.println("Gold price for today is: " + new GoldPriceRetriever().fetchGoldPrice());
    }
}
