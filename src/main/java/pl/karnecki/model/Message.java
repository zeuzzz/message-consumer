package pl.karnecki.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/*
{"userId": "134256", "currencyFrom": "EUR", "currencyTo": "GBP", "amountSell": 1000,
"amountBuy": 747.10, "rate": 0.7471, "timePlaced" :
"24-JAN-15 10:27:44", "originatingCountry" : "FR"}
 */

@Data
@EqualsAndHashCode
public class Message {
    @NotNull
    private Integer userId;
    @NotNull
    private String currencyFrom;
    @NotNull
    private String currencyTo;
    @Min(value = 0)
    private Float amountSell;
    @Min(value = 0)
    private Float amountBuy;
    @NotNull
    private Float rate;
    @NotNull
    private String timePlaced;
    @NotNull
    private String originatingCountry;
}
