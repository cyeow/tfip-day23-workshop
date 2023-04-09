package tfip.day23workshop.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import tfip.day23workshop.model.OrderSummary;
import static tfip.day23workshop.repository.DBQueries.*;

@Repository
public class OrderRepository {
    
    @Autowired
    private JdbcTemplate jdbc;

    public OrderSummary generateOrderSummary(Integer orderId) {
        SqlRowSet rs = jdbc.queryForRowSet(GENERATE_ORDER_SUMMARY, orderId);

        OrderSummary os = null;
        while(rs.next()) {
            os = OrderSummary.create(rs);
        }
        
        return os;
    }


}
