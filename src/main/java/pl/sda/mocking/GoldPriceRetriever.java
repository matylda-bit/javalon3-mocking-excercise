package pl.sda.mocking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GoldPriceRetriever {
    private static final URI NBP_URI = java.net.URI.create("http://api.nbp.pl/api/cenyzlota/");
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public BigDecimal fetchGoldPrice() {
        HttpRequest request = HttpRequest.newBuilder(NBP_URI).build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            PriceResponse[] priceResponses = OBJECT_MAPPER.readValue(response.body(), PriceResponse[].class);
            return priceResponses[0].getPrice();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return BigDecimal.ZERO;
        }
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    private static class PriceResponse {
        @JsonProperty("cena")
        private BigDecimal price;
    }
}
