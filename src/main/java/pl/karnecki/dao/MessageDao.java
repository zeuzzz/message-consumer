package pl.karnecki.dao;

import lombok.Setter;
import lombok.SneakyThrows;
import pl.karnecki.model.Message;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Setter
public class MessageDao {

    private DataSource dataSource;
    public static final String INSERT = "INSERT INTO message(" +
            " user_id, currency_from, currency_to, amount_sell, amount_buy, " +
            " rate, time_placed, originating_country) " +
            "VALUES(?,?,?,?,?,?,?,?)";

    @SneakyThrows(ParseException.class)
    public void insert(Message message) {
        Connection conn = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Message.DATE_FORMAT);

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT);
            ps.setInt(1, message.getUserId());
            ps.setString(2, message.getCurrencyFrom());
            ps.setString(3, message.getCurrencyTo());
            ps.setInt(4, (int)Math.floor(message.getAmountSell() * 100));
            ps.setInt(5, (int) Math.floor(message.getAmountBuy() * 100));
            ps.setFloat(6, message.getRate());
            ps.setTimestamp(7, new Timestamp(simpleDateFormat.parse(message.getTimePlaced()).getTime()));
            ps.setString(8, message.getOriginatingCountry());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}
