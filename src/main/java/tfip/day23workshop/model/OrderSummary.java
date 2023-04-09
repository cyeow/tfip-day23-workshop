package tfip.day23workshop.model;

import java.time.LocalDate;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class OrderSummary {

    private Integer orderId;
    private LocalDate orderDate;
    private Integer customerId;
    private Double total;
    private Double costPrice;

    public OrderSummary() {
    }

    public OrderSummary(Integer orderId, LocalDate orderDate, Integer customerId, Double total, Double costPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.total = total;
        this.costPrice = costPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    @Override
    public String toString() {
        return "OrderSummary [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId
                + ", total=" + total + ", costPrice=" + costPrice + "]";
    }

    public static OrderSummary create(SqlRowSet rs) {
        return new OrderSummary(
                rs.getInt("order_id"),
                LocalDate.parse(rs.getString("order_date")),
                rs.getInt("customer_id"),
                rs.getDouble("total"),
                rs.getDouble("cost_price"));
    }

}
