package pl.karnecki.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.karnecki.validator.DateFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode
public class Message {

    public static final String DATE_FORMAT = "dd-MMM-yy hh:mm:ss";
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
    @DateFormat(message = "Incorrect date format. Expecting " + DATE_FORMAT)
    private String timePlaced;
    @NotNull
    private String originatingCountry;
}
