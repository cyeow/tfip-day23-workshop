package tfip.day23workshop.repository;

public class DBQueries {
    public static final String GENERATE_ORDER_SUMMARY = "select order_id, order_date, customer_id, sum(od.quantity*od.unit_price*(1-od.discount)) as total, sum(od.quantity*p.standard_cost) as cost_price from orders o join order_details od on o.id = od.order_id left join products p on od.product_id = p.id where order_id = ?;";
}
