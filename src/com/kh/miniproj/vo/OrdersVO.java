package com.kh.miniproj.vo;
import java.math.BigDecimal;
import java.sql.Date;
public class OrdersVO {

        private String order_id;
        private String customer_id;
        private String product_id;
        private BigDecimal total_cost;
        private Date order_date;
        private String payment_method;
        private String shipping_address;

        public OrdersVO(String order_id, String customer_id, BigDecimal total_cost, Date order_date,
                        String payment_method, String shipping_address) {
            this.order_id = order_id;
            this.customer_id = customer_id;
            this.total_cost = total_cost;
            this.order_date = order_date;
            this.payment_method = payment_method;
            this.shipping_address = shipping_address;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public BigDecimal getTotal_cost() {
            return total_cost;
        }

        public void setTotal_cost(BigDecimal total_cost) {
            this.total_cost = total_cost;
        }

        public Date getOrder_date() {
            return order_date;
        }

        public void setOrder_date(Date order_date) {
            this.order_date = order_date;
        }

        public String getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(String payment_method) {
            this.payment_method = payment_method;
        }

        public String getShipping_address() {
            return shipping_address;
        }

        public void setShipping_address(String shipping_address) {
            this.shipping_address = shipping_address;
        }
    }

