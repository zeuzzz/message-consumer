package pl.karnecki.model;

import lombok.Data;
import lombok.EqualsAndHashCode;


/*
{"userId": "134256", "currencyFrom": "EUR", "currencyTo": "GBP", "amountSell": 1000,
"amountBuy": 747.10, "rate": 0.7471, "timePlaced" :
"24-JAN-15 10:27:44", "originatingCountry" : "FR"}
 */

@Data
@EqualsAndHashCode
public class Message {
    private Integer userId;
    private String currencyFrom;
    private String currencyTo;
    private Float amountSell;
    private Float amountBuy;
    private Float rate;
    private String timePlaced;
    private String originatingCountry;
}
